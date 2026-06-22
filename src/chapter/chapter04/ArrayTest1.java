package chapter.chapter04;

/**
 * Java 数组基本操作示例
 *
 * 声明与初始化、访问与修改、遍历、常用统计、二维数组
 */
public class ArrayTest1 {
    public static void main(String[] args) {
        declareAndInitDemo(); // 数组的声明与初始化
        accessAndModifyDemo(); // 访问与修改元素
        traverseDemo(); // 数组遍历
        statsDemo(); // 常用统计
        twoDimensionalDemo(); // 二维数组
    }

    /** 数组的声明与初始化 */
    static void declareAndInitDemo() {
        System.out.println("=== 声明与初始化 ===");

        // 方式1：先声明长度，再赋值（默认值：int 为 0）
        int[] scores = new int[5];
        scores[0] = 90;
        scores[1] = 85;
        scores[2] = 78;
        scores[3] = 92;
        scores[4] = 88;

        // 方式2：声明时直接赋值
        int[] ages = {18, 20, 22, 19};

        // 方式3：匿名数组（常用于方法传参）
        printArray(new int[]{1, 2, 3});

        System.out.println("scores.length = " + scores.length);
        System.out.println("ages = " + java.util.Arrays.toString(ages));
    }

    /** 访问与修改元素 */
    static void accessAndModifyDemo() {
        System.out.println("\n=== 访问与修改 ===");
        String[] fruits = {"apple", "banana", "orange"};

        System.out.println("第一个元素: " + fruits[0]);
        System.out.println("最后一个元素: " + fruits[fruits.length - 1]);

        fruits[1] = "grape";
        System.out.println("修改后: " + java.util.Arrays.toString(fruits));
    }

    /** 数组遍历 */
    static void traverseDemo() {
        System.out.println("\n=== 遍历 ===");
        int[] nums = {10, 20, 30, 40, 50};

        // 普通 for：需要下标时使用
        System.out.print("for 下标遍历: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // 增强 for：只读遍历，简洁
        System.out.print("for-each 遍历: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /** 常用统计：求和、最大值、最小值 */
    static void statsDemo() {
        System.out.println("\n=== 常用统计 ===");
        int[] data = {3, 7, 2, 9, 5};

        int sum = 0;
        int max = data[0];
        int min = data[0];
        for (int value : data) {
            sum += value;
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }

        System.out.println("数组: " + java.util.Arrays.toString(data));
        System.out.println("总和: " + sum);
        System.out.println("平均值: " + (double) sum / data.length);
        System.out.println("最大值: " + max);
        System.out.println("最小值: " + min);
    }

    /** 二维数组 */
    static void twoDimensionalDemo() {
        System.out.println("\n=== 二维数组 ===");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("行数: " + matrix.length);
        System.out.println("第1行列数: " + matrix[0].length);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static void printArray(int[] arr) {
        System.out.println("匿名数组: " + java.util.Arrays.toString(arr));
    }
}
