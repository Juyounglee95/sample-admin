package com.msa.demo.userInfo.context.application.sp.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msa.demo.userInfo.context.domain.board.model.Post;
import com.msa.demo.userInfo.context.domain.board.repository.PostRepository;


@RestController
@RequestMapping("/api/boards")
public class PostRestController {
	@Autowired
	private PostRepository postRepository;
	
	@PostMapping
	public ResponseEntity<?> postboard(@RequestBody Post post){
		System.out.println("savesave");
		postRepository.save(post);
		return new ResponseEntity<>("{}",HttpStatus.CREATED); 
	}
	@PutMapping("{id}")
	public ResponseEntity<?> putboard(@PathVariable("id") Long id, @RequestBody Post post){
		System.out.println("update");
		Post persistPost = postRepository.findById(id).get();
		if(post!=null) {
			BeanUtils.copyProperties(post, persistPost, "id","writerId");
			postRepository.save(persistPost);
			return new ResponseEntity<>("{}",HttpStatus.OK); 
		}
		return new ResponseEntity<>("{}", HttpStatus.BAD_REQUEST) ; 
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteboard(@PathVariable("id") Long id){
		System.out.println("delete");
		postRepository.deleteById(id);
		return new ResponseEntity<>("{}",HttpStatus.OK); 
	}
	
}
