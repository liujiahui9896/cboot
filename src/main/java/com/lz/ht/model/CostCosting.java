package com.lz.ht.model;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * cost_costing
 * @author 
 */
@Data
public class CostCosting implements Serializable {
    private Integer costingId;

    private String costingProject;

    private String costingChildProject;

    private BigDecimal costingUnitprice;

    private String costingAmount;

    private String costingMoney;

    private String costingWorkmatter;

    private static final long serialVersionUID = 1L;
    public void setCostingId(Integer costingId){
        this.costingId = costingId;
    }
    public Integer getCostingId() {
        return this.costingId;
    }
}