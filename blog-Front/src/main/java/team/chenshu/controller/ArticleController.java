package team.chenshu.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import team.chenshu.entity.Article;
import team.chenshu.service.ArticleService;

import javax.annotation.Resource;

/**
 * <p>
 * 博客-文章表 前端控制器
 * </p>
 *
 * @author yu
 * @since 2021-12-04
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

		@Resource
		private ArticleService articleService;

		@ResponseBody
		@PostMapping("/getArticleFromId")
		public Article getArticleFromId(int id){
			Article article = articleService.getById(id);
			return article;
		}


}

