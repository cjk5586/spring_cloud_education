package com.sicc.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/works")
public class WorkController {
	@RequestMapping(path = "/{workId}", method = RequestMethod.GET)
	public String getWorkDetail(@PathVariable String workId) {
		return String.format("[work id = %s at %s]", workId, System.currentTimeMillis());
	}
}
