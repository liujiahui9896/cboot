package com.lz.ht.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.ht.dao.CostCostingMapper;
import com.lz.ht.model.CostCollection;
import com.lz.ht.model.CostCosting;
import com.lz.ht.model.CostProject;
import com.lz.ht.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CostingController {

    @Autowired
    private CostCostingMapper costCostingMapper;

    @RequestMapping(value = "/costing/list",method = {RequestMethod.GET})
    public String costing_list()throws Exception{
        return "costing/costing_list";
    }

    @RequestMapping(value = "/costing/list",method = {RequestMethod.POST})
    @ResponseBody
    public List<CostCosting> queryAllUser(){
        return costCostingMapper.findAll();
    }

    @RequestMapping(value = "/costing/queryAllUserByPage",method = {RequestMethod.POST})
    @ResponseBody
    //分页
    public PageInfo<CostCosting> queryAllUserByPage(CostCosting costCosting, int currentPageNum, int pageSize)throws Exception{
        //[pageNum, pageSize]  页码  每页显示数量
        PageHelper.startPage(currentPageNum,pageSize);
        PageInfo<CostCosting> pageInfo = new PageInfo<>(costCostingMapper.findAll());
        return pageInfo;
    }
    @RequestMapping(value = "/costing/queryByID",method = {RequestMethod.POST})
    @ResponseBody
    public PageInfo<CostCosting> queryByID(CostCosting costCosting, int currentPageNum, int pageSize)throws Exception {
        PageHelper.startPage(currentPageNum,pageSize);
        PageInfo<CostCosting> pageInfo = new PageInfo<>(costCostingMapper.findByID(costCosting.getCostingId()));
        return pageInfo;
    }
    //增加功能
    @RequestMapping(value = "/costing/add",method = {RequestMethod.GET})
    public String addInit(CostCosting costCosting, Model model){
        return "costing/costing_add";
    }

    @RequestMapping(value = "/costing/add",method = {RequestMethod.POST})
    @ResponseBody
    public Result add(CostCosting costCosting){
        costCostingMapper.insert(costCosting);
        return Result.genSuccessResult();
    }

    //删除功能
    @RequestMapping(value = "/costing/delete",method = {RequestMethod.POST})
    @ResponseBody
    public Result delete(CostCosting costCosting){
        //查询，此用户的角色，将此表t_user_role用户的角色一并删除
        costCostingMapper.deleteByPrimaryKey(costCosting.getCostingId());
        return Result.genSuccessResult();
    }

    //更新功能
    @RequestMapping(value = "/costing/update",method = {RequestMethod.GET})
    public String updateInit(CostCosting costCosting,Model model){
        costCosting = costCostingMapper.findById(costCosting.getCostingId());
        model.addAttribute("costCosting",costCosting);
        return "costing/costing_update";
    }
    @RequestMapping(value = "/costing/update",method = {RequestMethod.POST})
    @ResponseBody
    public Result update(CostCosting costCosting){
        costCostingMapper.updateByPrimaryKey(costCosting);
        return Result.genSuccessResult();}
}
