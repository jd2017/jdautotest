package com.itheima.pojo;

public class Brand {

    // id 主键
    private Integer id;
    // 品牌名称
    private String  brandName;
    // 企业名称
    private String companyName;
    // 排序字段
    private String ordered;
    // 描述信息
    private String description;
    // 状态：0：禁用，1：启用
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrdered() {
        return ordered;
    }

    public void setOrdered(String ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brand_name='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered='" + ordered + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
