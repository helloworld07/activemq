package com.zcy.model;

/**
 * Created by zcy on 2018/6/19.
 */
public class Person {
    private String name;
    private String sex;
    private int age;
    public Person() {
        super();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", sex=" + sex + ", age=" + age + "]";
    }
}
