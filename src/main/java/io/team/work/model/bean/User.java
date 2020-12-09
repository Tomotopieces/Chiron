package io.team.work.model.bean;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 9:27
 * 描述:用户
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private Integer age;
    private String class_id;
    private Integer type;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public User setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getClass_id() {
        return class_id;
    }

    public User setClass_id(String class_id) {
        this.class_id = class_id;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public User setType(Integer type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", class_id='" + class_id + '\'' +
                ", type=" + type +
                '}';
    }
}
