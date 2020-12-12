package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Enity.AdminInfo;
import com.example.demo.Enity.EmployeeInfo;
import com.example.demo.Enity.Msg;
import com.example.demo.Service.DptInfoService;
import com.example.demo.Service.EmployeeService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeservice;
	@Autowired
	DptInfoService dptInfoService;
	/**
	 * responsebody类型传参，分会自动封装的json数据
	 * @param pages
	 * @return
	 */
	@RequestMapping(value="/admin/empsWithMsg")
	@ResponseBody     //将函数的返回类型直接分装成为json数据类型然后返回给前端
	public Msg getAllEmpwithMsg(@RequestParam(value = "pages",defaultValue = "1") int pages) {
		//传入的页码以及每页的大小
		
				PageHelper.startPage(pages, 5);
				//排序规则;"desc"降序，"asc"升序，String orderBy="字段名 排序规律"
				//PageHelper.orderBy(orderBy);
				
				PageHelper.orderBy("eid asc");
				List<EmployeeInfo> emp=employeeservice.getAll();
				//使用pageinfo包装查询出来的stus集合，返回页面那是只需将pageinfo传给页面即可
				//连续传入的页数，方便后面的查询条
				PageInfo<EmployeeInfo> page=new PageInfo<EmployeeInfo>(emp, 5);
				return Msg.success().add("empInfo", page);
	}
	@RequestMapping("/admin/empinfo")
	public String info()
	{
		
		return "EmpInfo1";
	}
	
	@RequestMapping(value="/admin/insertEmp",method =RequestMethod.POST)
	@ResponseBody
	public Msg insertEmp(EmployeeInfo employeeinfo) {
		
		employeeservice.insertEmp(employeeinfo);
		return Msg.success();
		
	}
	@RequestMapping(value="/admin/deleteEmp")
	@ResponseBody
	public Msg deleteEmp(@RequestParam Integer eid) {
		
		employeeservice.deleteEmp(eid);
		return Msg.success();
		
	}
	
	@RequestMapping(value="/admin/updateEmp",method =RequestMethod.POST)
	@ResponseBody
	public Msg updateEmp(EmployeeInfo employeeinfo) {
		
		employeeservice.updateEmp(employeeinfo);
		return Msg.success();
		
	}
	@RequestMapping(value="/admin/dptInfo")
	@ResponseBody
	public Msg DptInfo() {
		
		//employeeservice.insertEmp(employeeinfo);
		return Msg.success().add("dptInfo", dptInfoService.getAllDptinfo());
		
	}
}
