��ģ��̳���ssm��ܺͳ��õĹ��߰����£�
1.ת��
2.md5����
3.���ʼ�����
4.xss����
5.��ҳ
6.ajax����json����

ajax���ݷ��ؽ����˷�װ����Է�ҳ�Ͳ���ҳ�����
1.��ҳ
	ʹ��PaginationResult
		PaginationResult result = new PaginationResult();
		String page_number_str = request.getParameter("page_number");
		String page_size_str = request.getParameter("page_size");
		String keyword=request.getParameter("ckey");
		// ���ò���Ĭ��ֵ
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
	��Ҫ��ҳ��service��
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
2.����ҳ
	ʹ��result
		Result result = new Result();
		String key = request.getParameter("ckey");
		String value = request.getParameter("cvalue");
		SysConf sysConf = new SysConf();
		sysConf.setCkey(key);
		sysConf.setCvalue(value);
		sysConf = sysConfService.updateSysConf(sysConf);
		result.getData().put("sysconf", sysConf);
		JsonUtil.output(response, result);