package team.chenshu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import team.chenshu.base.BaseResponse;
import team.chenshu.base.ResultUtils;
import team.chenshu.entity.Article;
import team.chenshu.entity.vo.ArticleVo;
import team.chenshu.service.ArticleService;

import javax.annotation.Resource;
import java.util.Arrays;

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
@Api(tags="博客页文章接口")
public class ArticleController {

		@Resource
		private ArticleService articleService;

		@ResponseBody
		@PostMapping("/getArticleFromId")
		public Article getArticleFromId(int id){
			Article article = articleService.getById(id);
			return article;
		}




	@GetMapping("/queryArticleVoList")
	@ResponseBody
	@ApiOperation("根据左侧目录点击查询文章列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name="currentPage",value="当前页",required=true,paramType="form"),
			@ApiImplicitParam(name="showNum",value="列表展示几个",required=true,paramType="form"),
	})
	public BaseResponse<IPage<ArticleVo>> queryArticleVoList(int currentPage, int showNum,int tag){

		Page<Article> page1 = new Page<>(currentPage,showNum);
		IPage<Article> articleIPage = articleService.selectTags(page1,tag);
		Page<ArticleVo> page = new Page<>(currentPage,showNum);
		IPage<ArticleVo> articleVoIPage = articleService.selectPageVo(page,tag);
		articleIPage.getRecords().forEach((item)->{
			int[] Tags = Arrays.stream(item.getTags().split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
			System.out.println(Tags);
			articleVoIPage.getRecords().forEach(i ->{
				if(item.getId().equals(i.getId())){
					i.setTags(Tags);
				}
			});
		});
		System.out.println(articleVoIPage);
		return ResultUtils.success(articleVoIPage);
	}


	/**
	 * 获取文章
	 * @param id
	 * @return
	 */
	@ResponseBody
	@GetMapping("/queryArticle")
	@ApiOperation("获取文章")
	@ApiImplicitParams({
			@ApiImplicitParam(name="id",value="文章id",required=true,paramType="form"),
	})
	public BaseResponse<ArticleVo> getArticle(int id){
		ArticleVo articleVo = new ArticleVo();
		String val = id +"";
		if("".equals(val)){
			return ResultUtils.error(5001,"未上传文章id");
		}
		Article article = articleService.getById(id);
		BeanUtils.copyProperties(article,articleVo);
		int[] tags = Arrays.stream(article.getTags().split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
		articleVo.setTags(tags);
		System.out.println(articleVo);
		return  ResultUtils.success(articleVo);
	}





	@GetMapping("/queryArticleListFromHot")
	@ResponseBody
	@ApiOperation("查询出热度前五的文章，可翻页，翻页为热度 第六到第十")
	@ApiImplicitParams({
			@ApiImplicitParam(name="currentPage",value="当前页",required=true,paramType="form"),
			@ApiImplicitParam(name="showNum",value="列表展示几个",required=true,paramType="form"),
	})
	public BaseResponse<IPage<ArticleVo>> queryArticleListFromHot(int currentPage, int showNum){

		Page<Article> page1 = new Page<>(currentPage,showNum);
//		LambdaQueryWrapper<ArticleVo> wrapper = new LambdaQueryWrapper<ArticleVo>();
//		wrapper.orderByDesc(ArticleVo::getClick);
		IPage<Article> articleIPage = articleService.selectTagsOrderbyClick(page1);
		Page<ArticleVo> page = new Page<>(currentPage,showNum);

		IPage<ArticleVo> articleVoIPage = articleService.selectPageFromHot(page);
		// 查询数据库操作
//		LambdaQueryWrapper<ArticleVo> wrapper = new LambdaQueryWrapper<ArticleVo>();
//		wrapper.orderByDesc(ArticleVo::getClick);
//		articleService.list(wrapper)
//		IPage<ArticleVo> articleVoIPage = articleService.selectPageVo(page,tag);
		articleIPage.getRecords().forEach((item)->{
			int[] Tags = Arrays.stream(item.getTags().split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
			System.out.println("Tags"+Tags);
			articleVoIPage.getRecords().forEach(i ->{
				if(item.getId().equals(i.getId())){
					i.setTags(Tags);
				}
			});
		});
//		System.out.println(articleVoIPage);
		return ResultUtils.success(articleVoIPage);
	}




	@GetMapping("/queryArticleListFromTime")
	@ResponseBody
	@ApiOperation("查询出最新提交的文章")
	@ApiImplicitParams({
			@ApiImplicitParam(name="currentPage",value="当前页",required=true,paramType="form"),
			@ApiImplicitParam(name="showNum",value="列表展示几个",required=true,paramType="form"),
	})
	public BaseResponse<IPage<ArticleVo>> queryArticleListFromTime(int currentPage, int showNum){

		Page<Article> page1 = new Page<>(currentPage,showNum);
//		LambdaQueryWrapper<ArticleVo> wrapper = new LambdaQueryWrapper<ArticleVo>();
//		wrapper.orderByDesc(ArticleVo::getClick);
		IPage<Article> articleIPage = articleService.selectTagsOrderbyTime(page1);
		Page<ArticleVo> page = new Page<>(currentPage,showNum);

		IPage<ArticleVo> articleVoIPage = articleService.selectPageFromTime(page);
		// 查询数据库操作
//		LambdaQueryWrapper<ArticleVo> wrapper = new LambdaQueryWrapper<ArticleVo>();
//		wrapper.orderByDesc(ArticleVo::getClick);
//		articleService.list(wrapper)
//		IPage<ArticleVo> articleVoIPage = articleService.selectPageVo(page,tag);
		articleIPage.getRecords().forEach((item)->{
			int[] Tags = Arrays.stream(item.getTags().split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
			System.out.println("Tags"+Tags);
			articleVoIPage.getRecords().forEach(i ->{
				if(item.getId().equals(i.getId())){
					i.setTags(Tags);
				}
			});
		});
//		System.out.println(articleVoIPage);
		return ResultUtils.success(articleVoIPage);
	}




}






