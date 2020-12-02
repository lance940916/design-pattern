# 1 模式动机
在软件开发中，会遇到有些问题多次重复出现，而且有一定的相似性和规律性。如果将它们归纳成一种简单的语言，那么这些问题实例将是该语言的一些句子，这样就可以用“编译原理”中的解释器模式来实现了。

虽然使用解释器模式的实例不是很多，但对于满足以上特点，且对运行效率要求不是很高的应用实例，如果用解释器模式来实现，其效果是非常好的。

比如：一个公交系统，当输入北京的老人、北京的儿童、北京的白领等时，会根据不同的输入来判断是否需要收费以及怎么收费。本文就以公交系统来演示这个模式。

# 2 模式定义
解释器模式（Interpreter）：给分析对象定义一个语言，并定义该语言的文法表示，再设计一个解析器来解释语言中的句子。也就是说，用编译语言的方式来分析应用中的实例。这种模式实现了文法表达式处理的接口，该接口解释一个特定的上下文。

属于**类行为型模式**。

# 3 模式结构
解释器模式常用于对简单语言的编译或分析实例中，为了掌握好它的结构与实现，必须先了解编译原理中的“文法”、“句子”、“语法树”等相关概念。

**1) 文法**
文法是用于描述语言的语法结构的形式规则。不管它是机器语言还是自然语言，都有它自己的文法规则。例如，中文中的“句子”的文法如下：
```
〈句子〉::=〈主语〉〈谓语〉〈宾语〉
〈主语〉::=〈代词〉|〈名词〉
〈谓语〉::=〈动词〉
〈宾语〉::=〈代词〉|〈名词〉
〈代词〉::= 你|我|他
〈名词〉::= 大学生|英语
〈动词〉::= 是|学习
```
注：这里的符号“::=”表示“定义为”的意思，用“〈”和“〉”括住的是非终结符，没有括住的是终结符。

**1) 句子**
句子是语言的基本单位，是语言集中的一个元素，它由终结符构成，能由“文法”推导出。例如，上述文法可以推出“我是大学生”，所以它是句子。

**1) 语法树**
语法树是句子结构的一种树型表示，它代表了句子的推导结果，它有利于理解句子语法结构的层次。图 1 所示是“我是大学生”的语法树。
```mermaid
graph TD
A[句子] -->B(主语)
A[句子] -->C(谓语)
A[句子] -->D(宾语)
B --> B1(代词)
B1 --> B2(我)
C --> C1(动词)
C1 --> C2(是)
D --> D1(名词)
D1 --> D2(大学生)
```
有了以上基础知识，现在来介绍解释器模式的结构就简单了。解释器模式的结构与组合模式相似，不过其包含的组成元素比组合模式多，而且组合模式是对象结构型模式，而解释器模式是类行为型模式。

**该模式包含以下角色：**

- 抽象表达式（Abstract Expression）：定义解析器的接口，约定解析器的解析操作，主要包含解析方法：interpret()。
- 终结符表达式（Terminal Expression）：是抽象表达式的子类，用来实现文法中与终结符相关的操作，文法中的每一个终结符都有一个具体终结表达式与之相对应。
- 非终结符表达式（Nonterminal Expression）：是抽象表达式的子类，用来实现文法中与非终结符相关的操作，文法中的每条规则都对应于一个非终结符表达式。
- 环境（Context）：通常包含各个解析器需要的数据或公共的功能，一般用来传递被所有解释器共享的数据，后面的解释器可以从这里获取这些值。
- 客户端（Client）：主要任务是将需要分析的句子或表达式转换成使用解析器对象描述的抽象语法树，然后调用解析器的解析方法，当然也可以通过环境角色间接方法解析器的解析方法。

# 4 模式代码
这里使用公交系统来描述这个模式，例：北京城市的老人和儿童乘车免费，成人乘车全额。
```java
# 抽象表达式
public interface Expression {
    boolean interpret(String info);
}

# 终结符表达式
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TerminalExpression implements Expression {
    private Set<String> set = new HashSet<>();

    public TerminalExpression(String[] data) {
        Collections.addAll(set, data);
    }

    @Override
    public boolean interpret(String info) {
        return set.contains(info);
    }
}

# 非终结符表达式
public class AndExpression implements Expression {
    private Expression city;
    private Expression person;

    public AndExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    @Override
    public boolean interpret(String info) {
        String[] s = info.split("的");
        return city.interpret(s[0]) && person.interpret(s[1]);
    }
}

# 环境
public class Context {

    private String[] cities = {"北京"};
    private String[] persons = {"儿童", "老人"};
    private Expression cityPerson;

    public Context() {
        TerminalExpression city = new TerminalExpression(cities);
        TerminalExpression person = new TerminalExpression(persons);
        cityPerson = new AndExpression(city, person);
    }

    public void freeRide(String info) {
        if (cityPerson.interpret(info)) {
            System.out.println("您是" + info + "，您本次乘车免费！");
        } else {
            System.out.println("您不是免费人员，您本次乘车免费！");
        }
    }
}

# Client
public class Client {
    public static void main(String[] args) {
        Context bus = new Context();
        bus.freeRide("北京的儿童");
        bus.freeRide("北京的老人");
        bus.freeRide("北京的学生");
        bus.freeRide("广州的老人");
        bus.freeRide("广州的儿童");
    }
}
```
freeRide 的处理不是关键，**关键是对句子的解析**。

# 5 总结

**优点**

- 扩展性好。由于在解释器模式中使用类来表示语言的文法规则，因此可以通过继承等机制来改变或扩展文法。
- 容易实现。在语法树中的每个表达式节点类都是相似的，所以实现其文法较为容易。

**缺点**

- 执行效率较低。解释器模式中通常使用大量的循环和递归调用，当要解释的句子较复杂时，其运行速度很慢，且代码的调试过程也比较麻烦。
- 会引起类膨胀。解释器模式中的每条规则至少需要定义一个类，当包含的文法规则很多时，类的个数将急剧增加，导致系统难以管理与维护。
- 应用的场景比较少。在软件开发中，需要定义语言文法的应用实例非常少，所以这种模式很少被使用到。

# 参考资料

- [图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/index.html)
- [Java设计模式](http://c.biancheng.net/view/1317.html)