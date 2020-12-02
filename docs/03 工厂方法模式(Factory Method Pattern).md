# 个人白话简介
类创建型模式
抽象接口定义产品规范，具体实现去实现产品，匹配对应创建那个类的实例。

# 插曲.简单工厂模式（Simple Factory Pattern）
介绍工厂方法模式之前，先来做一个铺垫，了解一下简单工厂模式，它不属于 GoF 的 23 种经典设计模式，它的缺点是增加新产品时会违背“开闭原则”。

## 1 模式动机
考虑一个简单的软件应用场景，一个软件系统可以提供多个外观不同的按钮（如圆形按钮、矩形按钮、菱形按钮等），这些按钮都源自同一个基类，不过在继承基类后不同的子类有不同的实现方式从而使得它们可以呈现不同的外观，如果我们希望在使用这些按钮时，不需要知道这些具体按钮类的名字，只需要知道表示该按钮类的一个参数，并提供一个调用方便的方法，把该参数传入方法即可返回一个相应的按钮对象，此时，就可以使用简单工厂模式。

## 2 模式定义
简单工厂模式(Simple Factory Pattern)：又称为静态工厂方法(Static Factory Method)模式，它属于类创建型模式。在简单工厂模式中，可以根据参数的不同返回不同类的实例。简单工厂模式专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有共同的父类。

## 3 模式结构
这个模式结构有三种。
- 工厂角色：工厂角色负责实现创建所有实例的内部逻辑。
- 抽象产品角色：抽象产品角色是所创建的所有对象的父类，负责描述所有实例所共有的公共接口。
- 具体产品角色：具体产品角色是创建目标，所有创建的对象都充当这个角色的某个具体类的实例。

## 4 模式代码
```java
# 抽象产品角色
public abstract class AbstractAnimal {
    public abstract String say();
}

# 具体产品角色
public class Bird extends AbstractAnimal {
    @Override
    public String say() {
        return "I'm a bird.";
    }
}
public class Cat extends AbstractAnimal {
    @Override
    public String say() {
        return "I'm a cat.";
    }
}

# 工厂角色
public class AnimalFactory {
    public static AbstractAnimal create(String animalName) {
        if ("cat".equals(animalName)) {
            return new Cat();
        } else if ("bird".equals(animalName)) {
            return new Bird();
        }
        return null;
    }
}

# Client
public class Client {
    public static void main(String[] args) {
        AbstractAnimal cat = AnimalFactory.create("cat");
        System.out.println(cat.say());
    }
}
```

## 5 总结
简单工厂模式还是比较简单吧，虽然它不是 23 种设计模式中的一种，但是理解它可以帮助你理解本文的主角：**工厂方法模式**。

**缺点**
- 由于工厂类（AnimalFactory）集中了所有产品创建逻辑，一旦不能正常工作，整个系统都要受到影响。
- 系统扩展困难，一旦添加新产品就不得不修改工厂逻辑，在产品类型较多时，有可能造成工厂逻辑过于复杂，不利于系统的扩展和维护。

# 1 模式动机
现在对该系统进行修改，不再设计一个按钮工厂类来统一负责所有产品的创建，而是将具体按钮的创建过程交给专门的工厂子类去完成，我们先定义一个抽象的按钮工厂类，再定义具体的工厂类来生成圆形按钮、矩形按钮、菱形按钮等，它们实现在抽象按钮工厂类中定义的方法。这种抽象化的结果使这种结构可以在不修改具体工厂类的情况下引进新的产品，如果出现新的按钮类型，只需要为这种新类型的按钮创建一个具体的工厂类就可以获得该新按钮的实例，这一特点无疑使得工厂方法模式具有超越简单工厂模式的优越性，更加符合“开闭原则”。

# 2 模式定义
工厂方法模式(Factory Method Pattern)：在工厂方法模式中，工厂父类负责定义创建产品对象的公共接口，而工厂子类则负责生成具体的产品对象，这样做的目的是将产品类的实例化操作延迟到工厂子类中完成，即通过工厂子类来确定究竟应该实例化哪一个具体产品类。

属于**类创建型模式**。

# 3 模式结构
相对于简单工厂，无非是将工厂类拆分为抽象和具体了。

- 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法 newProduct() 来创建产品。
- 具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
- 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。
- 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。

# 4 模式代码
```java
# 抽象工厂
public abstract class AbstractAnimalFactory {
    public abstract AbstractAnimal create();
}

# 抽象产品
public abstract class AbstractAnimal {
    public abstract String say();
}

# 具体产品
public class Bird extends AbstractAnimal {
    @Override
    public String say() {
        return "I'm a bird.";
    }
}
public class Cat extends AbstractAnimal {
    @Override
    public String say() {
        return "I'm a cat.";
    }
}

# 具体工厂
public class BirdAnimalFactory extends AbstractAnimalFactory {
    @Override
    public AbstractAnimal create() {
        return new Bird();
    }
}
public class CatAnimalFactory extends AbstractAnimalFactory {
    @Override
    public AbstractAnimal create() {
        return new Cat();
    }
}

# Client
public class Client {
    public static void main(String[] args) {
        AbstractAnimalFactory factory = new CatAnimalFactory();
        AbstractAnimal animal = factory.create();
        System.out.println(animal.getName());
    }
}
```
是不是理解了简单工厂模式，这个就很好理解了。就是具体工厂负责具体产品的创建。职责分离。

# 5 总结

- 在工厂方法模式中，核心的工厂类不再负责所有产品的创建，而是将具体创建工作交给子类去做。这个核心类仅仅负责给出具体工厂必须实现的接口，而不负责产品类被实例化这种细节，这使得工厂方法模式可以允许系统在不修改工厂角色的情况下引进新产品。
- 工厂方法模式的主要优点是增加新的产品类时无须修改现有系统，并封装了产品对象的创建细节，系统具有良好的灵活性和可扩展性；其缺点在于增加新产品的同时需要增加新的工厂，导致系统类的个数成对增加，在一定程度上增加了系统的复杂性。

**优点**

- 用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程。
- 在系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则

**缺点**

- 每增加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度。

# 参考资料

- [图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/index.html)
- [Java设计模式](http://c.biancheng.net/view/1317.html)