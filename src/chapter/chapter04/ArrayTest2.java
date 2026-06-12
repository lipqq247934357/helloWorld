package chapter.chapter04;

import java.util.Arrays;

/**
 * Java 数组扩容与缩容示例
 *
 * Java 原生数组长度固定，扩容/缩容需创建新数组并复制元素
 */
public class ArrayTest2 {
    public static void main(String[] args) {
        expandDemo();
        shrinkDemo();
        dynamicArrayDemo();
    }

    /** 扩容：数组已满时，创建更大数组并复制原数据 */
    static void expandDemo() {
        System.out.println("=== 扩容 ===");

        int[] arr = {1, 2, 3};
        int newCapacity = arr.length * 2;

        System.out.println("扩容前: " + Arrays.toString(arr) + ", length = " + arr.length);

        // 方式1：手动复制到新数组
        int[] expanded = new int[newCapacity];
        System.arraycopy(arr, 0, expanded, 0, arr.length);
        expanded[3] = 4;
        expanded[4] = 5;
        arr = expanded;

        System.out.println("扩容后: " + Arrays.toString(arr) + ", length = " + arr.length);

        // 方式2：Arrays.copyOf（更简洁，常用于扩容）
        int[] arr2 = {10, 20, 30};
        int[] expanded2 = Arrays.copyOf(arr2, arr2.length * 2);
        expanded2[3] = 40;
        System.out.println("copyOf 扩容: " + Arrays.toString(expanded2) + ", length = " + expanded2.length);
    }

    /** 缩容：有效元素较少时，创建更小数组释放多余空间 */
    static void shrinkDemo() {
        System.out.println("\n=== 缩容 ===");

        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        int size = 3;

        System.out.println("缩容前: 有效元素 " + size + " 个, 数组 length = " + arr.length);

        // 只保留有效元素，缩容到实际大小
        arr = Arrays.copyOf(arr, size);

        System.out.println("缩容后: " + Arrays.toString(arr) + ", length = " + arr.length);
    }

    /** 模拟动态数组：按需自动扩容与缩容 */
    static void dynamicArrayDemo() {
        System.out.println("\n=== 动态数组模拟 ===");

        DynamicIntArray list = new DynamicIntArray(2);

        for (int i = 1; i <= 6; i++) {
            list.add(i);
            System.out.println("add " + i + " -> " + list);
        }

        for (int i = 0; i < 4; i++) {
            list.removeLast();
            System.out.println("removeLast -> " + list);
        }
    }

    /** 简易动态 int 数组：满则 2 倍扩容，使用率低于 1/4 则缩为 1/2 */
    static class DynamicIntArray {
        private int[] data;
        private int size;

        DynamicIntArray(int initialCapacity) {
            data = new int[Math.max(initialCapacity, 1)];
            size = 0;
        }

        void add(int value) {
            if (size == data.length) {
                expand();
            }
            data[size++] = value;
        }

        void removeLast() {
            if (size == 0) {
                return;
            }
            size--;
            if (size > 0 && size <= data.length / 4) {
                shrink();
            }
        }

        private void expand() {
            int newCapacity = data.length * 2;
            data = Arrays.copyOf(data, newCapacity);
            System.out.println("  [扩容] capacity -> " + newCapacity);
        }

        private void shrink() {
            int newCapacity = Math.max(data.length / 2, 1);
            data = Arrays.copyOf(data, newCapacity);
            System.out.println("  [缩容] capacity -> " + newCapacity);
        }

        @Override
        public String toString() {
            return "elements=" + Arrays.toString(Arrays.copyOf(data, size))
                    + ", size=" + size
                    + ", capacity=" + data.length;
        }
    }
}
