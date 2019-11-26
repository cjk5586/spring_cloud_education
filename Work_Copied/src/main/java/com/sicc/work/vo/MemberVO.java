package com.sicc.work.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * 사용자 VO
 * @author Woongs
 */
@Component					// 컨테이너가 Bean으로써 인식
public class MemberVO {

	private Integer sn;			// sn
	
	private String sabun;		// 사번
	
	private String name;		// 이름
	
	private String division;	// 부서
	
	// setter & getter
	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public String getSabun() {
		return sabun;
	}

	public void setSabun(String sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	// toString()
	@Override
	public String toString() {
		return "MemberVO [sn=" + sn + ", sabun=" + sabun + ", name=" + name + ", division=" + division + "]";
	}
}
