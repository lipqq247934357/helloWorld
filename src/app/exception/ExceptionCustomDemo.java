package app.exception;

/**
 * 自定义异常演示
 *
 * 自定义异常通常继承 Exception 或 RuntimeException：
 * - 继承 Exception：编译时异常，调用方必须处理
 * - 继承 RuntimeException：运行时异常，调用方可选处理
 *
 * 自定义异常可以扩展额外属性，例如错误码、错误详情等。
 */
public class ExceptionCustomDemo {

    /**
     * 校验用户名，若为空则抛出运行时业务异常
     */
    public static void checkUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new BusinessException("B001", "用户名不能为空");
        }
        System.out.println("用户名校验通过：" + username);
    }

    /**
     * 校验密码强度，若不符合则抛出编译时校验异常
     */
    public static void checkPassword(String password) throws ValidateException {
        if (password == null || password.length() < 6) {
            throw new ValidateException("密码长度不能少于 6 位");
        }
        System.out.println("密码强度校验通过");
    }

    public static void main(String[] args) {
        System.out.println("===== 1. 使用自定义运行时异常 =====");
        try {
            checkUsername("");
        } catch (BusinessException e) {
            System.out.println("错误码：" + e.getErrorCode() + "，错误信息：" + e.getMessage());
        }

        System.out.println("\n===== 2. 使用自定义编译时异常 =====");
        try {
            checkPassword("123");
        } catch (ValidateException e) {
            System.out.println("校验失败：" + e.getMessage());
        }

        System.out.println("\n===== 3. 正常情况 =====");
        checkUsername("admin");
        try {
            checkPassword("123456");
        } catch (ValidateException e) {
            System.out.println("校验失败：" + e.getMessage());
        }

        System.out.println("\n程序正常结束");
    }
}
