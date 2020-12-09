package io.team.work.model.bean;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 9:38
 * 描述:公告
 */
public class Notice {
    private Integer id;
    private String title;
    private String content;
    private String create_time;

    public Notice() {
    }

    public Integer getId() {
        return id;
    }

    public Notice setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Notice setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Notice setContent(String content) {
        this.content = content;
        return this;
    }

    public String getCreate_time() {
        return create_time;
    }

    public Notice setCreate_time(String create_time) {
        this.create_time = create_time;
        return this;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
