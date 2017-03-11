package desginPattern.abstractfactorypattern;

public class SendVegetable implements Send{

    @Override
    public Food sendFood() {
        
        return new Vegetable();
    }

}
