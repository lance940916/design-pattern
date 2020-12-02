# 个人白话
对象创建型模式
侧重点：整体-部分的情况，例如文件系统。

# 1 模式动机
很多时候会存在“部分-整体”的关系，例如：大学中的部门与学院、总公司中的部门与分公司、学习用品中的书与书包。在软件开发中也是这样，例如，文件系统中的文件与文件夹、窗体程序中的简单控件与容器控件等。对这些简单对象与复合对象的处理，如果用组合模式来实现会很方便。

# 2 模式定义
组合（Composite）模式的定义：有时又叫作部分-整体模式，它是一种将对象组合成树状的层次结构的模式，用来表示“部分-整体”的关系，使用户对单个对象和组合对象具有一致的访问性。

属于：**对象结构型模式**。

组合模式分为**透明式的组合模式**和**安全式的组合模式**。

# 3 模式结构
组合模式包含以下主要角色：

- **抽象构件**（Component）角色：它的主要作用是为树叶构件和树枝构件声明公共接口，并实现它们的默认行为。在透明式的组合模式中抽象构件还声明访问和管理子类的接口；在安全式的组合模式中不声明访问和管理子类的接口，管理工作由树枝构件完成。
- **树叶构件**（Leaf）角色：是组合中的叶节点对象，它没有子节点，用于实现抽象构件角色中 声明的公共接口。
- **树枝构件**（Composite）角色：是组合中的分支节点对象，它有子节点。它实现了抽象构件角色中声明的接口，它的主要作用是存储和管理子部件，通常包含 Add()、Remove()、GetChild() 等方法。

**透明式组合方式**
在该方式中，由于抽象构建声明了所有子类中的全部方法，所以客户端无需区别树叶对象和树枝对象，对客户端来说是透明的。
缺点是：树叶构建本来没有 add()、remove() 及 getChild() 等方法，却要实现它们（空实现或抛异常），这样会带来一些安全性问题。

**安全式组合方式**
在该方式中，将管理自购件的方法移到树枝构件中，抽象构件和树叶构件没有对子对象的管理方法，这样就避免了上一种方式的安全性问题。
但由于叶子和分支有不同的接口，客户端在调用时要知道树叶对象和树枝对象的存在，所以失去了透明性。

# 4.模式代码
**透明式组合方式**
```java
# 抽象构件
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract String name();

    public boolean addChild(Component component) {
        throw new UnsupportedOperationException("addChild not supported!");
    }

    public boolean removeChild(Component component) {
        throw new UnsupportedOperationException("removeChild not supported!");
    }

    public Component getChild(int index) {
        throw new UnsupportedOperationException("getChild not supported!");
    }
}

# 树枝构件
public class Composite extends Component {
    private List<Component> componentList;

    public Composite(String name) {
        super(name);
        componentList = new ArrayList<>();
    }

    @Override
    public String name() {
        StringBuilder builder = new StringBuilder(this.name);
        for (Component component : componentList) {
            builder.append("\n");
            builder.append(component.name());
        }
        return builder.toString();
    }

    @Override
    public boolean addChild(Component component) {
        return componentList.add(component);
    }

    @Override
    public boolean removeChild(Component component) {
        return componentList.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return componentList.get(index);
    }
}

# 树叶构件
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public String name() {
        return name;
    }
}

# Client
public class Client {
    public static void main(String[] args) {
        // 根节点
        Component root = new Composite("root");
        // 树枝节点
        Component branchA = new Composite("---branchA");
        Component branchB = new Composite("------branchB");
        // 树叶节点
        Component leafA = new Leaf("------leafA");
        Component leafB = new Leaf("---------leafB");
        Component leafC = new Leaf("---leafC");

        root.addChild(branchA);
        root.addChild(leafC);

        branchA.addChild(leafA);
        branchA.addChild(branchB);

        branchB.addChild(leafB);

        // 叶子节点不支持操作
//        leafC.addChild(null);

        String result = root.name();
        System.out.println(result);
    }
}
```
按照透明式的字面意思，这里应该没有 Leaf 类，只有树枝构件，树枝构件既可以作为树枝构件也可以作为树叶构件，所以对客户端来说是透明的。

**安全式组合方式**
安全式组合方式就是将透明式组合方式 Component 中的 add、remove 等方法放在树枝节点中，抽象构件中之定义树枝构件和树叶构件中公共的部分。
```java
# 抽象构件
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract String name();
}

# 树枝构件
public class Composite extends Component {
    private List<Component> componentList;

    public Composite(String name) {
        super(name);
        componentList = new ArrayList<>();
    }

    @Override
    public String name() {
        StringBuilder builder = new StringBuilder(this.name);
        for (Component component : componentList) {
            builder.append("\n");
            builder.append(component.name());
        }
        return builder.toString();
    }

    public boolean addChild(Component component) {
        return componentList.add(component);
    }

    public boolean removeChild(Component component) {
        return componentList.remove(component);
    }

    public Component getChild(int index) {
        return componentList.get(index);
    }
}

# 树叶构件
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public String name() {
        return name;
    }
}

# Client
public class Client {
    public static void main(String[] args) {
        // 根节点 这里改为 Composite
        Composite root = new Composite("root");
        // 树枝节点 这里改为 Composite
        Composite branchA = new Composite("---branchA");
        Composite branchB = new Composite("------branchB");
        // 树叶节点
        Leaf leafA = new Leaf("------leafA");
        Leaf leafB = new Leaf("---------leafB");
        Leaf leafC = new Leaf("---leafC");

        root.addChild(branchA);
        root.addChild(leafC);

        branchA.addChild(leafA);
        branchA.addChild(branchB);

        branchB.addChild(leafB);

        // 叶子节点不支持操作
//        leafC.addChild(null);

        String result = root.name();
        System.out.println(result);
    }
}
```
树叶构件时，客户端需要区分树枝构件（Composite）和树叶构件（Leaf），所以失去了透明性。按照定义，透明式模式中就不应该有 Leaf 类的定义。
这样的好处是 接口定义职责清晰，符合设计模式的 单一职责原则 和 接口隔离原则。

# 5.总结

**优点**：

- 组合模式使得客户端代码可以一致地处理单个对象和组合对象，无须关心自己处理的是单个对象，还是组合对象，这简化了客户端代码；
- 更容易在组合体内加入新的对象，客户端不会因为加入了新的对象而更改源代码，满足“开闭原则”；

**缺点**：

- 设计较复杂，客户端需要花更多时间理清类之间的层次关系；
- 不容易限制容器中的构件；
- 不容易用继承的方法来增加构件的新功能；

**场景**：

- 在需要表示一个对象整体与部分的层次结构的场合。
- 要求对用户隐藏组合对象与单个对象的不同，用户可以用统一的接口使用组合结构中的所有对象的场合。

# 参考资料

- [图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/index.html)
- [Java设计模式](http://c.biancheng.net/view/1317.html)