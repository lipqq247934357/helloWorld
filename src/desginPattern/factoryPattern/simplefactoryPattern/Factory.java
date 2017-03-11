package desginPattern.factoryPattern.simplefactoryPattern;

/**
 * 
 * @Description: send message factory
 * @Author TigerYoung1
 * @Date 2016年10月21日 下午2:05:14
 */

public class Factory {

    public SendMsg sendFactory(String type) {
        switch (type) {
        case "sms":
            return new SendSms();
        case "email":
            return new SendEmail();
        default:
            return new SendEmail();
        }
    }

    public static void main(String[] args) {
        
        //send msg 
        
    }
    
}



