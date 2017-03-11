package desginPattern.factoryPattern.simplefactoryPattern;

/**
 * 
 * @Description: send email
 * @Author TigerYoung1
 * @Date 2016年10月21日 下午2:03:38
 */

public class SendEmail implements SendMsg{

    @Override
    public void sendMsg() {

        System.out.println("send email");
        
    }

}
