# 1.模式动机
在现实生活以及程序设计中，经常要访问一个聚合对象中的各个元素，如“数据结构”中的链表遍历，通常的做法是将链表的创建和遍历都放在同一个类中，但这种方式不利于程序的扩展，如果要更换遍历方法就必须修改程序源代码，这违背了 “开闭原则”。

既然将遍历方法封装在聚合类中不可取，那么聚合类中不提供遍历方法，将遍历方法由用户自己实现是否可行呢？答案是同样不可取，因为这种方式会存在两个缺点：

- 暴露了聚合类的内部表示，使其数据不安全；
- 增加了客户的负担。

“迭代器模式”能较好地克服以上缺点，它在客户访问类与聚合类之间插入一个迭代器，这分离了聚合对象与其遍历行为，对客户也隐藏了其内部细节，且满足“单一职责原则”和“开闭原则”，如 Java 中的 Collection、List、Set、Map 等都包含了迭代器。

# 2.模式定义
迭代器模式（Iterator）：提供一个对象来顺序访问聚合对象中的一系列数据，而不暴露聚合对象的内部表示。

属于**对象行为型模式**。

# 3.模式结构
迭代器模式主要包含以下角色：

- 抽象聚合（Aggregate）角色：定义存储、添加、删除聚合对象以及创建迭代器对象的接口。
- 具体聚合（ConcreteAggregate）角色：实现抽象聚合类，返回一个具体迭代器的实例。
- 抽象迭代器（Iterator）角色：定义访问和遍历聚合元素的接口，通常包含 hasNext()、first()、next() 等方法。
- 具体迭代器（Concretelterator）角色：实现抽象迭代器接口中所定义的方法，完成对聚合对象的遍历，记录遍历的当前位置。

聚合就是集合类。

# 4.模式代码
```java
# 抽象迭代器
public abstract class Iterator {
    public abstract Object first();

    public abstract Object next();

    public abstract boolean hasNext();
}

# 具体迭代器
public class ConcreteIterator extends Iterator {
    private List<Object> list;
    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Object first() {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return list.get(++index);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (list == null || list.isEmpty()) {
            return false;
        }
        return index < list.size() - 1;
    }
}

# 抽象聚合类
public abstract class Aggregate {

    public abstract void add(Object obj);

    public abstract void remove(Object obj);

    public abstract Iterator getIterator();
}

# 具体聚合类
public class ConcreteAggregate extends Aggregate {
    private List<Object> list = new ArrayList<>();

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(this.list);
    }
}

# Client
public class Client {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("1");
        aggregate.add("3");
        aggregate.add("5");
        aggregate.add("7");

        Iterator iter = aggregate.getIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
```

想要进阶一下可以看看 List、Set 等集合类的源码。

# 5.总结

**优点**

- 访问一个聚合对象的内容而无须暴露它的内部表示。
- 遍历任务交由迭代器完成，这简化了聚合类。
- 它支持以不同方式遍历一个聚合，甚至可以自定义迭代器的子类以支持新的遍历。
- 增加新的聚合类和迭代器类都很方便，无须修改原有代码。
- 封装性良好，为遍历不同的聚合结构提供一个统一的接口。

**缺点**

- 增加了类的个数，这在一定程度上增加了系统的复杂性。

# 参考资料

- [图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/index.html)
- [Java设计模式](http://c.biancheng.net/view/1317.html)