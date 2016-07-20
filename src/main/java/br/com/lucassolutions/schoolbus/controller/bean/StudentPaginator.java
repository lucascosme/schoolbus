package br.com.lucassolutions.schoolbus.controller.bean;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentPaginator {
	
	@JsonProperty
	private Collection<StudentBean> studentBeans;
	
	@JsonProperty
	private int listSize;
	
	@JsonProperty
	private int page;
	
	@JsonProperty
	private int numberOfPages;

	public Collection<StudentBean> getStudentBeans() {
		return studentBeans;
	}

	public void setStudentBeans(Collection<StudentBean> students) {
		this.studentBeans = students;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
}
