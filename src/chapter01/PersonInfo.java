public class PersonInfo {
    
    private String name;
    private int age;
    public static void main(String[] args) {
        PersonInfo personInfo = new PersonInfo();
        personInfo.name = "张三";
        personInfo.age = 20;
        System.out.println(personInfo.name + " " + personInfo.age);
    }

}
