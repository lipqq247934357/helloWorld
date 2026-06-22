package chapter.chapter04;

import java.util.Arrays;
import java.util.Comparator;

/**
 * java.util.Arrays 工具类常用方法示例
 *
 * 排序、查找、填充、复制、比较、打印等
 */
public class ArrayTest3 {
    public static void main(String[] args) {
        printDemo(); // 打印数组
        sortDemo(); // 排序
        searchDemo(); // 查找
        fillAndCopyDemo(); // 填充与复制
        equalsDemo(); // 比较数组是否相等
    }

    /** 打印数组 */
    static void printDemo() {
        System.out.println("=== 打印 ===");

        int[] nums = {3, 1, 4, 1, 5};
        int[][] matrix = {{1, 2}, {3, 4}};

        // 一维数组
        System.out.println("toString: " + Arrays.toString(nums));

        // 二维数组需用 deepToString，否则打印的是引用地址
        System.out.println("deepToString: " + Arrays.deepToString(matrix));
    }

    /** 排序 */
    static void sortDemo() {
        System.out.println("\n=== 排序 ===");

        int[] nums = {5, 2, 8, 1, 9};
        System.out.println("排序前: " + Arrays.toString(nums));

        // 升序排序（修改原数组）
        Arrays.sort(nums);
        System.out.println("升序: " + Arrays.toString(nums));

        // 部分区间排序：从 index 1 到 index 3（不含 4）
        int[] partial = {5, 2, 8, 1, 9};
        Arrays.sort(partial, 1, 4);
        System.out.println("部分排序 [1,4): " + Arrays.toString(partial));

        // 对象数组：按自定义规则排序
        String[] names = {"Tom", "Amy", "Bob"};
        Arrays.sort(names, Comparator.comparing(String::length));
        System.out.println("按长度排序: " + Arrays.toString(names));
    }

    /** 查找（二分查找，数组须已排序） */
    static void searchDemo() {
        System.out.println("\n=== 查找 ===");

        int[] nums = {1, 3, 5, 7, 9};
        int index = Arrays.binarySearch(nums, 5);
        int notFound = Arrays.binarySearch(nums, 4);

        System.out.println("数组: " + Arrays.toString(nums));
        System.out.println("查找 5 -> index = " + index);
        System.out.println("查找 4 -> index = " + notFound + "（负数表示插入点）");
    }

    /** 填充与复制 */
    static void fillAndCopyDemo() {
        System.out.println("\n=== 填充与复制 ===");

        // fill：用同一值填充
        int[] arr = new int[5];
        Arrays.fill(arr, 7);
        System.out.println("fill(7): " + Arrays.toString(arr));

        // 部分填充
        int[] partial = {1, 2, 3, 4, 5};
        Arrays.fill(partial, 1, 4, 0);
        System.out.println("fill [1,4) 为 0: " + Arrays.toString(partial));

        // copyOf：复制并指定新长度（常用于扩容/缩容）
        int[] original = {10, 20, 30};
        int[] copied = Arrays.copyOf(original, 5);
        System.out.println("copyOf 扩到 5: " + Arrays.toString(copied));

        // copyOfRange：复制指定区间 [from, to)
        int[] range = Arrays.copyOfRange(original, 1, 3);
        System.out.println("copyOfRange [1,3): " + Arrays.toString(range));
    }

    /** 比较数组是否相等 */
    static void equalsDemo() {
        System.out.println("\n=== 比较 ===");

        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        int[] c = {1, 2, 4};

        System.out.println("a = " + Arrays.toString(a));
        System.out.println("b = " + Arrays.toString(b));
        System.out.println("c = " + Arrays.toString(c));
        System.out.println("a equals b: " + Arrays.equals(a, b));
        System.out.println("a equals c: " + Arrays.equals(a, c));

        // 注意：== 比较的是引用地址，不是内容
        int[] d = a;
        System.out.println("a == d: " + (a == d));
        System.out.println("a == b: " + (a == b));
    }
}
