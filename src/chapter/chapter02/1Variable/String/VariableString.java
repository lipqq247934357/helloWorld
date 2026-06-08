/**
 * 
 * 基本数据类型与String类型之间的转换
 * 
 * String是引用数据类型，不是基本数据类型；
 * 
 * 1.基本数据类型与String类型之间的转换；
 * 2.String类型与基本数据类型之间的转换；
 *  String与基本数据类型之间只能进行“+”运算，不能进行其他运算；
 * 
 */

public class VariableString {
    public static void main(String[] args) {
        String str = "123";
        int i = Integer.parseInt(str);
        System.out.println(i);

        // int i1 = (int)"123"; // 报错，不能将String类型赋值给int类型；
        Integer i2 = Integer.parseInt("12345"); // 将String类型转换为Integer类型；
        System.out.println(i2);

        char c1 = 'a';
        // String str2 = c1; // char无法转换为String
        // char c2 = "a"; // String无法转换为char 双引号是String类型
        // String str3 = 'a'; // char无法转换为String 单引号是char类型
        System.out.println(c1 + " " + true); // 输出a true，因为char和boolean可以进行+运算；
        System.out.println("" + 12.3f); // 输出12.3，因为char和float可以进行+运算；


    }
}
