/**
 * 
 * 基本数据类型之间的转换
 * 
 * 1.当容量小的数据类型与容量大的数据类型做运算时，结果会自动转换为容量大的数据类型；
 * 
 */

public class VariableTranster {
    public static void main(String[] args) {
        // 自动类型转换，容量小的类型自动转换为容量大的类型；
        int a = 10;
        double b = a;
        System.out.println(b);

        // 强制类型转换，容量大的类型强制转换为容量小的类型；
        double c = 1.0;
        int d = (int) c;
        System.out.println(d);

        long l = 100; // 默认是int类型，强制转换为long类型；赋值给l；
        long l2 = 100L;

        float f1 = 1.0f;
        // float f2 = 1.0; // 浮点型默认是double类型，不能强制转换为float类型；赋值给f2；

        byte b1 = 1; // 1是int类型，强制转换为byte类型，赋值给b1；但不需要写强制转换代码
        byte b2 = 2;
        // byte b3 =  b1 + b2; // 报错，因为b1和b2是byte类型，运算结果是int类型，不能赋值给byte类型；
        int i3 =  b1 + b2;
        System.out.println(i3);

        char c1 = 'a';
        int i4 = c1;
        System.out.println(i4); // 输出97，因为a的ASCII码是97；
    }
}
