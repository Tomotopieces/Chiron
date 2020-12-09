package io.team.work.model.bean;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 9:43
 * 描述:作业附件
 */
public class Homework_attach {
    private Integer id;
    private Integer hw_id;
    private String title;
    private String type;
    private String url;
    private String create_time;
    private String create_man;

    public Homework_attach() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getCreate_man() {
        return create_man;
    }

    public void setCreate_man(String create_man) {
        this.create_man = create_man;
    }

    @Override
    public String toString() {
        return "Homework_attach{" +
                "id=" + id +
                ", hw_id=" + hw_id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", create_time='" + create_time + '\'' +
                ", create_man='" + create_man + '\'' +
                '}';
    }
}
