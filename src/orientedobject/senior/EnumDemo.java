package orientedobject.senior;

/**
 * 枚举类（Enum）用法演示
 *
 * 核心要点：
 * 1. 枚举使用 enum 关键字定义，本质上是一种特殊的类，继承自 java.lang.Enum；
 * 2. 枚举常量必须写在第一行，多个常量用逗号分隔；
 * 3. 枚举构造方法默认私有，不能在外部 new；
 * 4. 枚举可以拥有字段、方法、抽象方法，也可以实现接口；
 * 5. 常用方法：values() 获取所有常量，valueOf(String) 根据名称获取常量，ordinal() 获取索引。
 */
public class EnumDemo {

    public static void main(String[] args) {
        // 1. 基本枚举使用
        System.out.println("===== 基本枚举 =====");
        Season spring = Season.SPRING;
        System.out.println("当前季节：" + spring);
        System.out.println("季节名称：" + spring.name());
        System.out.println("季节序号：" + spring.ordinal());

        System.out.println("------------");

        // 2. 遍历所有枚举常量
        System.out.println("===== 遍历枚举 =====");
        for (Season season : Season.values()) {
            System.out.println(season);
        }

        System.out.println("------------");

        // 3. 带属性和构造方法的枚举
        System.out.println("===== 带属性的枚举 =====");
        Weekday monday = Weekday.MONDAY;
        System.out.println(monday.getCode() + " -> " + monday.getDesc());

        System.out.println("------------");

        // 4. valueOf 根据名称获取枚举
        System.out.println("===== valueOf =====");
        Weekday friday = Weekday.valueOf("FRIDAY");
        System.out.println("FRIDAY 的描述：" + friday.getDesc());

        System.out.println("------------");

        // 5. 枚举实现接口
        System.out.println("===== 枚举实现接口 =====");
        Operation add = Operation.ADD;
        System.out.println("10 + 5 = " + add.calculate(10, 5));
        System.out.println("10 - 5 = " + Operation.SUBTRACT.calculate(10, 5));

        System.out.println("------------");

        // 6. switch 中使用枚举
        System.out.println("===== switch 中使用枚举 =====");
        printWeekdayInfo(Weekday.SATURDAY);
    }

    public static void printWeekdayInfo(Weekday day) {
        switch (day) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println(day.getDesc() + " 是工作日");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println(day.getDesc() + " 是休息日");
                break;
            default:
                System.out.println("未知");
        }
    }
}

/**
 * 简单枚举：季节
 */
enum Season {
    SPRING, SUMMER, AUTUMN, WINTER
}

/**
 * 带属性和构造方法的枚举：星期
 */
enum Weekday {
    MONDAY(1, "星期一"),
    TUESDAY(2, "星期二"),
    WEDNESDAY(3, "星期三"),
    THURSDAY(4, "星期四"),
    FRIDAY(5, "星期五"),
    SATURDAY(6, "星期六"),
    SUNDAY(7, "星期日");

    private final int code;
    private final String desc;

    // 枚举构造方法默认为 private
    Weekday(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

/**
 * 枚举实现接口：四则运算
 */
enum Operation implements Calculator {
    ADD {
        @Override
        public double calculate(double a, double b) {
            return a + b;
        }
    },
    SUBTRACT {
        @Override
        public double calculate(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        public double calculate(double a, double b) {
            return a * b;
        }
    },
    DIVIDE {
        @Override
        public double calculate(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("除数不能为 0");
            }
            return a / b;
        }
    }
}

/**
 * 计算接口
 */
interface Calculator {
    double calculate(double a, double b);
}
