package cn.com.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.entity.Test;
import cn.com.service.TestService;
import cn.com.util.JsonUtil;
import cn.com.util.Result;

@Controller
@RequestMapping("/testAction")
public class TestAction {

	@Resource
	private TestService testService;
	
	@RequestMapping("/data")
	public void getAllTestData(HttpServletRequest request,HttpServletResponse resp) throws IOException{
		Result rs=new Result();
		List<Test> data=testService.getAllTestData();
		rs.getData().put("testData", data);
		JsonUtil.output(resp, rs);
	}
}
