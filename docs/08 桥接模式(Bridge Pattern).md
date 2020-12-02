# 个人白话
对象结构型模式
在本文例子中，桥接就是将形状和颜色进行了桥接，形状中拥有颜色的抽象类（个人理解，桥接类就是AbstractDrawShape）。形状想拥有颜色，两个不同的维度需要进行桥接。

# 1 模式动机
设想如果要绘制矩形、圆形、椭圆、正方形，我们至少需要4个形状类，但是如果绘制的图形需要具有不同的颜色，如红色、绿色、蓝色等，此时至少有如下两种设计方案：

- 第一种设计方案是为每一种形状都提供一套各种颜色的版本。
- 第二种设计方案是根据实际需要对形状和颜色进行组合。

对于有**两个变化维度**（即两个变化的原因）的系统，采用方案二来进行设计系统中类的个数更少，且系统扩展更为方便。设计方案二即是桥接模式的应用。桥接模式将继承关系转换为关联关系，从而降低了类与类之间的耦合，减少了代码编写量。

当然，这样的例子还有很多，如不同颜色和字体的文字、不同品牌和功率的汽车、不同性别和职业的男女、支持不同平台和不同文件格式的媒体播放器等。如果用桥接模式就能很好地解决这些问题。

# 2 模式定义
桥接模式(Bridge Pattern)：将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。

它是一种**对象结构型模式**。

# 3 模式结构
桥接模式包含以下主要角色：

- 抽象类（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用。
- 扩展抽象类（Refined Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用**实现化角色**中的业务方法。
- 实现类（Implementor）角色：定义实现化角色的接口，供扩展抽象化角色调用。
- 具体实现类（Concrete Implementor）角色：给出实现化角色接口的具体实现。

# 4 模式代码
```java
# 实现类角色
public interface IColor {
    String name();
}

# 具体实现类角色
public class OrangeColor implements IColor {
    @Override
    public String name() {
        return "Orange";
    }
}
public class YellowColor implements IColor {
    @Override
    public String name() {
       return "Yellow";
    }
}

# 抽象类角色
public abstract class AbstractDrawShape {

    protected IColor color;

    public AbstractDrawShape(IColor color) {
        this.color = color;
    }

    public abstract void draw();

}

# 扩展抽象类角色
public class DrawRoundShape extends AbstractDrawShape {

    public DrawRoundShape(IColor color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("颜色为 " + color.name() + " 的圆形");
    }
}
public class DrawSquareShape extends AbstractDrawShape {

    public DrawSquareShape(IColor color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("颜色为 " + color.name() + " 的正方形");
    }
}

# Client
public class Client {
    public static void main(String[] args) {
        AbstractDrawShape squareShape = new DrawSquareShape(new YellowColor());
        squareShape.draw();

        AbstractDrawShape roundShape = new DrawRoundShape(new OrangeColor());
        roundShape.draw();
    }
}
```

# 5 总结
理解桥接模式，重点需要理解如何将**抽象化**(Abstraction)与**实现化**(Implementation)**脱耦**，使得二者可以独立地变化。

- 抽象化：抽象化就是忽略一些信息，把不同的实体当作同样的实体对待。在面向对象中，将对象的共同性质抽取出来形成类的过程即为抽象化的过程。
- 实现化：针对抽象化给出的具体实现，就是实现化，抽象化与实现化是一对互逆的概念，实现化产生的对象比抽象化更具体，是对抽象化事物的进一步具体化的产物。
- 脱耦：脱耦就是将抽象化和实现化之间的耦合解脱开，或者说是将它们之间的强关联改换成弱关联，将两个角色之间的继承关系改为关联关系。桥接模式中的所谓脱耦，就是指在一个软件系统的抽象化和实现化之间使用关联关系（组合或者聚合关系）而不是继承关系，从而使两者可以相对独立地变化，这就是桥接模式的用意。

**优点**

- 分离抽象接口及其实现部分；
- 桥接模式有时类似于多继承方案，但是多继承方案违背了类的单一职责原则（即一个类只有一个变化的原因），复用性比较差，而且多继承结构中类的个数非常庞大，桥接模式是比多继承方案更好的解决方法。（Java 不支持多继承）。
- 桥接模式提高了系统的可扩充性，在两个变化维度中任意扩展一个维度，都不需要修改原有系统。

**缺点**

- 桥接模式的引入会增加系统的理解与设计难度，由于聚合关联关系建立在抽象层，要求开发者针对抽象进行设计与编程。
- 桥接模式要求正确识别出系统中两个独立变化的维度，因此其使用范围具有一定的局限性。


**桥接模式的应用场景**

- 当一个类存在两个独立变化的维度，且这两个维度都需要进行扩展时。
- 当一个系统不希望使用继承或因为多层次继承导致系统类的个数急剧增加时。
- 当一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性时。

# 参考资料

- [图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/index.html)
- [Java设计模式](http://c.biancheng.net/view/1317.html)