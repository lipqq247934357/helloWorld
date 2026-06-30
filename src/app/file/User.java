package app.file;

import java.io.Serializable;

/**
 * 用于对象序列化演示的实体类
 *
 * 实现 Serializable 接口表示该类的对象可以被序列化到流中。
 * serialVersionUID 用于版本控制，建议显式声明。
 * transient 修饰的字段不会被序列化。
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private transient int age; // age 不会被序列化

    public User(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}
