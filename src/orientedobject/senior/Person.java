package orientedobject.senior;

public class Person {
    public static String Country = "China";
    public static String CountryCode = "CN";
    public String name;
    public int age;
    public String address;

    public String getName() {
        return name;
    }

    public static String getCountry() {
        // 无法从 static 上下文引用 'orientedobject.senior.Person.this'
        // System.out.println(this.name);
        // 无法从 static 上下文引用非 static 方法 'getName()'
        // getName();
        System.out.println(CountryCode);
        getCountryCode();
        return Country;
    }

    public static void getCountryCode() {
        System.out.println(CountryCode);
    }

    public static void main(String[] args) {
    }
}
