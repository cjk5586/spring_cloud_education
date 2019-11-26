package com.sicc.work.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicc.work.repository.WorkRepository;
import com.sicc.work.vo.WorkVO;

/**
 * 업무용 CRUD 구현
 * @author Woongs
 */
@Service
public class WorkServiceImpl implements WorkService {
	
	private static final Logger logger = LoggerFactory.getLogger(WorkServiceImpl.class); // 로그

	@Autowired
	WorkRepository workRepository;

	// work 저장
	@Override
	@Transactional
	public WorkVO save(WorkVO workVO) {
		return workRepository.save(workVO);
	}

	// work 갱신
	@Override
	@Transactional
	public WorkVO updateByWorkNum(WorkVO workVO) {
		WorkVO findResult = workRepository.findByWorkNum(workVO.getWorkNum());
		workVO.setSn(findResult.getSn());// SN 셋팅
		
		if(findResult != null) { // 조회결과가 있다면
			return workRepository.save(workVO); // 수정된  work 정보 저장
		} else {
			logger.debug(">>> no result about work information.");
			return null;
		}
	}

	// work 전체 조회
	@Override
	public List<WorkVO> findAll() {
		return workRepository.findAll();
	}

	// 업무번호에 따른 work 조회
	@Override
	public WorkVO findByWorkNum(String work_num) {
		WorkVO findResult = workRepository.findByWorkNum(work_num);

		if(findResult != null) { // 조회결과가 있다면
			return findResult;
		} else {
			logger.debug(">>> no result about work information.");
			return null;
		}
	}
	
	// 업무번호에 따른 work 삭제
	@Override
	@Transactional
	public void delete(String work_num) {
		WorkVO findResult = workRepository.findByWorkNum(work_num);
		workRepository.delete(findResult);
	}
}
