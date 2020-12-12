package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.DptInfoMapper;
import com.example.demo.Enity.DptInfo;
import com.example.demo.Enity.DptInfoExample;
@Service
public class DptInfoService {

	@Autowired
	DptInfoMapper dptInfoMapper;
	public List<DptInfo> getAllDptinfo() {
		List<DptInfo> infos= dptInfoMapper.selectByExample(null);
		return infos;
	} 
}
