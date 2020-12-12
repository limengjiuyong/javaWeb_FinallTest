package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.EmployeeInfoMapper;
import com.example.demo.Enity.EmployeeInfo;


@Service
public class EmployeeService {


	@Autowired
	EmployeeInfoMapper employeeInfoMapper;
	public List<EmployeeInfo> getAll() {
		// TODO Auto-generated method stub
		
		List<EmployeeInfo> stusInfos=employeeInfoMapper.selectWithDptByExample(null);
		return stusInfos;
	}
	
	public void insertEmp(EmployeeInfo employeeinfo) {
		
		employeeInfoMapper.insertSelective(employeeinfo);		
	}
	
	public void deleteEmp(int sid) {
		
		employeeInfoMapper.deleteByPrimaryKey(sid);	
	}
	
	public void updateEmp(EmployeeInfo employeeinfo) {
		employeeInfoMapper.updateByPrimaryKeySelective(employeeinfo);
		
	}
	public int insertSelective(EmployeeInfo record) {
	return	employeeInfoMapper.insertSelective(record);
		
	}
	
	public int  deleteEmp(Integer eid) {
		return employeeInfoMapper.deleteByPrimaryKey(eid);
	}
}
