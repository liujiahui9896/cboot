package com.lz.ht.dao;

import com.lz.ht.model.CostCollection;
import com.lz.ht.model.CostProject;

import java.util.List;

public interface CostProjectMapper {
    int deleteByPrimaryKey(Integer projectId);

    int insert(CostProject record);

    int insertSelective(CostProject record);

    CostProject selectByPrimaryKey(Integer projectId);

    int updateByPrimaryKeySelective(CostProject record);

    int updateByPrimaryKey(CostProject record);

    List<CostProject> findAll();

    CostProject findById(Integer project);

    List<CostProject> findByName(String projectName);
}