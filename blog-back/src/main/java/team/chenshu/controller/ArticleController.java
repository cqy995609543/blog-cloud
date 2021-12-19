package team.chenshu.controller;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import team.chenshu.base.BaseResponse;
import team.chenshu.base.ResultUtils;
import team.chenshu.entity.Article;
import team.chenshu.entity.vo.ArticleVo;
import team.chenshu.service.ArticleService;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * <p>
 * 博客-文章表 前端控制器
 * </p>
 *
 * @author yu
 * @since 2021-12-05
 */
@RestController
@RequestMapping("/article")
@Api(tags="文章接口")
public class ArticleController {

	@Resource
	private ArticleService articleService;

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

	/**
	 * 新增文章
	 * @param articleVo
	 * @return
	 */
	@ResponseBody
	@PostMapping("addArticle")
	@ApiOperation("新增文章")
	@ApiImplicitParams({
			@ApiImplicitParam(name="article",value="文章对象",paramType="form"),
	})
	public BaseResponse<Object> addArticle(@RequestBody ArticleVo articleVo){
		String s = Optional.ofNullable(articleVo).map(ArticleVo::getTitle).map(String::toUpperCase).orElse("没有上传参数");
		if("没有上传参数".equals(s)){
			return ResultUtils.error(5001,"上传文章对象为空");
		}
		Article article = new Article();
		article.setAuthor(articleVo.getAuthor());
		article.setAddtime(articleVo.getAddtime());
		article.setDescription(articleVo.getDescription());
		//将tags int类型数组转换成string类型，方便存入数据库
		String tags = Arrays.stream(articleVo.getTags()).boxed().map(i -> i.toString()) //必须将普通数组 boxed才能 在 map 里面 toString
				.collect(Collectors.joining(","));
		article.setTags(tags);
		article.setContent(articleVo.getContent());
		article.setCid(articleVo.getCid());
		article.setTitle(articleVo.getTitle());
		article.setIsShow(articleVo.getIsShow());
		//BeanUtils.copyProperties(articleVo,article);
		boolean save = articleService.save(article);
		return ResultUtils.success(save);
	}

	/**
	 * 删除文章
	 * @param id
	 * @return
	 */
	@ResponseBody
	@PostMapping("deleteArticle")
	@ApiOperation("删除文章")
	@ApiImplicitParams({
			@ApiImplicitParam(name="id",value="文章id",required=true,paramType="form"),
	})
	public BaseResponse<Object> deleteArticle(@RequestBody int id){
		boolean delete = articleService.removeById(id);
		return ResultUtils.success(delete);
	}

	/**
	 * 修改文章
	 * @param articleVo
	 * @return
	 */
	@ResponseBody
	@PostMapping("updateArticle")
	@ApiOperation("修改文章")
	@ApiImplicitParams({
			@ApiImplicitParam(name="articleVo",value="文章对象",required=true,paramType="form"),
	})
	public BaseResponse<Object> updateArticle(@RequestBody ArticleVo articleVo){

		String s = Optional.ofNullable(articleVo).map(ArticleVo::getTitle).map(String::toUpperCase).orElse("没有上传参数");
		if("没有上传参数".equals(s)){
			return ResultUtils.error(5001,"修改文章失败");
		}
		Article article = new Article();
		article.setAuthor(articleVo.getAuthor());
		article.setAddtime(articleVo.getAddtime());
		article.setDescription(articleVo.getDescription());
		//将tags int类型数组转换成string类型，方便存入数据库
		String tags = Arrays.stream(articleVo.getTags()).boxed().map(i -> i.toString()) //必须将普通数组 boxed才能 在 map 里面 toString
				.collect(Collectors.joining(","));
		article.setTags(tags);
		article.setContent(articleVo.getContent());
		article.setCid(articleVo.getCid());
		article.setTitle(articleVo.getTitle());
		article.setId(articleVo.getId());
		boolean update = articleService.saveOrUpdate(article);
		return ResultUtils.success(update);
	}

	@GetMapping("/queryArticleVoList")
	@ResponseBody
	@ApiOperation("查询文章列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name="currentPage",value="当前页",required=true,paramType="form"),
			@ApiImplicitParam(name="showNum",value="列表展示几个",required=true,paramType="form"),
	})
	public BaseResponse<IPage<ArticleVo>> queryArticleVoList(int currentPage,int showNum){

		Page<Article> page1 = new Page<>(currentPage,showNum);
		IPage<Article> articleIPage = articleService.selectTags(page1);
		Page<ArticleVo> page = new Page<>(currentPage,showNum);
		IPage<ArticleVo> articleVoIPage = articleService.selectPageVo(page);
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


}

