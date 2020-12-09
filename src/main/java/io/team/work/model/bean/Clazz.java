package io.team.work.model.bean;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 9:32
 * 描述:班级
 */
public class Clazz {
    private Integer id;
    private String classNo;
    private String className;

    public Clazz() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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
