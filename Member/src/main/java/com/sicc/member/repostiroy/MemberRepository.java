package com.sicc.member.repostiroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sicc.member.vo.MemberVO;

/**
 * 사용자 정보 Repository
 * 
 * @author Woongs
 */
@Repository
public interface MemberRepository extends JpaRepository<MemberVO, Integer> {
	public <S extends MemberVO> S save(S memberVO); // 사용자 정보 저장

	public MemberVO findBySabun(String sabun); // 사번으로 사용자 정보 조회

	public List<MemberVO> findAll(); // 사용자 정보 전체 조회

	public void delete(MemberVO memberVO); // 사용자 정보 사번으로 삭제
}
