package com.sicc.work.service;

import java.util.List;

import com.sicc.work.vo.WorkVO;

/**
 * 업무용 CRUD를 위한 정의
 * @author Woongs
 */
public interface WorkService {
	public WorkVO save(WorkVO workVO);				// 저장
	
	public WorkVO updateByWorkNum(WorkVO workVO);		// 갱신
	
	public List<WorkVO> findAll();					// 전체 조회

	public WorkVO findByWorkNum(String workNum);	// 작업번호에 따른 조회
	
	public void delete(String workNum);				// 작업번호에 따른 삭제
}