package io.team.work.model.bean;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 9:52
 * 描述:学生作业附件
 */
public class StuHwAttach {
    private Integer id;
    private Integer stu_hw_id;
    private String type;
    private String url;

    public StuHwAttach() {
    }

    public Integer getId() {
        return id;
    }

    public StuHwAttach setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getStu_hw_id() {
        return stu_hw_id;
    }

    public StuHwAttach setStu_hw_id(Integer stu_hw_id) {
        this.stu_hw_id = stu_hw_id;
        return this;
    }

    public String getType() {
        return type;
    }

    public StuHwAttach setType(String type) {
        this.type = type;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public StuHwAttach setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        return "StuHwAttach{" +
                "id=" + id +
                ", stu_hw_id=" + stu_hw_id +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
