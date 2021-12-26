package team.chenshu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import team.chenshu.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import team.chenshu.entity.vo.ArticleVo;

/**
 * <p>
 * 博客-文章表 服务类
 * </p>
 *
 * @author yu
 * @since 2021-12-04
 */
public interface ArticleService extends IService<Article> {

	IPage<Article> selectTags(Page<?> page, int tag);

	IPage<Article> selectTagsOrderbyClick(Page<?> page);

	IPage<ArticleVo> selectPageVo(Page<?> page, int tag);

	IPage<ArticleVo> selectPageFromHot(Page<?> page);


	IPage<Article> selectTagsOrderbyTime(Page<?> page);

	IPage<ArticleVo> selectPageFromTime(Page<?> page);



}
