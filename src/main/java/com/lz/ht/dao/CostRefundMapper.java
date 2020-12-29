package com.lz.ht.dao;

import com.lz.ht.model.CostCollection;
import com.lz.ht.model.CostProject;
import com.lz.ht.model.CostRefund;

import java.util.List;

public interface CostRefundMapper {
    int deleteByPrimaryKey(Integer refundId);

    int insert(CostRefund record);

    int insertSelective(CostRefund record);

    CostRefund selectByPrimaryKey(Integer refundId);

    int updateByPrimaryKeySelective(CostRefund record);

    int updateByPrimaryKey(CostRefund record);

    List<CostRefund> findAll();

    CostRefund findById(Integer refund);

    List<CostRefund> findByID(Integer refundId);
}