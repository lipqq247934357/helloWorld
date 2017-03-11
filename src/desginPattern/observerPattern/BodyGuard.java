package desginPattern.observerPattern;

public class BodyGuard implements Observer{

    @Override
    public void act() {
        System.out.println("bodyGuard go!");
    }

}
