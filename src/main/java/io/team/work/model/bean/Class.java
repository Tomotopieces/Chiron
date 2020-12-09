package io.team.work.model.bean;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 9:32
 * 描述:班级
 */
public class Class {
    private Integer id;
    private String classNo;
    private String className;

    public Class() {
    }

    public Integer getId() {
        return id;
    }

    public Class setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getClassNo() {
        return classNo;
    }

    public Class setClassNo(String classNo) {
        this.classNo = classNo;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public Class setClassName(String className) {
        this.className = className;
        return this;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", classNo='" + classNo + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
