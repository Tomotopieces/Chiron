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
    private String attachment_title;
    private String attachment_url;

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

    public String getAttachment_title() {
        return attachment_title;
    }

    public void setAttachment_title(String attachment_title) {
        this.attachment_title = attachment_title;
    }

    public String getAttachment_url() {
        return attachment_url;
    }

    public void setAttachment_url(String attachment_url) {
        this.attachment_url = attachment_url;
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
                ", attachment_title='" + attachment_title + '\'' +
                ", attachment_url='" + attachment_url + '\'' +
                '}';
    }
}
