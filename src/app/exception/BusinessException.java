package app.exception;

/**
 * 自定义运行时业务异常
 *
 * 继承 RuntimeException 表示这是一个运行时异常，
 * 调用方可以选择捕获处理，也可以不处理。
 */
public class BusinessException extends RuntimeException {

    private final String errorCode;

    public BusinessException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
