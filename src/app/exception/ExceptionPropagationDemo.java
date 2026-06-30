package app.exception;

/**
 * 异常传播与堆栈跟踪演示
 *
 * 异常会从发生异常的方法开始，沿着调用链向上层方法传播，
 * 直到被某个 try-catch 捕获，或者传播到 JVM 导致程序终止。
 *
 * 使用 printStackTrace() 可以查看完整的异常调用栈，帮助定位问题。
 */
public class ExceptionPropagationDemo {

    public static void methodA() {
        int result = 1 / 0;
        System.out.println("methodA result = " + result);
    }

    public static void methodB() {
        methodA();
    }

    public static void methodC() {
        methodB();
    }

    public static void main(String[] args) {
        System.out.println("===== 1. 异常沿调用链向上传播 =====");
        try {
            methodC();
        } catch (ArithmeticException e) {
            System.out.println("在 main 方法中捕获到异常：" + e.getMessage());
            System.out.println("\n--- 异常堆栈信息 ---");
            e.printStackTrace();
        }

        System.out.println("\n===== 2. 异常未被捕获会导致程序终止 =====");
        System.out.println("（取消下面代码的注释可观察 JVM 终止效果）");
        // methodC(); // 如果异常未被捕获，程序会在这里异常终止

        System.out.println("\n程序正常结束");
    }
}
