package com.lz.ht.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.ht.dao.CostProjectMapper;
import com.lz.ht.model.CostProject;
import com.lz.ht.model.User;
import com.lz.ht.page.PageModel;
import com.lz.ht.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private CostProjectMapper costProjectMapper;

    @RequestMapping(value = "/project/list",method = {RequestMethod.GET})
    public String project_list()throws Exception{
        return "project/project_list";
    }

//    @RequestMapping(value = "/project/list",method = {RequestMethod.POST})
//    @ResponseBody
//    public List<CostProject> queryAllUser(){
//        return costProjectMapper.findAll();
//    }
    @RequestMapping(value = "/project/queryAllUserByPage",method = {RequestMethod.POST})
    @ResponseBody
    //分页
    public PageInfo<CostProject> queryAllUserByPage(CostProject costProject, int currentPageNum, int pageSize)throws Exception{
        //[pageNum, pageSize]  页码  每页显示数量
        PageHelper.startPage(currentPageNum,pageSize);
        PageInfo<CostProject> pageInfo = new PageInfo<>(costProjectMapper.findAll());
        return pageInfo;
    }

    @RequestMapping(value = "/project/queryByName",method = {RequestMethod.POST})
    @ResponseBody
    public PageInfo<CostProject> queryByName(CostProject costProject, int currentPageNum, int pageSize)throws Exception {
        PageHelper.startPage(currentPageNum,pageSize);
        PageInfo<CostProject> pageInfo = new PageInfo<>(costProjectMapper.findByName(costProject.getProjectName()));
        return pageInfo;
    }
    //增加功能
    @RequestMapping(value = "/project/add",method = {RequestMethod.GET})
    public String addInit(CostProject costProject, Model model){
        return "project/project_add";
    }

    @RequestMapping(value = "/project/add",method = {RequestMethod.POST})
    @ResponseBody
    public Result add(CostProject costProject){
        costProjectMapper.insert(costProject);
        return Result.genSuccessResult();
    }
    //删除功能
    @RequestMapping(value = "/project/delete",method = {RequestMethod.POST})
    @ResponseBody
    public Result delete(CostProject costProject){
        //查询，此用户的角色，将此表t_user_role用户的角色一并删除
        costProjectMapper.deleteByPrimaryKey(costProject.getProjectId());
        return Result.genSuccessResult();
    }
    //更新功能
    @RequestMapping(value = "/project/update",method = {RequestMethod.GET})
    public String updateInit(CostProject costProject,Model model){
        costProject = costProjectMapper.findById(costProject.getProjectId());
        model.addAttribute("costProject",costProject);
        return "project/project_update";
    }
    @RequestMapping(value = "/project/update",method = {RequestMethod.POST})
    @ResponseBody
    public Result update(CostProject costProject){
        costProjectMapper.updateByPrimaryKey(costProject);
        return Result.genSuccessResult();}

}
