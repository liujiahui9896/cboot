package com.lz.ht.dao;

import com.lz.ht.model.CostCollection;
import com.lz.ht.model.CostProject;

import java.util.List;

public interface CostCollectionMapper {
    int deleteByPrimaryKey(Integer regisId);

    int insert(CostCollection record);

    int insertSelective(CostCollection record);

    CostCollection selectByPrimaryKey(Integer regisId);

    int updateByPrimaryKeySelective(CostCollection record);

    int updateByPrimaryKey(CostCollection record);

    List<CostCollection> findAll();

    CostCollection findById(Integer collection);

    List<CostCollection> findByID(Integer regisId);

}