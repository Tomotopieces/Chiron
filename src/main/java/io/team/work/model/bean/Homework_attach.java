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

    public Homework_attach setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getHw_id() {
        return hw_id;
    }

    public Homework_attach setHw_id(Integer hw_id) {
        this.hw_id = hw_id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Homework_attach setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getType() {
        return type;
    }

    public Homework_attach setType(String type) {
        this.type = type;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Homework_attach setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getCreate_time() {
        return create_time;
    }

    public Homework_attach setCreate_time(String create_time) {
        this.create_time = create_time;
        return this;
    }

    public String getCreate_man() {
        return create_man;
    }

    public Homework_attach setCreate_man(String create_man) {
        this.create_man = create_man;
        return this;
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
