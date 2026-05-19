package com.groupthree.yunjianyou.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author He
 * @version 1.0.0
 * @title ScenicSpot
 * @create 2024/5/27 20:20
 * @description
 */


@Table(name="scenic_spots")
public class ScenicSpot {

    @Id
    @Column(name = "ss_id")
    private Long id;//景点ID
    @Column(name = "ss_name")
    private String spotName;//景点名称
    @Column(name = "ss_address")
    private String spotAddress;//景点地址
    @Column(name = "ss_info")
    private String spotInfo;//景点信息
    @Column(name = "ss_start_time")
    private String startTime;//景点开放时间
    @Column(name = "ss_end_time")
    private String endTime;//景点关闭时间
    @Column(name = "ss_price")
    private String ticketPrice;//景点票价
    @Column(name = "ss_img")
    private String spotImgUrl;//景点图片
    @Column(name = "ss_state")
    private String soptState;//景点状态
    @Column(name = "ss_ticket_num")
    private Integer ticketNum;//景点门票数量
    @Column(name = "ss_map")
    private String mapInfo;//景点添加百度地图

    public ScenicSpot() {
    }

    public ScenicSpot(Long id, String spotName, String spotAddress, String spotInfo, String startTime, String endTime,
                      String ticketPrice, String spotImgUrl,String soptState, Integer ticketNum, String mapInfo) {
        this.id = id;
        this.spotName = spotName;
        this.spotAddress = spotAddress;
        this.spotInfo = spotInfo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ticketPrice = ticketPrice;
        this.spotImgUrl = spotImgUrl;
        this.soptState = soptState;
        this.ticketNum = ticketNum;
        this.mapInfo = mapInfo;
    }

    public String getMapInfo() {
        return mapInfo;
    }

    public void setMapInfo(String mapInfo) {
        this.mapInfo = mapInfo;
    }

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getSoptState() {
        return soptState;
    }

    public void setSoptState(String soptState) {
        this.soptState = soptState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getSpotAddress() {
        return spotAddress;
    }

    public void setSpotAddress(String spotAddress) {
        this.spotAddress = spotAddress;
    }

    public String getSpotInfo() {
        return spotInfo;
    }

    public void setSpotInfo(String spotInfo) {
        this.spotInfo = spotInfo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getSpotImgUrl() {
        return spotImgUrl;
    }

    public void setSpotImgUrl(String spotImgUrl) {
        this.spotImgUrl = spotImgUrl;
    }
}
