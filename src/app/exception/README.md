# 异常

## 异常的概述

    异常是程序在执行过程中，由于某些原因导致程序无法正常执行，而抛出的一种对象。
    异常也是以类的形式表示，然后通过 throw 关键字抛出异常对象，因此可以像对象一样进行处理。

## 常见异常

    java.lang.Throwable 类是所有异常的超类。
        java.lang.Error 类是错误的超类
            一般错误，无法通过代码解决，例如 StackOverflowError，OutOfMemoryError
        java.lang.Exception 类是异常的超类，我们可以编写代码进行处理
            编译时异常
                例如 IOException，需要通过 try...catch... 或 throws 进行处理
            运行时异常 RuntimeException
                例如 NullPointerException，ArrayIndexOutOfBoundsException

## 异常的处理方式

    try...catch... finally 捕获异常
    throws 声明异常
    throw 手动抛出异常


## 手动抛出异常

    使用 throw 关键字可以主动抛出一个异常对象。
    通常用于业务逻辑校验、参数检查等场景。

    示例：
        if (age < 18) {
            throw new IllegalArgumentException("年龄未满 18 岁");
        }

## 如何自定义异常

    自定义异常通常继承 Exception 或 RuntimeException：
        1. 继承 Exception：编译时异常，调用方必须处理
        2. 继承 RuntimeException：运行时异常，调用方可选处理

    步骤：
        1. 创建一个类继承 Exception 或 RuntimeException
        2. 提供构造方法（通常包含无参、带消息、带消息和 cause 的构造方法）
        3. 可选：添加额外的业务字段，例如错误码

    示例：
        public class BusinessException extends RuntimeException {
            private String errorCode;

            public BusinessException(String errorCode, String message) {
                super(message);
                this.errorCode = errorCode;
            }
        }

## 异常传播与堆栈跟踪

    异常会从发生位置沿着方法调用链向上传播，直到被捕获或导致程序终止。
    使用 e.printStackTrace() 可以打印完整的调用栈，便于定位问题。

## try-with-resources

    Java 7 引入的语法，用于自动关闭实现了 AutoCloseable 接口的资源。
    即使 try 块中发生异常，资源也会在结束时自动关闭。

    示例：
        try (InputStream in = new FileInputStream("file.txt")) {
            // 读取操作
        } catch (IOException e) {
            e.printStackTrace();
        }

## throws和throw的区别

    throws 声明异常，表示调用方需要处理该异常
    throw 手动抛出异常，表示当前方法不处理该异常

## 本目录 demo 文件说明

| 文件名 | 说明 |
| --- | --- |
| ExceptionTest1.java | try...catch...finally 基础用法 |
| ExceptionRuntimeDemo.java | 常见运行时异常（NPE、数组越界、数字格式、类型转换、算术异常） |
| ExceptionCheckedDemo.java | 编译时异常与 throws 声明、多异常捕获 |
| ExceptionThrowDemo.java | throw 手动抛出异常与参数校验 |
| BusinessException.java | 自定义运行时业务异常 |
| ValidateException.java | 自定义编译时校验异常 |
| ExceptionCustomDemo.java | 自定义异常的使用 |
| ExceptionPropagationDemo.java | 异常传播与堆栈跟踪 |
| ExceptionTryWithResourcesDemo.java | try-with-resources 自动关闭资源 |
