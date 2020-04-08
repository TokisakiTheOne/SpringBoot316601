package com.yyh.springboot.handler;

import com.yyh.springboot.dao.DeptDao;
import com.yyh.springboot.po.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YanYuHang
 * @create 2020-04-08-10:35
 */
@Controller
@RequestMapping("/html")
public class HtmlHandler {
    @Autowired
    private DeptDao deptDao;

    /**
     * 查詢全部
     * @param model
     * @return
     */
    @GetMapping("/selectAll")
    public String selectAll(Model model){
    //执行查询全部获得数据
    List<Dept> depts = deptDao.selectAll();
    //把数据放入作用域中
    model.addAttribute("depts",depts);
    return "selectall";
    }

    /**
     * 刪除
     * @param dept_id
     * @return
     */
    @GetMapping("/delete/{dept_id}/*")
    public String delete(@PathVariable int dept_id){
        deptDao.delete(dept_id);
        return "redirect:/html/selectAll";
    }


    @GetMapping("/findById/{dept_id}/*")
    public String findById(@PathVariable int dept_id,Model model){
        Dept dept = deptDao.selectById(dept_id);
        model.addAttribute("dept",dept);
        return "update";
    }

    @PostMapping("/update")
    public String update(Dept dept){
        deptDao.update(dept);
        return "redirect:/html/selectAll";
    }

    @GetMapping("/toInsert")
    public String toInsert(){
        return "insert";
    }


    @PostMapping("/insert")
    public String insert(Dept dept){
        deptDao.insert(dept);
        return "redirect:/html/selectAll";
    }





}
