package com.example.demo.Enity;

import java.util.HashMap;
import java.util.Map;



public class Msg {

	/**
	 * 
	 * 用于封装成json类型数据返回给前台
	 * @author acer
	 *
	 */

		//状态码
		private int code;
		//执行信息
		private String msg;
		
		//放回数据主体；
		private Map<String,Object> extend =new HashMap<String, Object>();
		
		
		public static Msg success() {
			Msg msg=new Msg();
			msg.setCode(100);
			msg.setMsg("处理成功");
			return msg;
		}
		public static Msg fial() {
			Msg msg=new Msg();
			msg.setCode(200);
			msg.setMsg("处理失败");
			return msg;
		}
		//获取pageinfo中的返回数据list
		public Msg add(String key,Object value)
		{
			this.getExtend().put(key, value);
			return this;
		}
		
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public Map<String, Object> getExtend() {
			return extend;
		}
		public void setExtend(Map<String, Object> extend) {
			this.extend = extend;
		}

	}

