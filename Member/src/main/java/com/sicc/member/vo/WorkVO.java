package com.sicc.member.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
public class WorkVO {
	private Integer sn;			// sn
	private String workNum;		// 작업번호
	private String title;		// 작업명
	private String contents;	// 작업내용
	private String priority;	// 중요도 (A, B, C, D, E, F)

	// 기본 생성자
	public WorkVO() {

	}

	// 생성자
	public WorkVO(Integer sn, String workNum, String title, String contents, String priority) {
		super();
		this.sn = sn;
		this.workNum = workNum;
		this.title = title;
		this.contents = contents;
		this.priority = priority;
	}

	// setter & getter
	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public String getWorkNum() {
		return workNum;
	}

	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	// toString()
	@Override
	public String toString() {
		return "WorkVO [sn=" + sn + ", workNum=" + workNum + ", title=" + title + ", contents=" + contents
				+ ", priority=" + priority + "]";
	}
}