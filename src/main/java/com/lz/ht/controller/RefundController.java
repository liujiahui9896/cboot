package com.lz.ht.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.ht.dao.CostRefundMapper;
import com.lz.ht.model.CostCollection;
import com.lz.ht.model.CostProject;
import com.lz.ht.model.CostRefund;
import com.lz.ht.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RefundController {

    @Autowired
    private CostRefundMapper costRefundMapper;

    @RequestMapping(value = "/refund/list",method = {RequestMethod.GET})
    public String refund_list()throws Exception{
        return "refund/refund_list";
    }

//    @RequestMapping(value = "/refund/list",method = {RequestMethod.POST})
//    @ResponseBody
//    public List<CostRefund> queryAllUser(){
//
//        return costRefundMapper.findAll();
//    }

    @RequestMapping(value = "/refund/queryAllUserByPage",method = {RequestMethod.POST})
    @ResponseBody
    //分页
    public PageInfo<CostRefund> queryAllUserByPage(CostRefund costRefund, int currentPageNum, int pageSize)throws Exception{
        //[pageNum, pageSize]  页码  每页显示数量
        PageHelper.startPage(currentPageNum,pageSize);
        PageInfo<CostRefund> pageInfo = new PageInfo<>(costRefundMapper.findAll());
        return pageInfo;
    }

    @RequestMapping(value = "/refund/queryByID",method = {RequestMethod.POST})
    @ResponseBody
    public PageInfo<CostRefund> queryByID(CostRefund costRefund, int currentPageNum, int pageSize)throws Exception {
        PageHelper.startPage(currentPageNum,pageSize);
        PageInfo<CostRefund> pageInfo = new PageInfo<>(costRefundMapper.findByID(costRefund.getRefundId()));
        return pageInfo;
    }

    //增加功能
    @RequestMapping(value = "/refund/add",method = {RequestMethod.GET})
    public String addInit(CostRefund costRefund, Model model){
        return "refund/refund_add";
    }

    @RequestMapping(value = "/refund/add",method = {RequestMethod.POST})
    @ResponseBody
    public Result add(CostRefund costRefund){
        costRefundMapper.insert(costRefund);
        return Result.genSuccessResult();
    }

    //删除功能
    @RequestMapping(value = "/refund/delete",method = {RequestMethod.POST})
    @ResponseBody
    public Result delete(CostRefund costRefund){
        //查询，此用户的角色，将此表t_user_role用户的角色一并删除
        costRefundMapper.deleteByPrimaryKey(costRefund.getRefundId());
        return Result.genSuccessResult();
    }

    //更新功能
    @RequestMapping(value = "/refund/update",method = {RequestMethod.GET})
    public String updateInit(CostRefund costRefund,Model model){
        costRefund = costRefundMapper.findById(costRefund.getRefundId());
        model.addAttribute("costRefund",costRefund);
        return "refund/refund_update";
    }
    @RequestMapping(value = "/refund/update",method = {RequestMethod.POST})
    @ResponseBody
    public Result update(CostRefund costRefund){
        costRefundMapper.updateByPrimaryKey(costRefund);
        return Result.genSuccessResult();}
}
