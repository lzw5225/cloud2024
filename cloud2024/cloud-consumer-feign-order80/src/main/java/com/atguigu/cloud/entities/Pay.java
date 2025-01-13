package com.atguigu.cloud.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_pay")
@Schema(title="订单表")
public class Pay {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "pay_no")
    @Schema(title = "订单编号")
    private String payNo;

    @Column(name = "order_no")
    @Schema(title = "购买单号")
    private String orderNo;

    @Column(name = "user_id")
    @Schema(title = "用户编号")
    private Integer userId;

    @Schema(title = "金额")
    private BigDecimal amount;

    private Byte deleted;

    @Column(name = "create_time")
    @Schema(title = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @Column(name = "update_time")
    @Schema(title = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return payNo
     */
    public String getPayNo() {
        return payNo;
    }

    /**
     * @param payNo
     */
    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    /**
     * @return orderNo
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return deleted
     */
    public Byte getDeleted() {
        return deleted;
    }

    /**
     * @param deleted
     */
    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    /**
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
                  return "Pay{" +
                    "id=" + id +
                    ", payNo='" + payNo + '\'' +
                    ", orderNo='" + orderNo + '\'' +
                    ", userId=" + userId +
                    ", amount=" + amount +
                    ", deleted=" + deleted +
                    ", createTime=" + createTime.toLocaleString() +
                    ", updateTime=" + updateTime.toLocaleString() +
                    '}';
        }
    }

