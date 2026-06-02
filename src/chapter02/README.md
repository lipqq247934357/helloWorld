# java基础

## 关键字

    就是有特殊含义的字符；比如class public；

## 标识符

    就是名字，类名，包名，方法名，变量名；

## 命名规范

    1.类，接口大写字母开头；
    2.包名使用小写单词组成，多单词也是小写；
    3.变量名，方法名使用驼峰命名法；
    4.常量名都大写，多个单词使用下划线连接

## 变量

    强类型语言，需要指定类型；
    基本数据类型：
        整型：byte \ short \ int \ long
        浮点型： float \ double
        字符型： char
        布尔类型： boolean
    引用数据类型：
        类（class）
        数组（array）
        接口（interface）
        枚举（enum）
        注解（annotation）
        记录（record）

### 整型
    byte \ short \ int \ long 分别占用： 1个 \ 2个 \ 4个 \ 8个 字节;
    1个子节等于 8个bit；每个bit代表一个0/1;
    byte: -128 ~ 127
    short: -2^15 ~ 2^15-1
    int: -2^31 ~ 2^31-1

### 浮点数

    float \ double 分别占用  4个 \ 8个 字节;

### 字符型

    char 占用 2个 字节;

### 布尔类型

    boolean true / false;
    在java里，不能使用1，-1，等表示true和false;

## 变量类型提升

    1
