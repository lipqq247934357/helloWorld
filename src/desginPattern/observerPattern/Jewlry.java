package desginPattern.observerPattern;

/**
 * 
 * @Description: jewel
 * @Author TigerYoung1
 * @Date 2016年10月21日 下午6:56:33
 */
public class Jewlry implements Observed{

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void delObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        
        for(Observer o :observers){
            o.act();
        }
    }
    
    public void willGo(){
        notifyObserver();
    }
    
    
    public static void main(String[] args) {
        
        //observered
        Observed od =  new Jewlry();
        
        //observer
        Observer o1 = new BodyGuard();
        Observer o2 = new Police();
        Observer o3 = new Thief();
        
        //add observer
        od.addObserver(o1);
        od.addObserver(o2);
        od.addObserver(o3);
        
        //launch event
        od.notifyObserver();
        
    }

}
