# Java 技术点小白详解

> 本文档面向零基础或刚入门的 Java 学习者，结合 `helloWorld` 项目中的实际代码，尽可能通俗、详细地讲解项目里用到的 Java 技术点。阅读时建议打开项目源码对照着看。

---

## 目录

1. [Java 是什么？项目长什么样？](#第1章-java-是什么项目长什么样)
2. [变量与数据类型：程序里的“盒子”](#第2章-变量与数据类型程序里的盒子)
3. [运算符与流程控制：让程序做判断、重复做事](#第3章-运算符与流程控制让程序做判断重复做事)
4. [数组：一次性管理很多数据](#第4章-数组一次性管理很多数据)
5. [面向对象基础：类、对象、封装](#第5章-面向对象基础类对象封装)
6. [面向对象进阶：继承、包、import](#第6章-面向对象进阶继承包import)
7. [常用工具类：String、日期、数学、计时器](#第7章-常用工具类string日期数学计时器)
8. [异常处理：程序出错了怎么办](#第8章-异常处理程序出错了怎么办)
9. [集合框架：ArrayList 是什么](#第9章-集合框架arraylist-是什么)
10. [IO 与文件操作：读写文件、执行命令](#第10章-io-与文件操作读写文件执行命令)
11. [枚举：限定取值范围](#第11章-枚举限定取值范围)
12. [反射：运行时的“透视眼”](#第12章-反射运行时的透视眼)
13. [设计模式：前人总结的好办法](#第13章-设计模式前人总结的好办法)
14. [正则表达式：文本匹配的利器](#第14章-正则表达式文本匹配的利器)
15. [BigDecimal：钱和精确数字不能乱算](#第15章-bigdecimal钱和精确数字不能乱算)
16. [项目入口与 Git 工具：Main 和 GitPushUtil](#第16章-项目入口与-git-工具main-和-gitpushutil)

---

## 第1章 Java 是什么？项目长什么样？

### 1.1 Java 是什么

Java 是一门非常流行的**编程语言**。你可以把它理解成一种“人和计算机交流的语言”。我们写 Java 代码，告诉计算机要做什么，然后计算机执行。

Java 有一个特点叫“**面向对象**”，后面会重点讲。简单来说，Java 鼓励我们把现实世界的事物抽象成“对象”，然后用代码描述这些对象的行为和属性。

### 1.2 一个最简单的 Java 程序

看项目里的 `src/chapter/chapter01/helloWorld.java`：

```java
package chapter.chapter01;

public class helloWorld {

    public static void main(String[] args) {
        sayHello(args);
    }

    public static void sayHello(String[] args) {
        System.out.println("Hello World");
    }
}
```

这几行代码虽然短，但包含了很多 Java 基础规则：

- `package chapter.chapter01;`：声明这个文件属于 `chapter.chapter01` 这个包。包可以理解为“文件夹”，用来组织代码。
- `public class helloWorld { ... }`：定义一个类，类名是 `helloWorld`。Java 里几乎所有代码都写在类里面。
- `public static void main(String[] args)`：这是程序的**入口**。运行这个类时，JVM（Java 虚拟机）会先找这个方法执行。
- `System.out.println("Hello World");`：在控制台打印一句话。
- `sayHello(args)`：调用另一个方法。

### 1.3 项目的入口 Main.java

项目根目录下还有一个 `src/Main.java`，它是整个项目的“总入口”：

```java
import utils.GitPushUtil;
import chapter.chapter01.helloWorld;

public class Main {

    public static String RepoName = "myProject/helloWorld";
    public static String actionType = "pushGit";

    public static void main(String[] args) {
        switch (actionType) {
            case "helloWorld":
                helloWorld.sayHello(args);
                break;
            default:
                push(Main.RepoName);
                break;
        }
    }

    public static void push(String gitRepoName) {
        try {
            GitPushUtil.push(gitRepoName);
        } catch (Exception e) {
            System.err.println("推送失败: " + e.getMessage());
        }
    }
}
```

这里出现了几个新概念：

- `import`：引入其他包里的类，这样我们就可以直接用它们。
- `static`：静态的，后面会讲。
- `switch`：根据条件选择执行哪段代码。
- `try-catch`：处理异常（程序出错时不会直接崩溃）。

---

## 第2章 变量与数据类型：程序里的“盒子”

### 2.1 变量就像贴标签的盒子

编程时我们需要保存数据，比如用户的年龄、姓名、分数等。变量就是用来存这些数据的地方。

你可以把变量想象成一个盒子：

- 盒子上贴个标签（变量名），方便我们找到它。
- 盒子里装的东西就是数据。
- 不同类型的数据要放在不同类型的盒子里。

看 `src/chapter/chapter02/VariableTest.java`：

```java
public class VariableTest {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(a);
        a = 20;
        System.out.println(a);
    }
}
```

这里 `int a = 10;` 做了三件事：

1. 声明一个类型为 `int`（整数）的变量，名字叫 `a`。
2. 把 `10` 这个值放进变量 `a`。
3. 之后可以用 `a` 来代表这个值。

`a = 20;` 则是把盒子里的内容换成了 `20`。

### 2.2 基本数据类型

Java 有 8 种基本数据类型，你可以把它们理解成 8 种不同大小的盒子：

| 类型 | 中文名 | 占用空间 | 能存什么 | 例子 |
|------|--------|----------|----------|------|
| `byte` | 字节型 | 1 字节 | -128 ~ 127 的整数 | `byte b = 1;` |
| `short` | 短整型 | 2 字节 | 较小的整数 | `short s = 1;` |
| `int` | 整型 | 4 字节 | 最常用的整数 | `int a = 10;` |
| `long` | 长整型 | 8 字节 | 很大的整数 | `long l = 10000000000L;` |
| `float` | 单精度浮点型 | 4 字节 | 小数，精度较低 | `float f = 1.0f;` |
| `double` | 双精度浮点型 | 8 字节 | 小数，精度较高 | `double d = 1.0;` |
| `char` | 字符型 | 2 字节 | 单个字符 | `char c = 'a';` |
| `boolean` | 布尔型 | 1 位（理论） | `true` 或 `false` | `boolean bo1 = true;` |

**一些细节：**

- 整数默认是 `int` 类型，所以 `long l = 10000000000L;` 后面的 `L` 表示“这是一个 long 类型的数字”。
- 小数默认是 `double` 类型，所以 `float f = 1.0f;` 后面的 `f` 表示“这是一个 float 类型的数字”。
- `byte` 范围很小，`byte b = 128;` 会报错，因为超出了范围。
- `boolean` 只有 `true` 和 `false` 两个值，**不能**用 `0` 或 `1` 代替。

### 2.3 常量 final

如果一个变量一旦赋值后就不希望再改变，可以用 `final` 修饰：

```java
final int i = 30;
```

`i` 就被锁定了，后面如果写 `i = 40;` 会报错。这有点像把盒子焊死，只能看不能改。

### 2.4 数据类型转换

有时候我们需要把一种类型的数据转换成另一种类型。

#### 自动类型转换（小盒子放进大盒子）

```java
int a = 10;
double b = a;  // int 自动转成 double
```

因为 `double` 能装下比 `int` 更大的范围，所以 Java 会自动帮你转。

#### 强制类型转换（大盒子塞进小盒子）

```java
double c = 1.0;
int d = (int) c;  // 手动把 double 转成 int
```

大转小可能会**丢失精度**。比如 `1234567890.123` 强制转 `int` 后就变成了 `1234567890`，小数部分没了。

更危险的是**数据溢出**：

```java
int i2 = 128;
byte b = (byte) i2;  // byte 最大是 127，128 会溢出变成 -128
```

### 2.5 String 类型

`String` 是字符串类型，用来保存一串字符：

```java
String str = "123";
```

注意：**`String` 不是基本数据类型，它是引用数据类型**。

字符串和基本类型之间可以互相转换：

```java
String str = "123";
int i = Integer.parseInt(str);  // 把字符串 "123" 转成整数 123
```

字符串用 `+` 和其他类型连接时会自动变成字符串：

```java
System.out.println("" + 12.3f);  // 输出 "12.3"
```

但 `char` 和 `String` 不能隐式转换：

```java
char c1 = 'a';
// String str2 = c1;  // 报错
// String str3 = 'a'; // 也报错，单引号是 char，双引号是 String
```

---

## 第3章 运算符与流程控制：让程序做判断、重复做事

### 3.1 运算符

常见运算符：

- 算术运算符：`+`、`-`、`*`、`/`、`%`（取余）
- 比较运算符：`>`、`<`、`>=`、`<=`、`==`、`!=`
- 赋值运算符：`=`、`+=`、`-=` 等
- 逻辑运算符：`&&`（与）、`||`（或）、`!`（非）

注意浮点数运算有精度问题：

```java
System.out.println(0.1 + 0.2);  // 结果不是精确的 0.3
```

这是因为计算机用二进制表示小数时，很多小数无法精确表示。所以涉及金钱计算时，要用 `BigDecimal`（后面会讲）。

### 3.2 if 分支

程序需要根据条件做不同的事，就要用分支结构。

```java
int score = 78;

if (score >= 90) {
    System.out.println("优秀");
} else if (score >= 60) {
    System.out.println("及格");
} else {
    System.out.println("不及格");
}
```

执行逻辑：

1. 先看 `score >= 90` 是否成立，成立就执行“优秀”。
2. 不成立再看 `score >= 60` 是否成立，成立就执行“及格”。
3. 都不成立就执行 `else` 里的“不及格”。

### 3.3 switch 分支

当条件是很多个固定值时，用 `switch` 更清晰：

```java
int day = 3;

switch (day) {
    case 1:
        System.out.println("星期一");
        break;
    case 2:
        System.out.println("星期二");
        break;
    case 3:
        System.out.println("星期三");
        break;
    default:
        System.out.println("其他");
}
```

每个 `case` 后面通常要加 `break`，否则会继续执行下一个 `case`，这叫做“穿透”。

Java 7 以后，`switch` 还支持 `String`：

```java
String season = "spring";
switch (season) {
    case "spring":
        System.out.println("春天");
        break;
    case "summer":
        System.out.println("夏天");
        break;
    default:
        System.out.println("未知季节");
}
```

### 3.4 for 循环

循环就是让一段代码重复执行。

```java
for (int i = 1; i <= 5; i++) {
    System.out.print(i + " ");
}
```

`for` 循环的三个部分：

1. `int i = 1`：初始化，定义一个计数器。
2. `i <= 5`：条件，满足就继续循环。
3. `i++`：每次循环后计数器加 1。

累加例子：

```java
int sum = 0;
for (int i = 1; i <= 10; i++) {
    sum += i;  // 等价于 sum = sum + i
}
System.out.println(sum);  // 输出 55
```

### 3.5 for-each 增强循环

遍历数组或集合时，可以用更简洁的写法：

```java
int[] nums = {10, 20, 30};
for (int n : nums) {
    System.out.print(n + " ");
}
```

意思是：把 `nums` 里的每个元素依次取出来，赋值给 `n`，然后执行循环体。

### 3.6 while 和 do-while 循环

`while` 先判断条件，再执行：

```java
int count = 3;
while (count > 0) {
    System.out.print(count + " ");
    count--;
}
```

`do-while` 先执行一次，再判断条件，所以至少会执行一次：

```java
int n = 1;
do {
    System.out.println("n = " + n);
    n++;
} while (n <= 3);
```

### 3.7 break 和 continue

- `break`：立刻跳出整个循环。
- `continue`：跳过本次循环，进入下一次。

```java
// 找到第一个能被 7 整除的数就停止
for (int i = 1; i <= 100; i++) {
    if (i % 7 == 0) {
        System.out.println(i);
        break;
    }
}

// 打印 1~10 中的奇数
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) {
        continue;  // 偶数跳过，不打印
    }
    System.out.print(i + " ");
}
```

---

## 第4章 数组：一次性管理很多数据

### 4.1 什么是数组

数组就是一个能装很多相同类型数据的容器。比如一个班级 30 个学生的成绩，就可以用一个 `int` 数组来存。

### 4.2 数组的声明与初始化

有三种常见方式：

```java
// 方式1：先声明长度，再逐个赋值
int[] scores = new int[5];
scores[0] = 90;
scores[1] = 85;

// 方式2：声明时直接赋值
int[] ages = {18, 20, 22, 19};

// 方式3：匿名数组，常用于方法传参
printArray(new int[]{1, 2, 3});
```

注意：

- 数组下标从 `0` 开始，第一个元素是 `scores[0]`。
- `scores.length` 可以得到数组长度。
- 访问 `scores[5]` 会报错（数组越界），因为这个数组只有 5 个元素，下标最大是 4。

### 4.3 数组的访问与修改

```java
String[] fruits = {"apple", "banana", "orange"};
System.out.println(fruits[0]);  // 第一个元素：apple
fruits[1] = "grape";             // 修改第二个元素
```

### 4.4 数组遍历

```java
int[] nums = {10, 20, 30, 40, 50};

// 普通 for，需要下标时用
for (int i = 0; i < nums.length; i++) {
    System.out.println(nums[i]);
}

// 增强 for，只读遍历时更简洁
for (int num : nums) {
    System.out.println(num);
}
```

### 4.5 二维数组

二维数组就是“数组的数组”，可以想象成表格：

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// matrix.length 是行数
// matrix[0].length 是第 1 行的列数
```

遍历二维数组需要两层循环：

```java
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + "\t");
    }
    System.out.println();
}
```

### 4.6 Arrays 工具类

Java 提供了很多操作数组的方法，都在 `java.util.Arrays` 类里。

```java
import java.util.Arrays;

int[] nums = {5, 2, 8, 1, 9};

// 排序
Arrays.sort(nums);

// 二分查找（数组必须先排序）
int index = Arrays.binarySearch(nums, 5);

// 填充
Arrays.fill(arr, 7);  // 所有元素变成 7

// 复制
int[] copied = Arrays.copyOf(original, 5);       // 复制并指定新长度
int[] range = Arrays.copyOfRange(original, 1, 3); // 复制 [1,3) 区间

// 比较内容
Arrays.equals(a, b);

// 打印数组
Arrays.toString(nums);       // 一维数组
Arrays.deepToString(matrix); // 二维数组
```

注意：

- `==` 比较的是两个数组的引用地址，不是内容。要比较内容用 `Arrays.equals()`。
- 二维数组用 `Arrays.toString()` 会打印出一堆地址，要用 `Arrays.deepToString()`。

### 4.7 数组的扩容与缩容

Java 原生数组的长度是固定的。如果想扩容，必须创建一个新数组，把原数据复制过去：

```java
int[] arr = {1, 2, 3};
int[] expanded = new int[arr.length * 2];
System.arraycopy(arr, 0, expanded, 0, arr.length);
arr = expanded;
```

更简洁的写法：

```java
int[] expanded2 = Arrays.copyOf(arr2, arr2.length * 2);
```

缩容同理：

```java
arr = Arrays.copyOf(arr, size);  // 只保留有效元素
```

项目里还写了一个模拟动态数组的类 `DynamicIntArray`，它会自动扩容和缩容，原理和 `ArrayList` 类似。

---

## 第5章 面向对象基础：类、对象、封装

### 5.1 类和对象是什么

面向对象是 Java 最核心的思想。

- **类（Class）**：是一个模板，描述了一类事物的共同特征。比如“手机”是一个类，它有品牌、价格、颜色等属性，能打电话、发短信等行为。
- **对象（Object）**：是类的具体实例。比如“我的华为手机”就是一个对象。

看项目里的 `Phone` 类：

```java
class Phone {
    String brand;
    int price;
    String color;

    public void call() {
        System.out.println("打电话");
    }

    public void sendMessage() {
        System.out.println("发短信");
    }
}
```

使用它：

```java
Phone phone = new Phone();
phone.brand = "华为";
phone.price = 1999;
phone.color = "黑色";
phone.call();
```

### 5.2 构造方法

构造方法是创建对象时自动调用的方法，用来初始化对象。

```java
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// 使用
Person person = new Person("李四", 21);
```

注意：

- 构造方法没有返回值类型，连 `void` 都不能写。
- 方法名必须和类名一样。
- 如果不写构造方法，Java 会自动生成一个无参构造方法；一旦你写了有参构造，就不会再自动生成无参构造。

### 5.3 this 关键字

`this` 代表“当前对象”。当方法参数名和属性名冲突时，用 `this` 区分：

```java
public Person(String name, int age) {
    this.name = name;  // this.name 是属性，name 是参数
    this.age = age;
}
```

### 5.4 封装

封装就是把对象的属性隐藏起来，不让外界直接访问，而是通过方法来操作。

```java
class Animal {
    private String name;  // private：私有，外部不能直接访问
    String color;         // 缺省修饰符：同一个包内可以访问

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        } else {
            System.out.println("名字不能为空");
        }
    }
}
```

使用：

```java
Animal animal = new Animal();
animal.setName("小狗");
System.out.println(animal.getName());
// animal.name = "小猫";  // 报错，name 是 private
```

**为什么要封装？**

- 保护数据，防止被随意修改。
- 可以在设置值时做校验。
- 隐藏内部实现细节，外部只需要知道怎么调用方法。

### 5.5 访问修饰符

Java 有四种访问权限：

| 修饰符 | 同一个类 | 同一个包 | 子类 | 任何地方 |
|--------|----------|----------|------|----------|
| `private` | ✓ | ✗ | ✗ | ✗ |
| 缺省（不写） | ✓ | ✓ | ✗ | ✗ |
| `protected` | ✓ | ✓ | ✓ | ✗ |
| `public` | ✓ | ✓ | ✓ | ✓ |

项目中主要用到了 `private`、`public` 和缺省修饰符。

### 5.6 方法重载（Overload）

同一个类中，可以有多个**同名方法**，只要它们的参数列表不同即可。

```java
class Phone {
    public void show() { }

    public void show(String brand) { }

    public void show(String brand, int price, String color) { }

    public void show(String... brands) { }
}
```

调用时，Java 会根据传入的参数自动匹配对应的方法。

### 5.7 可变参数

`String... brands` 叫可变参数，表示可以传任意多个 `String`：

```java
phone.show("华为", "小米", "oppo");
```

在方法内部，`brands` 其实是一个 `String[]` 数组。

注意：一个方法只能有一个可变参数，而且要放在参数列表的最后。

### 5.8 StringBuilder

字符串拼接频繁时，用 `StringBuilder` 效率更高：

```java
StringBuilder str = new StringBuilder();
for (String brand : brands) {
    str.append(brand).append(" ");
}
System.out.println(str.toString());
```

因为 `String` 是不可变的，每次拼接都会创建新对象；`StringBuilder` 可以在原地修改。

---

## 第6章 面向对象进阶：继承、包、import

### 6.1 继承

继承是指一个类可以继承另一个类的属性和方法。

```java
class Animal {
    String name;
    void eat() {
        System.out.println("吃东西");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("汪汪");
    }
}
```

`Dog` 继承了 `Animal`，所以 `Dog` 对象也有 `name` 属性和 `eat()` 方法，同时还可以有自己的 `bark()` 方法。

### 6.2 包（package）

包用来组织代码，避免类名冲突。比如：

```java
package chapter.chapter01;
```

包名通常和公司域名反写有关，比如 `com.lip.hello`。

### 6.3 import

如果要用其他包里的类，需要 `import`：

```java
import utils.GitPushUtil;
import chapter.chapter01.helloWorld;
```

也可以写全限定类名，不用 import：

```java
orientedobject.basic.pkgdemo.tool.GreetUtil.printGreet(name);
```

注意：`java.lang` 包下的类（如 `String`、`System`）不需要 import。

---

## 第7章 常用工具类：String、日期、数学、计时器

### 7.1 String 类

`String` 是最常用的类之一。它有很多方法：

- `length()`：获取长度
- `substring(begin, end)`：截取子串
- `replaceAll(regex, replacement)`：正则替换
- `contains(str)`：是否包含某字符串
- `equals(str)`：比较内容
- `split(regex)`：按正则分割

项目中用到了 `replaceAll` 做手机号脱敏：

```java
public static String phoneIntervalAddStar(String phone) {
    return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
}
```

### 7.2 StringBuilder

前面讲过，用于高效拼接字符串。

### 7.3 Math

项目中用到了 `Math.max`：

```java
data = new int[Math.max(initialCapacity, 1)];
```

`Math` 类提供了很多数学方法，如 `Math.max()`、`Math.min()`、`Math.random()`、`Math.abs()` 等。

### 7.4 日期时间

Java 中处理日期时间常用 `Date`、`SimpleDateFormat`、`Calendar`。

```java
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

// 格式化日期
SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
String timeStr = sdf.format(new Date());

// 解析字符串为日期
Date date = sdf.parse("20240101123045000");

// Calendar 用于日期计算
Calendar c = Calendar.getInstance();
c.set(Calendar.HOUR_OF_DAY, 0);
```

### 7.5 Timer 定时器

`Timer` 可以定时执行任务：

```java
import java.util.Timer;
import java.util.TimerTask;

new Timer().schedule(new TimerTask() {
    int i = 0;
    public void run() {
        System.out.println(i++);
    }
}, 1000, 1000);
```

意思是：延迟 1 秒后执行，之后每隔 1 秒执行一次。

---

## 第8章 异常处理：程序出错了怎么办

### 8.1 什么是异常

程序运行时可能会出现错误，比如文件找不到、网络断开、数字除以 0 等。这些错误在 Java 里叫“异常”。

如果不处理异常，程序会直接崩溃退出。异常处理就是让我们优雅地处理这些错误。

### 8.2 try-catch

```java
try {
    // 可能出错的代码
    GitPushUtil.push(gitRepoName);
} catch (Exception e) {
    // 出错后执行的代码
    System.err.println("推送失败: " + e.getMessage());
}
```

- `try`：把可能出错的代码放里面。
- `catch`：捕获异常，处理错误。

### 8.3 throws

如果一个方法不想自己处理异常，可以把它抛给调用者：

```java
public static void push(String gitRepoName) throws Exception {
    GitPushUtil.push(gitRepoName);
}
```

调用这个方法的地方就需要处理这个异常，要么继续 `throws`，要么 `try-catch`。

### 8.4 RuntimeException

`RuntimeException` 是运行时异常，不需要强制处理。比如：

```java
throw new RuntimeException("git push 失败");
```

---

## 第9章 集合框架：ArrayList 是什么

### 9.1 集合与数组的区别

数组长度固定，一旦创建就不能改变。如果数据量不确定，用集合更方便。

Java 的集合框架主要分两类：

- `Collection`：存储单个元素，如 `List`、`Set`。
- `Map`：存储键值对，如 `HashMap`。

### 9.2 List 和 ArrayList

`List` 是有序的集合，元素可以重复。

`ArrayList` 是 `List` 的一个实现类，底层就是数组，但它能自动扩容。

```java
import java.util.ArrayList;
import java.util.List;

List<String> list = new ArrayList<>();
list.add("苹果");
list.add("香蕉");
System.out.println(list.get(0));  // 获取第1个元素
```

项目中 `AwardCalculator` 用 `ArrayList` 保存计算结果：

```java
List<String> list = new ArrayList<>();
List<BigDecimal> result = new ArrayList<>(3);
```

---

## 第10章 IO 与文件操作：读写文件、执行命令

### 10.1 File 类

`File` 类代表文件或目录：

```java
File file = new File("/Users/lipeng/Desktop/test.txt");
System.out.println(file.exists());   // 是否存在
System.out.println(file.isFile());   // 是否是文件
System.out.println(file.isDirectory()); // 是否是目录
```

### 10.2 读取文件

```java
FileReader fr = new FileReader(f);
char[] buf = new char[1024];
int len = 0;
while ((len = fr.read(buf)) != -1) {
    System.out.println(new String(buf, 0, len));
}
fr.close();
```

这段代码每次读 1024 个字符，直到读完（`read()` 返回 -1）。

### 10.3 写入文件

```java
FileWriter fw = new FileWriter("C:\\Users\\lijunjie\\Desktop\\test.txt");
fw.write("abcd");
fw.flush();  // 刷新缓冲区
fw.close();  // 关闭流
```

### 10.4 遍历目录

```java
public static List<File> getFileList(String strPath) {
    List<File> filelist = new ArrayList<File>();
    File dir = new File(strPath);
    File[] files = dir.listFiles();
    if (files != null) {
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                getFileList(files[i].getAbsolutePath());  // 递归
            } else if (files[i].getName().endsWith("avi")) {
                filelist.add(files[i]);
            }
        }
    }
    return filelist;
}
```

这段代码递归遍历目录，找出所有 `.avi` 文件。

### 10.5 执行外部命令

Java 可以调用操作系统命令，比如执行 `git push`：

```java
Process process = new ProcessBuilder("git", "-C", repoPath, "push")
        .redirectErrorStream(true)
        .start();

BufferedReader reader = new BufferedReader(
    new InputStreamReader(process.getInputStream())
);
String line;
while ((line = reader.readLine()) != null) {
    System.out.println(line);
}

if (process.waitFor() != 0) {
    throw new RuntimeException("git push 失败");
}
```

这里用 `ProcessBuilder` 启动了一个子进程，执行 `git push`，并读取它的输出。

---

## 第11章 枚举：限定取值范围

### 11.1 什么是枚举

枚举用来定义一组固定的常量。比如性别只有“男”和“女”，就可以用枚举：

```java
public enum EnumsSimple {
    man, woman;
}
```

### 11.2 使用枚举

```java
EnumsSimple gender = EnumsSimple.man;
```

枚举比用 `int` 或 `String` 表示状态更安全，因为取值范围被限定了。

---

## 第12章 反射：运行时的“透视眼”

### 12.1 什么是反射

反射是 Java 的一种机制，可以在程序运行时获取类的信息，比如类有哪些属性、方法、构造方法等。

正常情况下，我们写代码时就知道要调用哪个类。但反射允许程序在运行时才决定操作哪个类。

### 12.2 获取 Class 对象

```java
Class clazz = Class.forName("com.lip.hello.basics.reflect.OperationReportDay");
```

这行代码根据类的全限定名，获取到这个类的 `Class` 对象。

### 12.3 获取类的字段

```java
Field[] fields = clazz.getDeclaredFields();
for (Field field : fields) {
    System.out.println(field.getName());
}
```

`getDeclaredFields()` 能获取类的所有字段，包括 `private` 的。

### 12.4 动态代理

动态代理可以在运行时为接口生成代理对象，常用于 AOP（面向切面编程）。

```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CurrentClass implements InvocationHandler {
    public void hehe() {
        Proxy.newProxyInstance(
            Thread.currentThread().getContextClassLoader(),
            this.getClass().getInterfaces(),
            this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
```

`Proxy.newProxyInstance` 会生成一个代理对象，当调用代理对象的方法时，会进入 `invoke` 方法。

---

## 第13章 设计模式：前人总结的好办法

设计模式是软件开发中反复出现的问题的通用解决方案。项目里练习了多种经典设计模式。

### 13.1 单例模式（Singleton）

单例模式保证一个类只有一个实例。

#### 饿汉式

类加载时就创建实例：

```java
public class HungryType {
    private static HungryType hungryType = new HungryType();

    private HungryType() { }

    public static HungryType getInstance() {
        return hungryType;
    }
}
```

- 构造方法私有，防止外部 `new`。
- 通过一个静态方法返回唯一实例。

#### 懒汉式

第一次使用时才创建实例：

```java
public class LazyType {
    private static LazyType lazyType;

    private LazyType() { }

    public static LazyType getInstance() {
        if (lazyType == null) {
            synchronized (lazyType) {
                lazyType = new LazyType();
            }
        }
        return lazyType;
    }
}
```

这里用 `synchronized` 加锁，防止多线程下创建多个实例。

### 13.2 工厂模式（Factory）

工厂模式把对象的创建逻辑封装起来，调用者不需要知道具体怎么创建对象。

#### 简单工厂

```java
public class Factory {
    public SendMsg sendFactory(String type) {
        switch (type) {
            case "sms":
                return new SendSms();
            case "email":
                return new SendEmail();
            default:
                return new SendEmail();
        }
    }
}
```

根据传入的类型，返回不同的 `SendMsg` 实现类。

#### 多方法工厂

```java
public class Factory {
    public SendMsg sendEmail() {
        return new SendEmail();
    }
    public SendMsg sendSms() {
        return new SendSms();
    }
}
```

每个方法生产一种产品。

#### 静态工厂

工厂方法用 `static` 修饰，可以直接用类名调用。

### 13.3 抽象工厂模式

抽象工厂是工厂的工厂，用来创建一系列相关的产品。

```java
public interface Food {
    void out();
}

public interface Send {
    Food sendFood();
}

public class SendFruit implements Send {
    @Override
    public Food sendFood() {
        return new Fruit();
    }
}
```

### 13.4 适配器模式（Adapter）

适配器模式用于把一个类的接口转换成客户希望的另一种接口。

#### 类适配器

通过继承实现：

```java
public class Entity2 extends Entity1 implements Source {
    @Override
    public void method2() {
        System.out.println("method2");
    }
}
```

`Entity2` 既有 `Entity1` 的方法，又实现了 `Source` 接口的方法。

#### 对象适配器

通过组合实现：

```java
public class Entity2 {
    Entity1 e;

    public void hehe() {
        e = new Entity1();
        e.method1();
    }

    public void method2() {
        System.out.println("method2");
    }
}
```

#### 接口适配器

当接口方法很多，但我们只想实现其中几个时，可以用抽象类空实现所有方法，然后子类选择性重写：

```java
public abstract class SourceAbstract implements Source {
    @Override
    public void method1() { }

    @Override
    public void method2() { }
}

public class Entity1 extends SourceAbstract {
    @Override
    public void method1() {
        System.out.println("method1 strengthen");
    }
}
```

### 13.5 桥接模式（Bridge）

桥接模式把抽象和实现分离，使它们可以独立变化。

```java
public interface Sourceable {
    void method();
}

public class Source1 implements Sourceable {
    @Override
    public void method() {
        System.out.println("source1 method");
    }
}
```

`MyBridge` 持有 `Sourceable`，通过setter切换不同的实现。

### 13.6 装饰器模式（Decorator）

装饰器模式在不改变原类的情况下，动态地给对象添加功能。

```java
public class Decorator {
    public Source c;

    public Decorator(Source c) {
        this.c = c;
    }

    public void hehe() {
        c.hehe();
    }
}
```

`Decorator` 包装了 `Source`，可以在调用前后添加额外逻辑。

### 13.7 观察者模式（Observer）

观察者模式定义了一种一对多的依赖关系。当一个对象状态改变时，所有依赖它的对象都会收到通知。

```java
public interface Observer {
    void act();
}

public class BodyGuard implements Observer {
    @Override
    public void act() {
        System.out.println("bodyGuard go!");
    }
}

public class Jewlry implements Observed {
    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.act();
        }
    }
}
```

使用：

```java
Observed od = new Jewlry();
od.addObserver(new BodyGuard());
od.addObserver(new Police());
od.addObserver(new Thief());
od.notifyObserver();
```

### 13.8 代理模式（Proxy）

代理模式为其他对象提供一种代理，以控制对这个对象的访问。

#### 静态代理

```java
public class Proxy implements Sourceable {
    Source c;

    @Override
    public void method() {
        before();
        c = new Source();
        end();
    }

    public void before() {
        System.out.println("before c");
    }

    public void end() {
        System.out.println("end c");
    }
}
```

代理类在调用真实对象前后增加了额外操作。

#### 动态代理

动态代理在运行时生成代理类，不需要手动写代理类，前面反射部分已介绍。

---

## 第14章 正则表达式：文本匹配的利器

### 14.1 什么是正则表达式

正则表达式是一种描述文本模式的字符串，常用于：

- 验证输入格式（如手机号、邮箱）
- 查找替换文本
- 提取特定内容

### 14.2 手机号脱敏

```java
public static String phoneIntervalAddStar(String phone) {
    return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
}
```

把 `18912345678` 变成 `189****5678`。

### 14.3 手机号校验

```java
public static boolean testPhone(String phone) {
    return Pattern.matches("1[3|4|5|6|7|8]\\d{9}", phone);
}
```

这个正则匹配以 1 开头，第二位是 3-8 之一，后面跟 9 位数字的手机号。

---

## 第15章 BigDecimal：钱和精确数字不能乱算

### 15.1 为什么需要 BigDecimal

前面说过，`double` 和 `float` 有精度问题。涉及金钱、财务计算时，必须用 `BigDecimal`。

```java
BigDecimal amount = new BigDecimal("100.05");
```

注意：最好传入字符串构造，而不是 `double`，否则仍然可能引入精度问题。

### 15.2 常用操作

```java
BigDecimal a = new BigDecimal("10");
BigDecimal b = new BigDecimal("3");

// 加减乘除
BigDecimal sum = a.add(b);
BigDecimal diff = a.subtract(b);
BigDecimal product = a.multiply(b);
BigDecimal quotient = a.divide(b, 2, RoundingMode.HALF_UP);  // 保留2位小数，四舍五入

// 比较大小
if (a.compareTo(b) > 0) {
    System.out.println("a 大于 b");
}
```

### 15.3 取商和余数

```java
BigDecimal[] result = investAmount.divideAndRemainder(maxAmount);
BigDecimal times = result[0];      // 商
BigDecimal award = result[1];      // 余数
```

### 15.4 RoundingMode

`RoundingMode.HALF_UP` 是常用的四舍五入模式。

---

## 第16章 项目入口与 Git 工具：Main 和 GitPushUtil

### 16.1 Main.java 作为总入口

```java
public class Main {
    public static String RepoName = "myProject/helloWorld";
    public static String actionType = "pushGit";

    public static void main(String[] args) {
        switch (actionType) {
            case "helloWorld":
                helloWorld.sayHello(args);
                break;
            default:
                push(Main.RepoName);
                break;
        }
    }
}
```

通过修改 `actionType` 的值，可以切换程序执行不同的逻辑。

### 16.2 GitPushUtil

这个工具类封装了 `git push` 操作：

```java
public class GitPushUtil {
    private static final String DESKTOP_PATH = "/Users/lipeng/Desktop";

    public static String getRepoPath(String gitRepoName) {
        return DESKTOP_PATH + "/" + gitRepoName;
    }

    public static void push(String gitRepoName) throws Exception {
        String repoPath = getRepoPath(gitRepoName);
        Process process = new ProcessBuilder("git", "-C", repoPath, "push")
                .redirectErrorStream(true)
                .start();
        // ...
    }
}
```

它把仓库名转换成完整路径，然后调用系统命令推送代码。

---

## 总结

这个项目几乎涵盖了 Java 基础到进阶的大部分核心知识：

- **基础语法**：变量、数据类型、运算符、流程控制、数组。
- **面向对象**：类、对象、构造方法、封装、继承、方法重载、包、import。
- **常用 API**：String、StringBuilder、Arrays、Date、Calendar、Timer。
- **异常处理**：try-catch、throws。
- **集合框架**：ArrayList。
- **IO 操作**：File、FileReader、FileWriter、ProcessBuilder。
- **高级特性**：枚举、反射、动态代理。
- **设计模式**：单例、工厂、抽象工厂、适配器、桥接、装饰器、观察者、代理。
- **正则表达式**：文本匹配与替换。
- **精确计算**：BigDecimal。

建议学习顺序：先掌握基础语法和面向对象，再学习常用 API 和异常处理，最后研究设计模式、反射等进阶内容。

---

> 文档结束。如果有具体某一段代码看不懂，可以打开对应的 `.java` 文件，配合本文档的说明逐行分析。
