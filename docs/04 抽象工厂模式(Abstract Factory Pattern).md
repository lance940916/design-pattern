# 个人白话简介
对象创建型模式
可以从两个维度理解，分别是工厂和产品，一个工厂可以有多个产品，一个产品可以由多个工厂生产。就有了抽象产品，抽象工厂角色。

# 1 模式动机
在工厂方法模式中具体工厂负责生产具体的产品，每一个具体工厂对应一种具体产品，工厂方法也具有唯一性，一般情况下，一个具体工厂中只有一个工厂方法或者一组重载的工厂方法。但是有时候我们需要一个工厂可以提供多个产品对象，而不是单一的产品对象。

为了更清晰地理解工厂方法模式，需要先引入两个概念：

- **产品等级结构**：产品等级结构即产品的继承结构，如一个抽象类是电视机，其子类有海尔电视机、海信电视机、TCL电视机，则抽象电视机与具体品牌的电视机之间构成了一个产品等级结构，抽象电视机是父类，而具体品牌的电视机是其子类。
- **产品族**：在抽象工厂模式中，产品族是指由同一个工厂生产的，位于不同产品等级结构中的一组产品，如海尔电器工厂生产的海尔电视机、海尔电冰箱，海尔电视机位于电视机产品等级结构中，海尔电冰箱位于电冰箱产品等级结构中。

# 2 模式定义
抽象工厂模式（AbstractFactory）：提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。

抽象工厂模式又称为Kit模式，属于**对象创建型模式**。

抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。

# 3 模式结构
抽象工厂模式包含如下角色：

- 抽象工厂：提供了创建产品的接口，它包含多个创建产品的方法 newProduct()，可以创建多个不同等级的产品。
- 具体工厂：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建。
- 抽象产品：定义了产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品。
- 具体产品：实现了抽象产品角色所定义的接口，由具体工厂来创建，它 同具体工厂之间是多对一的关系。

# 4 模式代码
```java
# 抽象工厂
public abstract class AbstractFactory {
    public abstract AbstractTV createTV();
    public abstract AbstractMobile createMobile();
}

# 具体工厂
public class HuaWeiFactory extends AbstractFactory {
    @Override
    public AbstractTV createTV() {
        return new HuaWeiTV();
    }

    @Override
    public AbstractMobile createMobile() {
        return new HuaWeiMobile();
    }
}

# 抽象产品
public abstract class AbstractMobile {
    public abstract String name();
}
public abstract class AbstractTV {
    public abstract String name();
}

# 具体产品
public class HuaWeiMobile extends AbstractMobile {
    @Override
    public String name() {
        return "华为手机";
    }
}
public class HuaWeiTV extends AbstractTV {
    @Override
    public String name() {
        return "华为电视";
    }
}
public class MiMobile extends AbstractMobile {
    @Override
    public String name() {
        return "小米手机";
    }
}
public class MiTV extends AbstractTV {
    @Override
    public String name() {
        return "小米电视";
    }
}

# 调用
public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = new HuaWeiFactory();
        AbstractMobile mobile = factory.createMobile();
        System.out.println(mobile.name()); // 华为手机
        AbstractTV tv = factory.createTV();
        System.out.println(tv.name()); // 华为电视

    }
}
```

每个工厂创建自己的产品。

# 5 总结

**优点**

- 抽象工厂模式隔离了具体类的生成，使得客户并不需要知道什么被创建。由于这种隔离，更换一个具体工厂就变得相对容易。所有的具体工厂都实现了抽象工厂中定义的那些公共接口，因此只需改变具体工厂的实例，就可以在某种程度上改变整个软件系统的行为。另外，应用抽象工厂模式可以实现高内聚低耦合的设计目的，因此抽象工厂模式得到了广泛的应用。
- 当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产品族中的对象。这对一些需要根据当前环境来决定其行为的软件系统来说，是一种非常实用的设计模式。
- 增加新的具体工厂和产品族很方便，无须修改已有系统，符合“开闭原则”。

**缺点**

- 在添加新的产品对象时，难以扩展抽象工厂来生产新种类的产品，这是因为在抽象工厂角色中规定了所有可能被创建的产品集合，要支持新种类的产品就意味着要对该接口进行扩展，而这将涉及到对抽象工厂角色及其所有子类的修改，显然会带来较大的不便。
- 开闭原则的倾斜性（增加新的工厂和产品族容易，增加新的产品等级结构麻烦）。

# 参考资料

- [图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/index.html)
- [Java设计模式](http://c.biancheng.net/view/1317.html)
