/**
 * Java 运算符示例
 *
 * 算术、赋值、关系、逻辑、位运算、三元运算符
 */
public class OperatorDemo {
    public static void main(String[] args) {
        arithmetic();
        assignment();
        increment();
        relational();
        logical();
        bitwise();
        ternary();
    }

    /** 算术运算符：+ - * / % */
    static void arithmetic() {
        System.out.println("=== 算术运算符 ===");
        int a = 10, b = 3;
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));       // 整除，结果为 3
        System.out.println("a % b = " + (a % b));       // 取余，结果为 1

        double x = 10.0, y = 3.0;
        System.out.println("x / y = " + (x / y));       // 浮点除法
    }

    /** 赋值运算符：= += -= *= /= %= */
    static void assignment() {
        System.out.println("\n=== 赋值运算符 ===");
        int n = 5;
        n += 3;   // n = n + 3
        System.out.println("n += 3  -> " + n);
        n -= 2;
        System.out.println("n -= 2  -> " + n);
        n *= 2;
        System.out.println("n *= 2  -> " + n);
        n /= 4;
        System.out.println("n /= 4  -> " + n);
        n %= 3;
        System.out.println("n %= 3  -> " + n);
    }

    /** 自增自减：++ -- （前缀与后缀区别） */
    static void increment() {
        System.out.println("\n=== 自增自减 ===");
        int i = 5;
        System.out.println("i = " + i);
        System.out.println("i++ = " + (i++));   // 先取值再 +1，输出 5
        System.out.println("i = " + i);         // 6
        System.out.println("++i = " + (++i));   // 先 +1 再取值，输出 7
        System.out.println("i = " + i);

        int j = 5;
        System.out.println("--j = " + (--j));   // 4
        System.out.println("j-- = " + (j--));   // 4，之后 j 为 3
        System.out.println("j = " + j);
    }

    /** 关系运算符：== != < > <= >= */
    static void relational() {
        System.out.println("\n=== 关系运算符 ===");
        int a = 10, b = 20;
        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));
        System.out.println("a < b  : " + (a < b));
        System.out.println("a > b  : " + (a > b));
        System.out.println("a <= b : " + (a <= b));
        System.out.println("a >= b : " + (a >= b));
    }

    /** 逻辑运算符：&& || ! （短路求值） */
    static void logical() {
        System.out.println("\n=== 逻辑运算符 ===");
        boolean p = true, q = false;
        System.out.println("p && q : " + (p && q));
        System.out.println("p || q : " + (p || q));
        System.out.println("!p     : " + (!p));
        System.out.println("p ^ q : " + (p ^ q));

        // 短路：&& 左侧为 false 时不再计算右侧
        int x = 0;
        boolean ok = (x != 0) && (10 / x > 1);  // 不会除零
        System.out.println("短路 && : " + ok); // 单&会计算右侧，双&不会计算右侧，一般开发中使用双&；
    }

    /** 位运算符：& | ^ ~ << >> >>> */
    static void bitwise() {
        System.out.println("\n=== 位运算符 ===");
        int a = 12;   // 1100
        int b = 10;   // 1010
        System.out.println("a & b  : " + (a & b));   // 1000 -> 8
        System.out.println("a | b  : " + (a | b));   // 1110 -> 14
        System.out.println("a ^ b  : " + (a ^ b));   // 0110 -> 6
        System.out.println("~a     : " + (~a));
        System.out.println("a << 1 : " + (a << 1));  // 左移，*2
        System.out.println("a >> 1 : " + (a >> 1));  // 右移，/2
        System.out.println("-1 >>> 1 : " + (-1 >>> 1)); // 无符号右移
    }

    /** 三元运算符：条件 ? 值1 : 值2 */
    static void ternary() {
        System.out.println("\n=== 三元运算符 ===");
        int score = 85;
        String level = score >= 60 ? "及格" : "不及格";
        System.out.println("score=" + score + " -> " + level);

        int max = (3 > 7) ? 3 : 7;
        System.out.println("max(3,7) = " + max);
    }
}
