# 个人白话
对象结构型模式
即：将一个类的对象嵌入另一个对象，发现与代理模式、适配器模式或桥接模式也差不多，理解装饰模式主要是就是理解**装饰**两个字，将已有的类实例（待装饰的）通过构造参数传入装饰类中，用装饰类实例来代替之前的类实例往下运行，这里就需要装饰类实例得实现待装饰类实例的抽象类。

# 1 模式动机
一般有两种方式可以实现给一个类或对象增加行为：

- **继承机制**：使用继承机制是给现有类添加功能的一种有效途径，通过继承一个现有类可以使得子类在拥有自身方法的同时还拥有父类的方法。但是这种方法是静态的，用户不能控制增加行为的方式和时机。
- **关联机制**：即将一个类的对象嵌入另一个对象中，由另一个对象来决定是否调用嵌入对象的行为以便扩展自己的行为，我们称这个嵌入的对象为装饰器(Decorator)。

装饰模式以对客户透明的方式动态地给一个对象附加上更多的责任，换言之，客户端并不会觉得对象在装饰前和装饰后有什么不同。装饰模式可以在不需要创造更多子类的情况下，将对象的功能加以扩展。这就是装饰模式的模式动机。

# 2 模式定义
装饰模式(Decorator Pattern)：动态地给一个对象增加一些额外的职责(Responsibility)，就增加对象功能来说，装饰模式比生成子类实现更为灵活。其别名也可以称为包装器(Wrapper)，与适配器模式的别名相同，但它们适用于不同的场合。根据翻译的不同，装饰模式也有人称之为“油漆工模式”。

属于 **对象结构型模式**。

# 3 模式结构
装饰模式主要包含以下角色：

- **抽象构件角色**：定义一个抽象接口以规范准备接收附加责任的对象。
- **具体构件角色**：实现抽象构件，通过装饰角色为其添加一些职责。
- **抽象装饰角色**：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
- **具体装饰角色**：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。

# 4 模式代码
```java
# 抽象构建角色
public interface Component {
    void operation();
}

# 具体构建角色
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("ConcreteComponent operation");
    }
}

# 抽象装饰角色
public abstract class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

# 具体装饰角色
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        doSomething();
    }

    private void doSomething() {
        System.out.println("do something");
    }
}

# Client
public class Client {
    public static void main(String[] args) {
        System.out.println("未装饰前：");
        Component component = new ConcreteComponent();
        component.operation();

        System.out.println("装饰后：");
        Decorator decorator = new ConcreteDecorator(component);
        decorator.operation();

        // 也可以写为
        Component decoratorComponent = new ConcreteDecorator(component);
        decoratorComponent.operation();
    }
}
```
装饰前也是可以单独运行的，装饰器只是增加了新功能而已，将 component 包装了一下，增加一些新功能，然后对外提供服务。

由于 Decorator 也是 Component 的实现类，所以，可以无缝的把原先的 ConcreteComponent 类替换了，使用 ConcreteDecorator 来提供服务。

# 5 总结
**分析**

- 与继承关系相比，关联关系的主要优势在于不会破坏类的封装性，而且继承是一种耦合度较大的静态关系，无法在程序运行时动态扩展。在软件开发阶段，关联关系虽然不会比继承关系减少编码量，但是到了软件维护阶段，由于关联关系使系统具有较好的松耦合性，因此使得系统更加容易维护。当然，关联关系的缺点是比继承关系要创建更多的对象。
- 使用装饰模式来实现扩展比继承更加灵活，它以对客户透明的方式动态地给一个对象附加更多的责任。装饰模式可以在不需要创造更多子类的情况下，将对象的功能加以扩展。

**优点**

- 装饰模式与继承关系的目的都是要扩展对象的功能，但是装饰模式可以提供比继承更多的灵活性。
- 可以通过一种动态的方式来扩展一个对象的功能，通过配置文件可以在运行时选择不同的装饰器，从而实现不同的行为。
- 通过使用不同的具体装饰类以及这些装饰类的排列组合，可以创造出很多不同行为的组合。可以使用多个具体装饰类来装饰同一对象，得到功能更为强大的对象。
- 具体构件类与具体装饰类可以独立变化，用户可以根据需要增加新的具体构件类和具体装饰类，在使用时再对其进行组合，原有代码无须改变，符合“开闭原则”

**缺点**

- 使用装饰模式进行系统设计时将产生很多小对象，这些对象的区别在于它们之间相互连接的方式有所不同，而不是它们的类或者属性值有所不同，同时还将产生很多具体装饰类。这些装饰类和小对象的产生将增加系统的复杂度，加大学习与理解的难度。
- 这种比继承更加灵活机动的特性，也同时意味着装饰模式比继承更加易于出错，排错也很困难，对于多次装饰的对象，调试时寻找错误可能需要逐级排查，较为烦琐。

# 参考资料

- [图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/index.html)
- [Java设计模式](http://c.biancheng.net/view/1317.html)