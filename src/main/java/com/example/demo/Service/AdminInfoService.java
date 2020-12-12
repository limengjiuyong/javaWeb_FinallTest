package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.support.odps.udf.CodecCheck.A;
import com.example.demo.Dao.AdminInfoMapper;
import com.example.demo.Enity.AdminInfo;

@Service
public class AdminInfoService implements UserDetailsService {

	@Autowired
	AdminInfoMapper admininfomapper;
	@Override
	public UserDetails loadUserByUsername(String aname) throws UsernameNotFoundException {
		AdminInfo adinfo=admininfomapper.loadAdminInfoByName(aname);
		if (adinfo ==null) {
			throw new UsernameNotFoundException("账户不存在！");		 
		}
		adinfo.setRoles(admininfomapper.getAdminInfoRolesById(adinfo.getAid()));
		return adinfo;
	}

}
