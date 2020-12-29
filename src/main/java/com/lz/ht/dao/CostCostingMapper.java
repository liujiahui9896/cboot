package com.lz.ht.dao;

import com.lz.ht.model.CostCollection;
import com.lz.ht.model.CostCosting;

import java.util.List;

public interface CostCostingMapper {
    int deleteByPrimaryKey(Integer costingId);

    int insert(CostCosting record);

    int insertSelective(CostCosting record);

    CostCosting selectByPrimaryKey(Integer costingId);

    int updateByPrimaryKeySelective(CostCosting record);

    int updateByPrimaryKey(CostCosting record);

    List<CostCosting> findAll();

    CostCosting findById(Integer costing);

    List<CostCosting> findByID(Integer costingId);

}