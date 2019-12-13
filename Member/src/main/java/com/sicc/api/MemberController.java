package com.sicc.api;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sicc.service.WorkRemoteService;

@RestController
@RequestMapping("/members")
public class MemberController {
	private static final Logger LOG =  Logger.getLogger(MemberController.class.getName());
	
	@Autowired
	WorkRemoteService workRemoteService;
	
	@GetMapping(path = "/{memberId}")
	public String getMemberDetail(@PathVariable String memberId) {
		String workInfo = workRemoteService.getWorkInfo("77777");
        LOG.log(Level.INFO, "this is index /members/memberId called!");		
		return String.format("[member id = %s at %s %s ]", memberId, System.currentTimeMillis(), workInfo);
	}
}
