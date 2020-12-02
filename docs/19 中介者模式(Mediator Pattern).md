# 个人白话
对象行为模式
类似于星状结构，所有的点想要与其它点进行交互，必须先与中心点进行交互。

# 1 模式动机
在现实生活中，常常会出现好多对象之间存在复杂的交互关系，这种交互关系常常是“网状结构”，它要求每个对象都必须知道它需要交互的对象。例如，每个人必须记住他（她）所有朋友的电话；而且，朋友中如果有人的电话修改了，他（她）必须告诉其他所有的朋友修改，这叫作“牵一发而动全身”，非常复杂。

如果把这种“网状结构”改为“星形结构”的话，将大大降低它们之间的“耦合性”，这时只要找一个“中介者”就可以了。如前面所说的“每个人必须记住所有朋友电话”的问题，只要在网上建立一个每个朋友都可以访问的“通信录”就解决了。这样的例子还有很多，例如，你刚刚参力口工作想租房，可以找“房屋中介”；或者，自己刚刚到一个陌生城市找工作，可以找“人才交流中心”帮忙。

在软件的开发过程中，这样的例子也很多，例如，在 MVC 框架中，控制器（C）就是模型（M）和视图（V）的中介者；还有大家常用的 QQ 聊天程序的“中介者”是 QQ 服务器。所有这些，都可以采用“中介者模式”来实现，它将大大降低对象之间的耦合性，提高系统的灵活性。

# 2 模式定义
中介者模式(Mediator Pattern)定义：用一个中介对象来封装一系列的对象交互，中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。

中介者模式又称为调停者模式，它是一种**对象行为型模式**。

# 3 模式结构
中介者模式包含以下主要角色:

- 抽象中介者（Mediator）角色：它是中介者的接口，提供了同事对象注册与转发同事对象信息的抽象方法。
- 具体中介者（ConcreteMediator）角色：实现中介者接口，定义一个 List 来管理同事对象，协调各个同事角色之间的交互关系，因此它依赖于同事角色。
- 抽象同事类（Colleague）角色：定义同事类的接口，保存中介者对象，提供同事对象交互的抽象方法，实现所有相互影响的同事类的公共功能。
- 具体同事类（Concrete Colleague）角色：是抽象同事类的实现者，当需要与其他同事对象交互时，由中介者对象负责后续的交互。

# 4 模式代码
```java
# 抽象中介者
public abstract class Mediator {
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague colleague);
}

# 具体中介者
public class ConcreteMediator extends Mediator {

    private List<Colleague> list = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        if (!list.contains(colleague)) {
            list.add(colleague);
            colleague.setMediator(this);
        }
    }

    @Override
    public void relay(Colleague colleague) {
        for (Colleague c : list) {
            if (!c.equals(colleague)) {
                c.receive();
            }
        }
    }
}

# 抽象同事类
public abstract class Colleague {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();
    public abstract void send();
}

# 具体同事类 A 和 B
public class ConcreteColleagueA extends Colleague {
    @Override
    public void receive() {
        System.out.println("具体同事类 A 收到请求");
    }

    @Override
    public void send() {
        System.out.println("具体同事类 A 发出请求");
        mediator.relay(this);
    }
}
public class ConcreteColleagueB extends Colleague {
    @Override
    public void receive() {
        System.out.println("具体同事类 B 收到请求");
    }

    @Override
    public void send() {
        System.out.println("具体同事类 B 发出请求");
        mediator.relay(this);
    }
}

# Client
public class Client {
    public static void main(String[] args) {
        Mediator m = new ConcreteMediator();
        Colleague cA = new ConcreteColleagueA();
        Colleague cB = new ConcreteColleagueB();

        m.register(cA);
        m.register(cB);

        cA.send();
        System.out.println("-----分割线");
        cB.send();
    }
}
```

# 5 总结

**分析**

- 中介者模式可以使对象之间的关系数量急剧减少
- 中介者承担两方面的职责
    - 中转作用（结构性）：通过中介者提供的中转作用，各个同事对象就不再需要显式引用其他同事，当需要和其他同事进行通信时，通过中介者即可。该中转作用属于中介者在结构上的支持。
    - 协调作用（行为性）：中介者可以更进一步的对同事之间的关系进行封装，同事可以一致地和中介者进行交互，而不需要指明中介者需要具体怎么做，中介者根据封装在自身内部的协调逻辑，对同事的请求进行进一步处理，将同事成员之间的关系行为进行分离和封装。该协调作用属于中介者在行为上的支持。


**优点**

- 低了对象之间的耦合性，使得对象易于独立地被复用
- 将对象间的一对多关联转变为一对一的关联，提高系统的灵活性，使得系统易于维护和扩展

**缺点**

- 当同事类太多时，中介者的职责将很大，它会变得复杂而庞大，以至于系统难以维护

# 参考资料

- [图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/index.html)
- [Java设计模式](http://c.biancheng.net/view/1317.html)