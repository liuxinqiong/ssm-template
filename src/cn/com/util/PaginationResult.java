package cn.com.util;

public class PaginationResult extends Result {

	private static final long serialVersionUID = -5135438820938730507L;

	//ҳ��С
	private int pageSize = 10;
	
	//�ܼ�¼��
	private int totalCount = 0;
	
	//��ǰҳ��
	private int pageNumber = 1;
	
	//��ҳ��
	private int pageTotal = 0;

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
}
