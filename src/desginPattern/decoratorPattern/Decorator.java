package desginPattern.decoratorPattern;

public class Decorator {

    public Source c;
    
    public Decorator(Source c){
        this.c = c;
    }
    
    public void hehe(){
        c.hehe();
    }
}
