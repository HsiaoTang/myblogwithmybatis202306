package test.myblog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.myblog.config.JwtUtils;
import test.myblog.model.Article;
import test.myblog.model.Tag;
import test.myblog.persist.dao.DAOException;
import test.myblog.service.ArticleService;
import test.myblog.service.MemberService;
import test.myblog.service.TagService;

@RestController
@RequestMapping("/api/v1/index")
@CrossOrigin(origins="https://codingstrayclient.zeabur.app/")
public class IndexController {
	
	@Autowired
	private TagService ts;
	
	@Autowired
	private ArticleService as;
	
	@Autowired
	private MemberService ms;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	@GetMapping("/allTags")
	public ResponseEntity<List<Tag>> showAllTags() throws DAOException{
		List<Tag> tL = ts.getAllTags();
		return ResponseEntity.ok(tL);	
	}
	
	@GetMapping("/getArticleListByTag")
	public ResponseEntity<List<List<Map<String, Object>>>> getArticleListByTag() throws DAOException{
		return ResponseEntity.ok(as.getArticleListByTid());
	}
	
	@GetMapping("/getTopLikedList")
	public ResponseEntity<List<Map<String, Object>>> getTopLikedList() throws DAOException{
		return ResponseEntity.ok(ms.topLiked());
	}
	
	@GetMapping("/getTopViewedList")
	public ResponseEntity<List<Map<String, Object>>> getTopViewedList() throws DAOException{
		return ResponseEntity.ok(ms.topViewed());
	}
	
	@PostMapping("/getUserId")
	public ResponseEntity<Integer> getUserId(@RequestBody String jwt) throws DAOException{
		Integer userId = ms.getMemberByMusername(jwtUtils.extractM_username(jwt)).getM_id();
		return ResponseEntity.ok(userId);
	}
}
