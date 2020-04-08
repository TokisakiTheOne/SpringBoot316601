package com.yyh.springboot.handler;

import com.yyh.springboot.dao.DeptDao;
import com.yyh.springboot.po.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 控制器
 * @author YanYuHang
 * @create 2020-04-06-11:03
 */
@Controller
public class TestHandler {

   @RequestMapping("/testSpringBoot")
   @ResponseBody
    public String testSpringBoot(){
       return "测试SpringBoot！";
   }


   @Autowired
   private DeptDao deptDao;

   @GetMapping("/selectAllDept")
   @ResponseBody
    public Object selectAllDept(){
       List<Dept> depts = deptDao.selectAll();
       return depts;
   }
    @GetMapping("/selectByIdDept")
    @ResponseBody
    public Object selectByIdDept(){
        return deptDao.selectById(19);
    }
    @GetMapping("/insert")
    @ResponseBody
    public Object insert(){
        Dept dept = new Dept();
        dept.setDept_name("20200406");
        return deptDao.insert(dept)>0?"添加成功":"添加失败";
    }
    @GetMapping("/delete")
    @ResponseBody
    public Object delete(){
        return deptDao.delete(19)>0?"删除成功":"删除失败";
    }
    @GetMapping("/update")
    @ResponseBody
    public Object update(){
        Dept dept = new Dept();
        dept.setDept_id(22);
        dept.setDept_name("修改之后的结果");
        return deptDao.update(dept)>0?"修改成功":"修改失败";
    }

}
