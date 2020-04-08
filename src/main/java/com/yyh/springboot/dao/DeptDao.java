package com.yyh.springboot.dao;

import com.yyh.springboot.po.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 接口
 * @author YanYuHang
 * @create 2020-04-06-11:21
 */
@Mapper
public interface DeptDao {
    /**
     * 查询全部
     * @return
     */
    @Select("select * from Dept")
    List<Dept> selectAll();


    @Select("select * from Dept where dept_id=#{dept_id}")
    Dept selectById(int dept_id);

    @Insert("insert into Dept(dept_name) values(#{dept_name})")
    int insert(Dept dept);

    @Delete("delete from Dept where dept_id=#{dept_id} ")
    int delete(int dept_id);

    @Update("update Dept set dept_name=#{dept_name}  where dept_id=#{dept_id}")
    int update(Dept dept);


}
