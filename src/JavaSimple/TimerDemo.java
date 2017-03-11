package JavaSimple;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    
    public static void main(String[] args) {
        
        new Timer().schedule(new TimerTask(){
            int i = 0;
            public void run(){
                System.out.println(i++);
            }
        },1000,1000);
    }
}
