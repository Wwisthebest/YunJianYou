package com.groupthree.yunjianyou.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author LongGe
 * @title Collect
 * @cresion 1.0.0
 * @create 2024/5/23 17:12
 * @description
 */
@Table(name = "ss_collect")
public class Collect {
    @Id
    @Column(name = "f_id")
    private Integer fId;//收藏id
    @Column(name = "ss_name")//景点名称
    private String ssName;
    @Column(name = "ss_id")
    private Long ssId;//景点id
    @Column(name = "u_id")
    private Integer uId;//用户id
    @Column(name = "ss_price")
    private Double ssPrice;//价格
    @Column(name = "ss_address")
    private String ssAddress;//

    public Double getSsPrice() {
        return ssPrice;
    }

    public void setSsPrice(Double ssPrice) {
        this.ssPrice = ssPrice;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getSsName() {
        return ssName;
    }

    public void setSsName(String ssName) {
        this.ssName = ssName;
    }


    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Long getSsId() {
        return ssId;
    }

    public void setSsId(Long ssId) {
        this.ssId = ssId;
    }

    public String getSsAddress() {
        return ssAddress;
    }

    public void setSsAddress(String ssAddress) {
        this.ssAddress = ssAddress;
    }
}
