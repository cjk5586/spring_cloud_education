package com.sicc.work.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sicc.work.service.WorkServiceImpl;
import com.sicc.work.vo.WorkVO;

/**
 * 업무 관련 REST API
 * @author Woongs
 */
@RestController
@RequestMapping("/work")
public class WorkRestController {
	@Autowired
	WorkServiceImpl workServiceImpl;	// 사용자 CRUD를 위한 구현체
	
	private static final Logger logger = LoggerFactory.getLogger(WorkRestController.class); // 로그
	
	// test 데이터 생성/저장
	@RequestMapping(path = "/testData", method = RequestMethod.GET)
	public WorkVO workTestData() {
		WorkVO workVO = new WorkVO();
		workVO.setWorkNum("1");
		workVO.setTitle("springcloud");
		workVO.setContents("education");
		workVO.setPriority("asap");
		
		return workServiceImpl.save(workVO);
	}
	
	// 전체 조회
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<WorkVO> workSearchAll() {
		List<WorkVO> workList = workServiceImpl.findAll();
		
		return workList; // 조회된 리스트가 있을때
	}
	
	// 업무번호로 조회
	@RequestMapping(path = "/{workNum}", method = RequestMethod.GET)
	public WorkVO workSearch(@PathVariable String workNum) {
		return workServiceImpl.findByWorkNum(workNum); // 정상적으로 리턴하는 값
		/*
		throw new RuntimeException("I/O ERROR"); // 강제 Runtime Exception을 발생 -> fallback 발생을 위함
		try {
			int delayTime = 2; // 지연시간 2초 설정
			for (int i = 1; i <= delayTime; i++) {
				Thread.sleep(1000*delayTime); // 지연 2초 발생
				logger.info("********" + i + "초 지연...");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 */
	}
	
	// 저장
	@RequestMapping(path = "/{workNum}/{title}/{contents}/{priority}", method = RequestMethod.POST)
	public WorkVO workSave(@PathVariable String workNum, @PathVariable String title, @PathVariable String contents, @PathVariable String priority) {
		WorkVO workVO = new WorkVO();
		workVO.setWorkNum(workNum);
		workVO.setTitle(title);
		workVO.setContents(contents);
		workVO.setPriority(priority);
		
		workVO = workServiceImpl.save(workVO); // 저장
		return workVO;
	}
	
	// 갱신
	@RequestMapping(path = "/{workNum}/{title}/{contents}/{priority}", method = RequestMethod.PUT)
	public WorkVO workSaveByWorkNum(@PathVariable String workNum, @PathVariable String title, @PathVariable String contents, @PathVariable String priority) {
		WorkVO workVO = new WorkVO();
		workVO.setWorkNum(workNum);
		workVO.setTitle(title);
		workVO.setContents(contents);
		workVO.setPriority(priority);
		
		workVO = workServiceImpl.updateByWorkNum(workVO); // 갱신
		return workVO;
	}

	// 삭제
	@RequestMapping(path = "/{workNum}", method = RequestMethod.DELETE)
	public String workDeleteByWorkNum(@PathVariable String workNum) {
		workServiceImpl.delete(workNum);
		return workNum+" is deleted.";
	}
}
