package app.exception;

/**
 * 常见运行时异常（RuntimeException）演示
 *
 * 运行时异常在编译阶段不需要处理，但运行时会抛出。
 * 常见类型包括：NullPointerException、ArrayIndexOutOfBoundsException、
 * NumberFormatException、ClassCastException、ArithmeticException 等。
 */
public class ExceptionRuntimeDemo {

    public static void main(String[] args) {
        System.out.println("===== 1. 空指针异常 NullPointerException =====");
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("捕获到空指针异常：" + e.getClass().getSimpleName());
        }

        System.out.println("\n===== 2. 数组越界异常 ArrayIndexOutOfBoundsException =====");
        try {
            int[] arr = new int[3];
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获到数组越界异常：" + e.getMessage());
        }

        System.out.println("\n===== 3. 数字格式异常 NumberFormatException =====");
        try {
            int number = Integer.parseInt("abc123");
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("捕获到数字格式异常：" + e.getMessage());
        }

        System.out.println("\n===== 4. 类型转换异常 ClassCastException =====");
        try {
            Object obj = "hello";
            Integer num = (Integer) obj;
            System.out.println(num);
        } catch (ClassCastException e) {
            System.out.println("捕获到类型转换异常：" + e.getMessage());
        }

        System.out.println("\n===== 5. 算术异常 ArithmeticException =====");
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("捕获到算术异常：" + e.getMessage());
        }

        System.out.println("\n程序正常结束");
    }
}
