package io.team.work.model.bean;


/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 9:35
 * 描述:作业
 */
public class Homework {
    private Integer id;
    private Integer teacher_id;
    private String title;
    private String describe;
    private String end_time;
    private Integer class_id;
    private String attach_title;
    private String attach_url;

    public Homework() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getAttach_title() {
        return attach_title;
    }

    public void setAttach_title(String attach_title) {
        this.attach_title = attach_title;
    }

    public String getAttach_url() {
        return attach_url;
    }

    public void setAttach_url(String attach_url) {
        this.attach_url = attach_url;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", teacher_id=" + teacher_id +
                ", title='" + title + '\'' +
                ", describe='" + describe + '\'' +
                ", end_time='" + end_time + '\'' +
                ", class_id=" + class_id +
                ", attach_title='" + attach_title + '\'' +
                ", attach_url='" + attach_url + '\'' +
                '}';
    }
}
