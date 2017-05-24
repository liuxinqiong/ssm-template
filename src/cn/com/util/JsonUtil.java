package cn.com.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class JsonUtil {
	
	public static void output(HttpServletResponse response,Result rtn){
		try {
			PrintWriter out = response.getWriter();
			JSONObject json = JSONObject.fromObject(rtn);
			response.setContentType("application/json;charset=UTF-8");
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void output(HttpServletResponse response,String json){
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("application/json;charset=UTF-8");
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
