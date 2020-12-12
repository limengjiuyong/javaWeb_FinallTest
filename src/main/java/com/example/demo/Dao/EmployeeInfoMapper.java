package com.example.demo.Dao;

import com.example.demo.Enity.EmployeeInfo;
import com.example.demo.Enity.EmployeeInfoExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeInfoMapper {
    long countByExample(EmployeeInfoExample example);

    int deleteByExample(EmployeeInfoExample example);

    int deleteByPrimaryKey(Integer eid);

    int insert(EmployeeInfo record);

    int insertSelective(EmployeeInfo record);
  //查询带部门
    List<EmployeeInfo> selectWithDptByExample(EmployeeInfoExample example);

    EmployeeInfo selectWithDptByPrimaryKey(Integer sid);

    //
    List<EmployeeInfo> selectByExample(EmployeeInfoExample example);

    EmployeeInfo selectByPrimaryKey(Integer eid);

    int updateByExampleSelective(@Param("record") EmployeeInfo record, @Param("example") EmployeeInfoExample example);

    int updateByExample(@Param("record") EmployeeInfo record, @Param("example") EmployeeInfoExample example);

    int updateByPrimaryKeySelective(EmployeeInfo record);

    int updateByPrimaryKey(EmployeeInfo record);
}