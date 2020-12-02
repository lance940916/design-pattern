# 1 模式动机
在某些情况下，一个客户不想或者不能直接引用一个对象，此时可以通过一个称之为“代理”的第三者来实现间接引用。代理对象可以在客户端和目标对象之间起到中介的作用，并且可以通过代理对象去掉客户不能看到的内容和服务或者添加客户需要的额外服务。

我们经常使用的 Spring 中的 AOP，或者自己写的静态代理或动态代理都是代理模式。

# 2 模式定义
代理模式：给某一个对象提供一个代理，并由代理对象控制对原对象的引用。

它是一种**对象结构型模式**。

根据代理模式的使用目的，常见的代理模式有以下几种类型：
- 远程代理(Remote)：为一个位于不同的地址空间的对象提供一个本地的代理对象，这个不同的地址空间可以是在同一台主机中，也可是在另一台主机中，远程代理又叫做大使(Ambassador)。
- 虚拟代理(Virtual)：如果需要创建一个资源消耗较大的对象，先创建一个消耗相对较小的对象来表示，真实对象只在需要时才会被真正创建。
- Copy-on-Write代理：它是虚拟代理的一种，把复制（克隆）操作延迟 到只有在客户端真正需要时才执行。一般来说，对象的深克隆是一个开销较大的操作，Copy-on-Write代理可以让这个操作延迟，只有对象被用到的时候才被克隆。
- 保护代理(Protect or Access)：控制对一个对象的访问，可以给不同的用户提供不同级别的使用权限。
- 缓冲代理(Cache)：为某一个目标操作的结果提供临时的存储空间，以便多个客户端可以共享这些结果。
- 防火墙代理(Firewall)：保护目标不让恶意用户接近。
- 同步化代理(Synchronization)：使几个用户能够同时使用一个对象而没有冲突。
- 智能引用代理(Smart Reference)：当一个对象被引用时，提供一些额外的操作，如将此对象被调用的次数记录下来等。

# 3 模式结构
代理模式的主要角色如下：

- 抽象主题类：通过接口或抽象类声明真实主题和代理对象实现的业务方法。
- 真实主题类：实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象。
- 代理类：提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或扩展真实主题的功能。

# 4 模式代码
```java
# 抽象主题类
public abstract class AbstractSubject {
    public abstract void say();
}

# 真实主题类
public class Subject extends AbstractSubject {
    @Override
    public void say() {
        System.out.println("访问真实主题类");
    }
}

# 代理类
public class Proxy {
    private Subject subject = new Subject();

    public void say() {
        beforeSay();
        subject.say();
        afterSay();
    }

    private void beforeSay() {
        System.out.println("Before say...");
    }

    private void afterSay() {
        System.out.println("After say...");
    }

}

# Client
public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.say();
    }
}
```

# 5 总结
**优点：**

- 代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用。
- 代理对象可以扩展目标对象的功能。
- 代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度。

**缺点：**

- 增加了系统的复杂度。

# 参考资料

- [图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/index.html)
- [Java设计模式](http://c.biancheng.net/view/1317.html)
