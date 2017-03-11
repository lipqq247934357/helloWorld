package desginPattern.factoryPattern.staticfactoryPattern;

/**
 * 
 * @Description: send email
 * @Author TigerYoung1
 * @Date 2016年10月21日 下午2:03:38
 */

public class SendEmail {

    public static SendEmail sendEmailInstance(){
        
        return new SendEmail();
        
    }

}
