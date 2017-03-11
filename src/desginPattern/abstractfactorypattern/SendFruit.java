package desginPattern.abstractfactorypattern;

public class SendFruit implements Send {

    @Override
    public Food sendFood() {
        return new Fruit();
    }

}
