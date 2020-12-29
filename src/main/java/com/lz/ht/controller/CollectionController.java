package com.lz.ht.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.ht.dao.CostCollectionMapper;
import com.lz.ht.model.CostCollection;
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
public class CollectionController {
    @Autowired
    private CostCollectionMapper costCollectionMapper;
    @RequestMapping(value = "/collection/list",method = {RequestMethod.GET})
    public String collection_list()throws Exception{
        return "collection/collection_list";
    }
//    @RequestMapping(value = "/collection/list",method = {RequestMethod.POST})
//    @ResponseBody
//    public List<CostCollection> queryAllUser(){
//        return costCollectionMapper.findAll();
//    }
    @RequestMapping(value = "/collection/queryAllUserByPage",method = {RequestMethod.POST})
    @ResponseBody
    //分页
    public PageInfo<CostCollection> queryAllUserByPage(CostCollection costCollection, int currentPageNum, int pageSize)throws Exception{
        //[pageNum, pageSize]  页码  每页显示数量
        PageHelper.startPage(currentPageNum,pageSize);
        PageInfo<CostCollection> pageInfo = new PageInfo<>(costCollectionMapper.findAll());
        return pageInfo;
    }

    @RequestMapping(value = "/collection/queryByID",method = {RequestMethod.POST})
    @ResponseBody
    public PageInfo<CostCollection> queryByID(CostCollection costCollection, int currentPageNum, int pageSize)throws Exception {
        PageHelper.startPage(currentPageNum,pageSize);
        PageInfo<CostCollection> pageInfo = new PageInfo<>(costCollectionMapper.findByID(costCollection.getRegisId()));
        return pageInfo;
    }

    //增加功能
    @RequestMapping(value = "/collection/add",method = {RequestMethod.GET})
    public String addInit(CostCollection costCollection, Model model){

        return "collection/collection_add";
    }

    @RequestMapping(value = "/collection/add",method = {RequestMethod.POST})
    @ResponseBody
    public Result add(CostCollection costCollection){
        costCollectionMapper.insert(costCollection);
        return Result.genSuccessResult();
    }
    //删除功能
    @RequestMapping(value = "/collection/delete",method = {RequestMethod.POST})
    @ResponseBody
    public Result delete(CostCollection costCollection){
        //查询，此用户的角色，将此表t_user_role用户的角色一并删除
        costCollectionMapper.deleteByPrimaryKey(costCollection.getRegisId());
        return Result.genSuccessResult();
        }
    //更新功能
    @RequestMapping(value = "/collection/update",method = {RequestMethod.GET})
    public String updateInit(CostCollection costCollection, Model model){
        costCollection = costCollectionMapper.findById(costCollection.getRegisId());
        model.addAttribute("costCollection",costCollection);
        return "collection/collection_update";
        }
    @RequestMapping(value = "/collection/update",method = {RequestMethod.POST})
    @ResponseBody
    public Result update(CostCollection costCollection){
        costCollectionMapper.updateByPrimaryKey(costCollection);
        return Result.genSuccessResult();}

}
