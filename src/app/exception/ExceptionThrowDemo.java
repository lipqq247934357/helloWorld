package app.exception;

/**
 * throw 手动抛出异常演示
 *
 * 当程序出现业务逻辑错误时，可以使用 throw 主动抛出一个异常对象。
 * 抛出的异常可以是 JDK 内置异常，也可以是自定义异常。
 */
public class ExceptionThrowDemo {

    /**
     * 根据年龄判断是否可以进入网吧
     * 若年龄小于 18 岁，则抛出 IllegalArgumentException
     */
    public static void enterInternetCafe(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("年龄未满 18 岁，禁止进入网吧");
        }
        System.out.println("年龄符合要求，允许进入网吧");
    }

    /**
     * 计算长方形面积，若参数非法则抛出异常
     */
    public static int rectangleArea(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("宽和高必须大于 0，当前 width=" + width + ", height=" + height);
        }
        return width * height;
    }

    public static void main(String[] args) {
        System.out.println("===== 1. 手动抛出运行时异常 =====");
        try {
            enterInternetCafe(16);
        } catch (IllegalArgumentException e) {
            System.out.println("捕获到异常：" + e.getMessage());
        }

        System.out.println("\n===== 2. 参数校验后抛出异常 =====");
        try {
            int area = rectangleArea(-5, 10);
            System.out.println("面积：" + area);
        } catch (IllegalArgumentException e) {
            System.out.println("捕获到异常：" + e.getMessage());
        }

        System.out.println("\n===== 3. 正常情况 =====");
        enterInternetCafe(20);
        int area = rectangleArea(5, 10);
        System.out.println("面积：" + area);

        System.out.println("\n程序正常结束");
    }
}
