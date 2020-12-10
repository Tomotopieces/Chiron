package io.team.work.model.bean;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 9:48
 * 描述:学生作业
 */
public class StudentHomework {
    private Integer id;
    private Integer hw_id;
    private Integer s_id;
    private Boolean status;
    private String title;
    private String review_time;
    private String review_content;

    public StudentHomework() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHw_id() {
        return hw_id;
    }

    public void setHw_id(Integer hw_id) {
        this.hw_id = hw_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getReview_time() {
        return review_time;
    }

    public void setReview_time(String review_time) {
        this.review_time = review_time;
    }

    public String getReview_content() {
        return review_content;
    }

    public void setReview_content(String review_content) {
        this.review_content = review_content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "StudentHomework{" +
                "id=" + id +
                ", hw_id=" + hw_id +
                ", s_id=" + s_id +
                ", status=" + status +
                ", title='" + title + '\'' +
                ", review_time='" + review_time + '\'' +
                ", review_content='" + review_content + '\'' +
                '}';
    }
}
