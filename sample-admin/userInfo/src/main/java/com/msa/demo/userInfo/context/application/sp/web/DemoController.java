package com.msa.demo.userInfo.context.application.sp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msa.demo.userInfo.context.domain.demo.model.Demo;
import com.msa.demo.userInfo.context.domain.demo.repository.DemoRepository;
import com.msa.demo.userInfo.context.exception.DemoNotFoundException;

@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	DemoRepository demoRepository;
	
	@RequestMapping(value="/regist", method= RequestMethod.POST)
	public ResponseEntity<?> registDemo(@Validated @RequestBody Demo demo){
		System.out.println("controller demo entity check: " +demo.toString());
		return new ResponseEntity(null, HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Demo> findDemo(@PathVariable("id") Long id){
		Demo demo = demoRepository.findById(id).orElseThrow(()->new DemoNotFoundException("Demo not found"));

		return new ResponseEntity<>(demo, HttpStatus.OK);
	}
}
