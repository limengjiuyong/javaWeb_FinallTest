package com.example.demo.Dao;

import com.example.demo.Enity.DptInfo;
import com.example.demo.Enity.DptInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DptInfoMapper {
    long countByExample(DptInfoExample example);

    int deleteByExample(DptInfoExample example);

    int deleteByPrimaryKey(Integer dpid);

    int insert(DptInfo record);

    int insertSelective(DptInfo record);

    List<DptInfo> selectByExample(DptInfoExample example);

    DptInfo selectByPrimaryKey(Integer dpid);

    int updateByExampleSelective(@Param("record") DptInfo record, @Param("example") DptInfoExample example);

    int updateByExample(@Param("record") DptInfo record, @Param("example") DptInfoExample example);

    int updateByPrimaryKeySelective(DptInfo record);

    int updateByPrimaryKey(DptInfo record);
}