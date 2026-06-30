package app.exception;

/**
 * 自定义编译时校验异常
 *
 * 继承 Exception 表示这是一个编译时异常，
 * 调用方必须显式处理（try-catch 或 throws）。
 */
public class ValidateException extends Exception {

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }
}
