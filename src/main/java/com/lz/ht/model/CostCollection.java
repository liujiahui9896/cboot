package com.lz.ht.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * cost_collection
 * @author 
 */
@Data
public class CostCollection implements Serializable {
    private Integer regisId;

    private Date collectionDate;

    private String collectionMethod;

    private String collectionSummary;

    private Integer collectionAmount;

    private String billFlag;

    private Integer projectId;

    private static final long serialVersionUID = 1L;
    public void setRegisId(Integer regisId){
        this.regisId = regisId;
    }
    public Integer getRegisId() {
        return this.regisId;
    }
}