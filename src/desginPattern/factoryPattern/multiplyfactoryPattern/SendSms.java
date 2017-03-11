package desginPattern.factoryPattern.multiplyfactoryPattern;

/**
 * 
 * @Description: send  message 
 * @Author TigerYoung1
 * @Date 2016年10月21日 下午2:01:33
 */

public class SendSms implements SendMsg{

    @Override
    public void sendMsg() {
        System.out.println("send message");
    }

}
