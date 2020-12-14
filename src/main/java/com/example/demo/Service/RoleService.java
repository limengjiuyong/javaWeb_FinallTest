package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.RoleInfosMapper;
import com.example.demo.Enity.RoleInfos;



@Service
public class RoleService {

	@Autowired
	RoleInfosMapper roleInfosMapper;
	public List<RoleInfos> findAllRoles() {
		return roleInfosMapper.selectByExample(null);
	}
	
	 
	 
}
