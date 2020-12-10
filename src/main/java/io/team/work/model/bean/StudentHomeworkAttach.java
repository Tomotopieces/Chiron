package io.team.work.model.bean;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 9:52
 * 描述:学生作业附件
 */
public class StudentHomeworkAttach {
    private Integer id;
    private Integer stu_hw_id;
    private String title;
    private String type;
    private String url;

    public StudentHomeworkAttach() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStu_hw_id() {
        return stu_hw_id;
    }

    public void setStu_hw_id(Integer stu_hw_id) {
        this.stu_hw_id = stu_hw_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "StudentHomeworkAttach{" +
                "id=" + id +
                ", stu_hw_id=" + stu_hw_id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
