package desginPattern.factoryPattern.staticfactoryPattern;

/**
 * 
 * @Description: send  message 
 * @Author TigerYoung1
 * @Date 2016年10月21日 下午2:01:33
 */

public class SendSms {

    public static SendSms getSendSmsInstance(){
        return new SendSms();
    }

}
