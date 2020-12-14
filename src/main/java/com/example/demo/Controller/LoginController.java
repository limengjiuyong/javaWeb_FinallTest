package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Enity.AdminInfo;
import com.example.demo.Enity.Msg;
import com.example.demo.Service.AdminInfoService;
import com.example.demo.Service.RoleService;

@Controller
public class LoginController {

	@Autowired
	RoleService roleService;
	@Autowired
	AdminInfoService admininfoservice;
	@RequestMapping("/base/login")
	public String Login() {
		return "login";
	}
	@RequestMapping("/base/findRole")
	@ResponseBody
	public Msg findAllRole() {
		
		return Msg.success().add("Roles", roleService.findAllRoles());
	}
	
	@RequestMapping("/base/register")
	public String Register() {
		return "register1";
	}
	
	@RequestMapping("/base/insertAdm")
	@ResponseBody
	public Msg Register1(AdminInfo adminInfo) {
		adminInfo.setEnable(true);
		adminInfo.setLocked(false);
		admininfoservice.InsetAdminByExample(adminInfo);
		admininfoservice.InsertAdmRoleByExample(adminInfo.getAid(),adminInfo.getRid());
		return Msg.success();
	}
	
	@RequestMapping("/admin/adminfo")
	public String AdmInfo() {
		return "AdmInfo";
	}
	@RequestMapping(value="/admin/update",method = RequestMethod.POST)
	@ResponseBody
	public Msg Update(AdminInfo adminInfo) {
		
		admininfoservice.updateByExample(adminInfo);
		return Msg.success();
	}
}
