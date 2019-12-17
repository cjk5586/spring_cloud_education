package com.sicc.member.service;

import java.util.List;

import com.sicc.member.vo.MemberVO;

/**
 * Member micro service의 CRUD처리 정의
 * @author Woongs
 */
public interface MemberService {
	public MemberVO save(MemberVO memberVO);			// 저장
	
	public MemberVO updateBySabun(MemberVO memberVO);	// 갱신
	
	public List<MemberVO> findAll();					// 전체 조회

	public MemberVO findBySabun(String sabun);			// 사번에 따른 조회

	public void delete(String sabun); // 사번에 따른 삭제
}
