package desginPattern.bridgePattern;

public class MyBridge implements Bridge{

    Sourceable sou;

    @Override
    public void setSourceable(Sourceable sou) {
        this.sou = sou;
    }

    @Override
    public Sourceable getSourceable() {
        return sou;
    }
    


    
    
}
