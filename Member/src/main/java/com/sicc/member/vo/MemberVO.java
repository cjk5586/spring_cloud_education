package com.sicc.member.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * 사용자 VO
 * 
 * @author Woongs
 */
@Component // 컨테이너가 Bean으로써 인식
@Entity // jpa
@Table(name = "tb_member") // h2 db에 tb_member로써 테이블 생성
public class MemberVO {
	@Id // 식별자
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증감
	@Column(name = "sn") // 컬러명 sn
	private Integer sn; // sn

	@Column(name = "sabun", unique = true, nullable = false, length = 10) // 컬러명 sabun, 유일함, null 허용치 않음, 10자리
	private String sabun; // 사번

	@Column(name = "name", nullable = false, length = 10) // 컬러명 name, null 허용치 않음, 10자리
	private String name; // 이름

	@Column(name = "division", nullable = false, length = 10) // 컬러명 division, null 허용치 않음, 10자리
	private String division; // 부서

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
