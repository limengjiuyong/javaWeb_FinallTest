package com.example.demo.Dao;

import com.example.demo.Enity.RoleInfos;
import com.example.demo.Enity.RoleInfosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleInfosMapper {
    long countByExample(RoleInfosExample example);

    int deleteByExample(RoleInfosExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(RoleInfos record);

    int insertSelective(RoleInfos record);

    List<RoleInfos> selectByExample(RoleInfosExample example);

    RoleInfos selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") RoleInfos record, @Param("example") RoleInfosExample example);

    int updateByExample(@Param("record") RoleInfos record, @Param("example") RoleInfosExample example);

    int updateByPrimaryKeySelective(RoleInfos record);

    int updateByPrimaryKey(RoleInfos record);
}