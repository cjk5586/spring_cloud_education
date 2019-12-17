package com.sicc.member.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicc.member.repostiroy.MemberRepository;
import com.sicc.member.vo.MemberVO;

/**
 * Member micro service의 CRUD처리 구현
 * 
 * @author Woongs
 */
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository; // jpa crud를 위한 repository

	// 사용자 정보 저장
	@Override
	@Transactional
	public MemberVO save(MemberVO memberVO) {
		return memberRepository.save(memberVO);
	}

	// 사용자 정보 갱신
	@Override
	@Transactional
	public MemberVO updateBySabun(MemberVO memberVO) {
		MemberVO findResult = memberRepository.findBySabun(memberVO.getSabun());

		memberVO.setSn(findResult.getSn()); // SN 셋팅

		if (findResult != null) { // 조회결과가 있다면
			return memberRepository.save(memberVO); // 수정된 사용자 정보 저장
		}

		return null; // 조회결과 없다면
	}

	// 사용자 정보 전체 조회
	@Override
	public List<MemberVO> findAll() {
		return memberRepository.findAll();
	}

	// 사번에 따른 사용자 정보 조회
	@Override
	public MemberVO findBySabun(String sabun) {
		MemberVO findResult = memberRepository.findBySabun(sabun);

		if (findResult != null) { // 조회결과가 있다면
			return findResult;
		} else {
			return null;
		}
	}

	// 사번에 따른 사용자 정보 삭제
	@Override
	public void delete(String sabun) {
		MemberVO findResult = memberRepository.findBySabun(sabun); // 삭제 데이터가 있는지 조회 (sn 때문)
		memberRepository.delete(findResult);
	}
}