public class VariableTest {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(a);
        a = 20;
        System.out.println(a);
        final int i = 30;
        System.out.println(i);
        char c = 'a';
        System.out.println(c + " " + a);
        float f = 1.0f;
        System.out.println(f);
        double d = 1.0;
        System.out.println(d);
        byte b = 1;
        System.out.println(b);
        short s = 1;
        System.out.println(s);
        // 超出范围会报错
        // byte b22 = 128;
        long l1 = 10000000000L;
        long l2 = 10000000000l;
        // 整型类型，没有特殊情况，声明为int类型；

        float f1 = 1.0f;
        double d1 = 1.0;
        System.out.println(0.1 + 0.2);

        System.out.println(3.14 * 2.5 * 2.5);

        // boolean类型，true / false;
        boolean bo1 = true;
        // boolean bo2 = 1; // 报错，不能将int类型赋值给boolean类型
        System.out.println(bo1);

    }
}
