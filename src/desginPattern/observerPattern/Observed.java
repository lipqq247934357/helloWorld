package desginPattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

public interface Observed {

    public static final List<Observer> observers = new ArrayList<Observer>();
    
    public void addObserver(Observer o);
    
    public void delObserver(Observer o);
    
    public void notifyObserver();
}
