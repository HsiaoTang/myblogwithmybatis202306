package test.myblog.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import test.myblog.model.Article;
import test.myblog.persist.dao.DAOException;
import test.myblog.service.ArticleService;


@RestController
@RequestMapping("/api/v1/newPost")
@CrossOrigin(origins="http://localhost:5173")
public class NewPostController {
	
	@Autowired
	private ArticleService as;
	
	@PostMapping("/saveNewPost")
	public ResponseEntity<Article> saveNewPost(@RequestBody Map<String, Object> postInfo) throws IOException, DAOException{
		Article createdNewPost = as.createNewPost(postInfo);
		
		return ResponseEntity.ok(createdNewPost);
	}
}
