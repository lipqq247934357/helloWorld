/**
 * 
 * 基本数据类型之间的转换
 * 
 */

public class VariableTest2 {
    public static void main(String[] args) {
        // 自动类型转换
        int a = 10;
        double b = a;
        System.out.println(b);

        // 强制类型转换
        double c = 1.0;
        int d = (int) c;
        System.out.println(d);
    }
}
