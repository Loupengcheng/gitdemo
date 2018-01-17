package io.renren.common.Bruce;

import java.util.Date;

public class UserInfo {
    private int id;
    private String name;
    private int age;
    private Date createTime;
    private int createBy;
    private Date UpdateTime;
    private int updateBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        UpdateTime = updateTime;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                ", UpdateTime=" + UpdateTime +
                ", updateBy=" + updateBy +
                '}';
    }
}
