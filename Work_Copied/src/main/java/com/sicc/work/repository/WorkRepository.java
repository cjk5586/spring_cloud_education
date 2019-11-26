package com.sicc.work.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sicc.work.vo.WorkVO;

/**
 * 업무용 CRUD Repository
 * @author Woongs
 */
public interface WorkRepository extends JpaRepository<WorkVO, Integer> {
	public <S extends WorkVO> S save(S WorkVO);		// 저장
	
	public WorkVO findByWorkNum(String work_num);	// 작업번호로 work 조회
	
	public List<WorkVO> findAll();					// WorkVO 전체 조회

	public void delete(WorkVO workVO);				// 작업번호로 삭제
}
