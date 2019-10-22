package com.sicc.work.api;

import java.util.List;

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
	
	// 전체 조회
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<WorkVO> workSearchAll() {
		List<WorkVO> workList = workServiceImpl.findAll();
		
		return workList; // 조회된 리스트가 있을때
	}
	
	// 업무번호로 조회
	@RequestMapping(path = "/{workNum}", method = RequestMethod.GET)
	public WorkVO workSearch(@PathVariable String workNum) {
		throw new RuntimeException("I/O ERROR"); // 강제 Runtime Exception을 발생 -> fallback 발생을 위함
		// return workServiceImpl.findByWorkNum(workNum); // 정상적으로 리턴하는 값 -> fallback 테스트를 위해 주석 처리함
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
