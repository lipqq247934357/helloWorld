/**
 * 强制类型转换
 * 
 * 如果需要将容量大的类型强制转换为容量小的类型，需要使用强制类型转换符；
 * 
 * 格式：
 * (目标类型) 变量名;
 * 
 * 注意：
 * 1.强制类型转换可能会导致精度丢失；
 * 2.强制类型转换可能会导致数据溢出；
 * 3.强制类型转换可能会导致数据丢失；
 * 
 */

public class VariableTranster2 {
    public static void main(String[] args) {
        double d = 1234567890.1234567890;
        int i = (int) d;
        System.out.println(i);

        int i2 = 128;
        byte b = (byte) i2;
        System.out.println(b);
    }
}
