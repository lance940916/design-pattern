# 个人白话简介
对象创建型模式
单例模式即：定义一个类，该类**只有**并且**只能有**一个实例提供给外部。

# 1 模式动机
有时候，系统中需要某个类只允许有一个实例。比如 ID 序列生成器，如果存在多个的话，就会出现重复的 ID。

通常这些资源最好在系统启动时预先加载好，以便进行响应处理的时候马上可用。宁可系统启动慢也不要响应慢。

# 2 模式定义
单例模式（Singleton Pattern）：单例模式确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例，这个类称为单例类，它提供全局访问的方法。

**单例模式的特点**有三个：

1. 它只能有一个实例。
2. 它必须自行创建这个实例。
3. 它必须自行向整个系统提供这个实例的访问方法。

单例模式是一种**对象创建型模式**。
单例模式又名**单件模式**或**单态模式**。

# 3 模式结构
单例模式的模式结构很简单，只有一个单例类。

- 单例类：包含一个实例且能自行创建这个实例的类。

# 4 模式代码
单例模式分为**饿汉式**和**懒汉式**。

- 饿汉式就是不管你用不用，只要进行了类加载就把实例创建出来。（其实饿汉式就挺好的，系统启动时进行加载即可，只是拖慢了启动速度而已。）
- 懒汉式相反，只有在你需要用的时候我才会去创建实例。

由于他们的性质决定了饿汉式没有线程问题（通常使用 Spring 框架启动时，它所管理的 bean 默认都是单例的），而懒汉式会存在。

## 4.1 饿汉式
饿汉式天生就是线程安全的，直接用于多线程不会出现问题。
``` java
public class Single {
    private static final Single single = new Single();
    private Single(){} // 构造方法私有化
    public static Single getInstance() {
        return single;
    }
}
```
但是上面的方法是不安全的，为什么这么说呢？

1. 可以通过反射中的`AccessibleObject.setAccessible`来修改构造方法的权限。
2. 可以通过序列化反序列的方式创建第二个实例。

解决方法：使用枚举来代替。
为什么枚举就可以？

- 反射问题：当执行`newInstance`的时候，源码中会有一个`if ((clazz.getModifiers() & Modifier.ENUM) != 0)`的校验，发现是枚举就抛异常了。
- 序列化问题：可以看一下`ObjectInputStram#readObject`的方法，很好找，有一个`readEnum`的方法，里面使用了`Enum<?> en = Enum.valueOf((Class)cl, name);`来生成枚举实例，这个方法会保证枚举的单例。

## 4.2 懒汉式-使用简单的null判断
``` java
public class Single {
    private static Single single;
    private Single(){} // 构造方法私有化
    public static Single getInstance() {
        if (single == null) {
            single = new Single();
        }
        return single;
    }
}
```
这种方法一定存在线程安全问题。多个线程可能同时进行`single == null`的判断，从而也就会产生多个实例了。

## 4.3 懒汉式-给方法加上synchronized
``` java
public class Single {
    private static Single single;
    private Single(){} // 构造方法私有化
    public static synchronized Single getInstance() {
        if (single == null) {
            single = new Single();
        }
        return single;
    }
}
```
由于使用了 synchronzied 关键字，在线程安全方面是没问题的，但是在性能上会有问题。抛开创建实例来说，每次来获取实例都会进行加锁和解锁，大大降低了系统性能（即使使用了偏向锁、轻量级锁等技术，在多线程竞争激烈的场景下也是不容乐观的）。

## 4.4 懒汉式-双检测锁机制
``` java
public class Single {
    private static Single single;
    private Single(){} // 构造方法私有化
    public static Single getInstance() {
        if (single == null) {
            synchronized(Single.class) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }
}
```
这种方式对前者进行了升级，将加锁放入方法内部，并且两次检查了实例是否为null，当创建实例之后，新来的线程再次获取实例时，不会进行加锁和解锁，对性能没影响。

**问题所在：**
这里的`single = new Single();`并不是原子性操作，所以可能会因为**重排序**导致可见性问题。

**解释：**
`single = new Single();`可以分解为一下三步：
```
memory = allocate();   // 1: 分配对象的内存空间
ctorInstance(memory);　// 2: 初始化对象
instance = memory;     // 3: 设置instance指向刚分配的内存地址
```
上面代码的2和3**可能**会重排序，重排序之后的代码如下：
```
memory = allocate();   // 1: 分配对象的内存空间
instance = memory;     // 3: 设置instance指向刚分配的内存地址
ctorInstance(memory);　// 2: 初始化对象
```
假设线程A正在执行重排序的代码，执行完1和3之后(这时并没有执行2，**没有初始化对象**)，线程B进入方法来获取实例，判断一下，实例对象不是null，因为步骤3被线程A执行了，那么线程B就会去使用实例对象，使用一个未初始化的实例对象，就会出现问题了。

如何解决呢？使用`volatile`关键字来修饰实例对象。
关于 volatile 关键字只说一点：**它会禁止上面的这种重排序**。具体如何实现的这里就不说了。

## 4.5 懒汉式-基于静态内部类的方式
``` java
public class Single {
    private Single(){} // 构造方法私有化
    private static class SingleInstance {
        public static final Single single = new Single();
    }
    public static Single getInstance() {
        return SingleInstance.single;
    }
}
```
其实这里也是使用了锁，只不过是类加载锁，由 JVM 自己控制的。因为 JVM 会保证**一个类在一个类加载器下只能被加载一次**。这种实现还是挺简单的哈。

# 5 总结

**分析**

- 单例模式的目的是保证一个类仅有一个实例，并提供一个访问它的全局访问点。
- 单例类拥有一个私有构造函数，确保用户无法通过 new 关键字直接实例化它。除此之外，该模式中包含一个静态私有成员变量与静态公有的方法。该方法负责检验实例是否存在并实例化自己，然后存储在静态成员变量中，以确保只有一个实例被创建。

**优点**

- 提供了对唯一实例的受控访问并可以节约系统资源。

**缺点**

- 因为缺少抽象层而难以扩展，且单例类职责过重。

**应用场景**

- 系统只需要一个实例对象。
- 客户调用类的单个实例只允许使用一个公共访问点。

**扩展**

单例模式可以扩展为多例模式，比如数据库连接池、网络连接池或者多线程池等等。

# 参考资料

- [图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/index.html)
- [Java设计模式](http://c.biancheng.net/view/1317.html)

