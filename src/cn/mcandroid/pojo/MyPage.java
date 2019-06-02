package cn.mcandroid.pojo;

import java.util.List;

public class MyPage <T> {
	private  int pageNum;
	private int pageSize;
	private int count;
	private List<T> list;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public MyPage(int pageNum, int pageSize, int count, List<T> list) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.count = count;
		this.list = list;
	}
	public MyPage() {}

}
