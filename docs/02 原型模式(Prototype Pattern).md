# 个人白话简介
对象创建型模式
原型模式在 Java 中可以理解为 clone 方法的概念，可以快速高效的创建出对象。

# 1 模式动机
在有些系统中，存在大量相同或相似对象的创建问题，如果用传统的构造函数来创建对象，会比较复杂且耗时耗资源，用原型模式生成对象就很高效，就像孙悟空拔下猴毛轻轻一吹就变出很多孙悟空一样简单。

简单粗暴的理解就是：创建一个对象当做模板，然后利用这个模板使用`clone`方法快速的创建一个新的对象。

# 2 模式定义
原型模式的定义如下：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。用这种方式创建对象非常高效，根本无须知道对象创建的细节。

属于**对象创建型模式**。

# 3 模式结构
因为 Java 提供了 Object#clone 方法，所以对于 Java 来说，实现原型模式特别简单，只需要实现`Cloneable`接口即可。

模式结构：
- 抽象原型类：规定了具体原型对象必须实现的接口。
- 具体原型类：实现抽象原型类的`clone`方法。

解释一下：对于 Java 来说，很多接口是空接口，说明这个接口是一个标识接口。比如`Cloneable`接口，实现了此接口才能使用`clone`方法，否则即使你覆盖了`Object#clone`方法，你也无法使用它。

# 4 模式代码
使用 Java 中提供的`clone`方法实现原型模式非常简单。但是要注意**浅克隆**和**深克隆**，这里就不具体说这两个名词了。

```java
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User implements Cloneable{

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    protected User clone() throws CloneNotSupportedException {
        System.out.println("原型对象复制成功");
        return (User) super.clone();
    }
}
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User("Mike");
        System.out.println(user);

        User cloneUser = user.clone();
        System.out.println(cloneUser);
    }

}
```
运行结果:
```
User(name=Mike)
原型对象复制成功
User(name=Mike)
```

# 5 总结
原型模式通常适用于以下场景：

- 对象之间相同或相似，只有个别的几个属性不同的时候。
- 对象的创建过程比较麻烦，但复制比较简单的时候。

# 参考资料

- [图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/index.html)
- [Java设计模式](http://c.biancheng.net/view/1317.html)