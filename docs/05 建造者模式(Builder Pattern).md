# 1 模式动机
比如我们要组装一台电脑，都知道电脑是由 CPU、主板、内存、硬盘、显卡、机箱、显示器、键盘和鼠标组成，其中非常重要的一点就是这些硬件都是可以灵活选择，但是组装步骤都是大同小异（可以组一个高配置的，也可以组一个低配置的），这时建造者模式可以很好的描述这类产品的创建。

# 2 模式定义
建造者模式的定义：指将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，这样的设计模式被称为建造者模式。
它是将一个复杂的对象分解为多个简单的对象，然后一步一步构建而成。它将变与不变相分离，即产品的组成部分是不变的，但每一部分是可以灵活选择的。

属于**对象创建型模式**。

**注意**
建造者模式和工厂模式的关注点不同：建造者模式注重零部件的组装过程，而工厂方法模式更注重零部件的创建过程，但两者可以结合使用。

# 3 模式结构
建造者模式由产品、抽象建造者、具体建造者、指挥者等 4 个要素构成，现在我们来分析其基本结构和实现方法。

建造者模式的主要角色如下：

- **产品角色**：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个部件。
- **抽象建造者**：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法`getResult()`。
- **具体建造者**：实现抽象建造者接口，完成复杂产品的各个部件的具体创建方法。
- **指挥者**：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。

# 4 模式代码
```java
# 产品角色
@Getter
@Setter
@ToString
public class Computer {
    private String cpu;
    private String ram;
    private String ssd;
}

# 抽象建造者
public abstract class AbstractComputerBuilder {
    protected Computer computer = new Computer();
    public abstract void buildCPU();
    public abstract void buildRAM();
    public abstract void buildSSD();
    public Computer getResult() {
        return computer;
    }
}

# 具体建造者
public class HighProfileComputerBuilder extends AbstractComputerBuilder {
    @Override
    public void buildCPU() {
        computer.setCpu("i9");
    }

    @Override
    public void buildRAM() {
        computer.setRam("32G");
    }

    @Override
    public void buildSSD() {
        computer.setSsd("1T");
    }
}

# 指挥者
public class Director {

    private AbstractComputerBuilder builder;

    public Director(AbstractComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer construct() {
        builder.buildCPU();
        builder.buildRAM();
        builder.buildSSD();
        return builder.getResult();
    }

}

# 客户端调用
public class Client {
    public static void main(String[] args) {
        AbstractComputerBuilder builder = new HighProfileComputerBuilder();
        Director director = new Director(builder);
        Computer highProfileComputer = director.construct();
        System.out.println(highProfileComputer); // Computer(cpu=i9, ram=32G, ssd=1T)
    }
}
```
我们也可以建造一个`LowProfileComputerBuilder`，客户端调用时创建低配置电脑建造者即可。

**代码分析**：

- 抽象建造者类中定义了产品的创建方法和返回方法
- 建造者模式的结构中还引入了一个指挥者类Director，该类的作用主要有两个：一方面它隔离了客户与生产过程；另一方面它负责控制产品的生成过程。指挥者针对抽象建造者编程，客户端只需要知道具体建造者的类型，即可通过指挥者类调用建造者的相关方法，返回一个完整的产品对象
- 在客户端代码中，无须关心产品对象的具体组装过程，只需确定具体建造者的类型即可，建造者模式将复杂对象的构建与对象的表现分离开来，这样使得同样的构建过程可以创建出不同的表现。

# 5 总结
**优点**

- 在建造者模式中，客户端不必知道产品内部组成的细节，将产品本身与产品的创建过程解耦，使得相同的创建过程可以创建不同的产品对象。
- 每一个具体建造者都相对独立，而与其他的具体建造者无关，因此可以很方便地替换具体建造者或增加新的具体建造者，用户使用不同的具体建造者即可得到不同的产品对象。
- 可以更加精细地控制产品的创建过程。将复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰，也更方便使用程序来控制创建过程。
- 增加新的具体建造者无须修改原有类库的代码，指挥者类针对抽象建造者类编程，系统扩展方便，符合“开闭原则”。

**缺点**

- 建造者模式所创建的产品一般具有较多的共同点，其组成部分相似，如果产品之间的差异性很大，则不适合使用建造者模式，因此其使用范围受到一定的限制。
- 如果产品的内部变化复杂，可能会导致需要定义很多具体建造者类来实现这种变化，导致系统变得很庞大。

# 6.扩展：模式的简化
我们可以使用 lombok 提供的 `@Builder` 注解实现简单的建造者模式:

```java
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class TV {
    private String name;
    private String address;
    private Date createData;
}
```

编译后的代码如下：
```java
import java.util.Date;

public class TV {
    private String name;
    private String address;
    private Date createData;

    TV(String name, String address, Date createData) {
        this.name = name;
        this.address = address;
        this.createData = createData;
    }

    public static TV.TVBuilder builder() {
        return new TV.TVBuilder();
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public Date getCreateData() {
        return this.createData;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreateData(Date createData) {
        this.createData = createData;
    }

    public String toString() {
        return "TV(name=" + this.getName() + ", address=" + this.getAddress() + ", createData=" + this.getCreateData() + ")";
    }

    public static class TVBuilder {
        private String name;
        private String address;
        private Date createData;

        TVBuilder() {
        }

        public TV.TVBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TV.TVBuilder address(String address) {
            this.address = address;
            return this;
        }

        public TV.TVBuilder createData(Date createData) {
            this.createData = createData;
            return this;
        }

        public TV build() {
            return new TV(this.name, this.address, this.createData);
        }

        public String toString() {
            return "TV.TVBuilder(name=" + this.name + ", address=" + this.address + ", createData=" + this.createData + ")";
        }
    }
}
```

调用者代码：
```java
public class TVClient {
    public static void main(String[] args) {
        TV tv = TV.builder()
                .name("长虹")
                .address("中国")
                .createData(new Date())
                .build();
        System.out.println(tv); // TV(name=长虹, address=中国, createData=Tue Feb 11 11:58:41 CST 2020)
    }
}
```

正文中是标准的建造者模式，扩展中是简单的建造者模式，按需选择。

# 参考资料

- [图说设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/index.html)
- [Java设计模式](http://c.biancheng.net/view/1317.html)