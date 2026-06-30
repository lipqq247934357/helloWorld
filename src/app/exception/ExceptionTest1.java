package app.exception;

public class ExceptionTest1 {

    public static void main(String[] args) {

        try {
            int a = 1 / 0;
        } catch (Exception e) {
            System.out.println("除零错误");
        } finally {
            System.out.println("finally块中的代码总是会执行");
        }

    }


}
