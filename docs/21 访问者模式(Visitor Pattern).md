# 1.模式动机
在现实生活中，有些集合对象中存在多种不同的元素，且每种元素也存在多种不同的访问者和处理方式。例如，公园中存在多个景点，也存在多个游客，不同的游客对同一个景点的评价可能不同，电影或电视剧中的人物角色，不同的观众对他们的评价也不同。

这些被处理的**数据元素相对稳定**而**访问方式多种多样**的数据结构，如果用“访问者模式”来处理比较方便。访问者模式能把处理方法从数据结构中分离出来，并可以根据需要增加新的处理方法，且不用修改原来的程序代码与数据结构，这提高了程序的扩展性和灵活性。

# 2.模式定义
访问者模式（Visitor）：将作用于某种数据结构中的各元素的操作分离出来封装成独立的类，使其在不改变数据结构的前提下可以添加作用于这些元素的新的操作，为数据结构中的每个元素提供多种访问方式。它将对数据的操作与数据结构进行分离，是行为类模式中最复杂的一种模式。理解起来也比较难。

属于**对象行为型模式**。

# 3.模式结构
访问者模式包含以下主要角色：

- 抽象访问者（Visitor）角色：定义一个访问具体元素的接口，为每个具体元素类对应一个访问操作 visit() ，该操作中的参数类型标识了被访问的具体元素。
- 具体访问者（ConcreteVisitor）角色：实现抽象访问者角色中声明的各个访问操作，确定访问者访问一个元素时该做什么。
- 抽象元素（Element）角色：声明一个包含接受操作 accept() 的接口，被接受的访问者对象作为 accept() 方法的参数。
- 具体元素（ConcreteElement）角色：实现抽象元素角色提供的 accept() 操作，其方法体通常都是 visitor.visit(this) ，另外具体元素中可能还包含本身业务逻辑的相关操作。
- 对象结构（Object Structure）角色：是一个包含元素角色的容器，提供让访问者对象遍历容器中的所有元素的方法，通常由 List、Set、Map 等聚合类实现。

# 4.模式代码
我们以不同的人去同一个公园或者动物园发出不同的评价，写了如下代码。

```java
# 抽象元素角色
public interface Element {
    void accept(Visitor visitor);
}

# 具体元素角色，动物园 和 公园
public class ZooElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
public class ParkElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

# 抽象访问者
public interface Visitor {
    void visit(ZooElement zooElement);
    void visit(ParkElement parkElement);
}

# 具体访问者
public class MikeVisitor implements Visitor {
    @Override
    public void visit(ZooElement zooElement) {
        System.out.println("Mike 访问动物园, 评价:动物都很干净");
    }

    @Override
    public void visit(ParkElement parkElement) {
        System.out.println("Mike 访问公园, 评价:人比较少");
    }
}
public class TomVisitor implements Visitor {
    @Override
    public void visit(ZooElement zooElement) {
        System.out.println("Tom 访问动物园, 评价:很多人乱喂动物");
    }

    @Override
    public void visit(ParkElement parkElement) {
        System.out.println("Tom 访问公园, 评价:空气很好");
    }
}

# 对象结构角色
public class ObjectStructure {
    private List<Element> list = new ArrayList<>();

    public void accept(Visitor visitor) {
        for (Element ele : list) {
            ele.accept(visitor);
        }
    }

    public void addElement(Element element) {
        list.add(element);
    }

    public void delElement(Element element) {
        list.remove(element);
    }
}

# Client
public class Client {
    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();

        // 添加两个被访问的元素
        os.addElement(new ZooElement());
        os.addElement(new ParkElement());

        // 访问者 Mike
        Visitor mv = new MikeVisitor();
        os.accept(mv);
        System.out.println("---------");

        // 访问者 Tom
        Visitor tv = new TomVisitor();
        os.accept(tv);
    }
}
```

# 5.总结

这个设计模式不太好理解，如果不明白，还是直接抄代码，多写几遍模式代码，一边写一边理解其中的调用逻辑，再加上模式的定义，应该就明白了。

**优点**

- 访问者（Visitor）模式是一种对象行为型模式，其主要优点如下。
- 扩展性好。能够在不修改对象结构中的元素的情况下，为对象结构中的元素添加新的功能。
- 复用性好。可以通过访问者来定义整个对象结构通用的功能，从而提高系统的复用程度。
- 灵活性好。访问者模式将数据结构与作用于结构上的操作解耦，使得操作集合可相对自由地演化而不影响系统的数据结构。
- 符合单一职责原则。访问者模式把相关的行为封装在一起，构成一个访问者，使每一个访问者的功能都比较单一。

**缺点**

- 加新的元素类很困难。在访问者模式中，每增加一个新的元素类，都要在每一个具体访问者类中增加相应的具体操作，这违背了“开闭原则”。
- 破坏封装。访问者模式中具体元素对访问者公布细节，这破坏了对象的封装性。
- 违反了依赖倒置原则。访问者模式依赖了具体类，而没有依赖抽象类。

# 参考资料

- [图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/index.html)
- [Java设计模式](http://c.biancheng.net/view/1317.html)