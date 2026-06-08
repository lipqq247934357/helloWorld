/**
 * Java 流程控制示例
 *
 * 分支：if / switch；循环：for / while / do-while；跳转：break / continue
 */
public class FlowControlDemo {
    public static void main(String[] args) {
        ifDemo();
        switchDemo();
        forDemo();
        forEachDemo();
        whileDemo();
        doWhileDemo();
        breakContinueDemo();
    }

    /** if / if-else / if-else-if */
    static void ifDemo() {
        System.out.println("=== if 分支 ===");
        int score = 78;

        if (score >= 90) {
            System.out.println("score=" + score + " -> 优秀");
        } else if (score >= 60) {
            System.out.println("score=" + score + " -> 及格");
        } else {
            System.out.println("score=" + score + " -> 不及格");
        }

        // 单分支
        if (score > 0) {
            System.out.println("分数有效");
        }
    }

    /** switch 多分支 */
    static void switchDemo() {
        System.out.println("\n=== switch 分支 ===");
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

        // switch 支持 String（Java 7+）
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
    }

    /** for 循环 */
    static void forDemo() {
        System.out.println("\n=== for 循环 ===");
        System.out.print("1~5: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 累加 1 + 2 + ... + 10
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("1~10 累加 = " + sum);
    }

    /** 增强 for（for-each） */
    static void forEachDemo() {
        System.out.println("\n=== for-each 循环 ===");
        int[] nums = {10, 20, 30};
        System.out.print("数组元素: ");
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    /** while 循环：先判断再执行 */
    static void whileDemo() {
        System.out.println("\n=== while 循环 ===");
        int count = 3;
        System.out.print("倒数: ");
        while (count > 0) {
            System.out.print(count + " ");
            count--;
        }
        System.out.println();
    }

    /** do-while 循环：至少执行一次 */
    static void doWhileDemo() {
        System.out.println("\n=== do-while 循环 ===");
        int n = 1;
        do {
            System.out.println("n = " + n);
            n++;
        } while (n <= 3);
    }

    /** break 跳出循环；continue 跳过本次 */
    static void breakContinueDemo() {
        System.out.println("\n=== break / continue ===");

        // break：找到第一个能被 7 整除的数就停止
        System.out.print("第一个能被 7 整除的数: ");
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                System.out.println(i);
                break;
            }
        }

        // continue：打印 1~10 中的奇数
        System.out.print("1~10 奇数: ");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
