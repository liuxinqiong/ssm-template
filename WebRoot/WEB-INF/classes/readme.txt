本模板继承了ssm框架和常用的工具包如下：
1.转码
2.md5加密
3.简单邮件发送
4.xss攻击
5.分页
6.ajax数据json返回

ajax数据返回进行了封装，针对分页和不分页的情况
1.分页
	使用PaginationResult
		PaginationResult result = new PaginationResult();
		String page_number_str = request.getParameter("page_number");
		String page_size_str = request.getParameter("page_size");
		String keyword=request.getParameter("ckey");
		// 设置参数默认值
		int page_number = 1;
		int page_size = 10;

		if (page_number_str != null) {
			page_number = Integer.parseInt(page_number_str);
		}

		if (page_size_str != null) {
			page_size = Integer.parseInt(page_size_str);
		}
		PojoDomain<SysConf> pojoDomain = sysConfService.querySysConfList(page_number, page_size,keyword);
		result.getData().put("sysconf_list", pojoDomain.getPojolist());
		result.setPageNumber(pojoDomain.getPage_number());
		result.setPageSize(pojoDomain.getPage_size());
		result.setPageTotal(pojoDomain.getPage_total());
		result.setTotalCount(pojoDomain.getTotal_count());
		JsonUtil.output(response, result);
	需要分页的service层
		public PojoDomain<Mf_message> selectMessage(Mf_user user,int isRead,int type,int pageNum){
			int start = (pageNum-1)*PageParam.PAGE_SIZE;
			int end = pageNum*PageParam.PAGE_SIZE+1;
			PojoDomain<Mf_message> pojo = new PojoDomain<Mf_message>();
			List<Mf_message> messages=mf_messageDao.selectMessage(user, isRead, type,start,end);
			pojo.setTotal_count(mf_messageDao.countAllForMessage(user, isRead, type));
			pojo.setPage_number(pageNum);
			pojo.setPage_size(PageParam.PAGE_SIZE);
			pojo.setPojolist(messages);
			return pojo;
		}
2.不分页
	使用result
		Result result = new Result();
		String key = request.getParameter("ckey");
		String value = request.getParameter("cvalue");
		SysConf sysConf = new SysConf();
		sysConf.setCkey(key);
		sysConf.setCvalue(value);
		sysConf = sysConfService.updateSysConf(sysConf);
		result.getData().put("sysconf", sysConf);
		JsonUtil.output(response, result);