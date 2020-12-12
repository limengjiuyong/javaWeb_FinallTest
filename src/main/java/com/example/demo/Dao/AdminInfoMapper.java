package com.example.demo.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Enity.AdminInfo;
import com.example.demo.Enity.Role;


@Mapper
public interface AdminInfoMapper {

	 AdminInfo loadAdminInfoByName(String aname); 
	 List<Role> getAdminInfoRolesById(Integer userid);
}
