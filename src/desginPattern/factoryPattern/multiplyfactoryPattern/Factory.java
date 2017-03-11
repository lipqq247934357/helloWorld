package desginPattern.factoryPattern.multiplyfactoryPattern;

/**
 * 
 * @Description: send message factory
 * @Author TigerYoung1
 * @Date 2016年10月21日 下午2:05:14
 */

public class Factory {

    public SendMsg sendEmail(){
        return new SendEmail();
    }
    public SendMsg sendSms(){
        return new SendSms();
    }

    public static void main(String[] args) {
        
        
        
    }
}
