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

    public Homework() {
    }

    public Integer getId() {
        return id;
    }

    public Homework setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public Homework setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Homework setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescribe() {
        return describe;
    }

    public Homework setDescribe(String describe) {
        this.describe = describe;
        return this;
    }

    public String getEnd_time() {
        return end_time;
    }

    public Homework setEnd_time(String end_time) {
        this.end_time = end_time;
        return this;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", teacher_id=" + teacher_id +
                ", title='" + title + '\'' +
                ", describe='" + describe + '\'' +
                ", end_time='" + end_time + '\'' +
                '}';
    }
}
