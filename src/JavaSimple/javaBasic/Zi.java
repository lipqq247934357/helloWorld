package JavaSimple.javaBasic;

public class Zi extends Fu{

    String name = "Zi";
    
   public Zi(){
        System.out.println(this.name);
    }
   
   public static void main(String[] args) {
    
       new Zi();
       //结论：父类是初始化自身的。
}
   
}
