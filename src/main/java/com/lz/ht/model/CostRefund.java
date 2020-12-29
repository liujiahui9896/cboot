package com.lz.ht.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * cost_refund
 * @author 
 */
@Data
public class CostRefund implements Serializable {
    private Integer refundId;

    private Date refundDate;

    private BigDecimal refundAmount;

    private String refundUserName;

    private Integer projectId;

    private Integer userId;

    private static final long serialVersionUID = 1L;
    public void setRefundId(Integer refundId){
        this.refundId = refundId;
    }
    public Integer getRefundId() {
        return this.refundId;
    }
}