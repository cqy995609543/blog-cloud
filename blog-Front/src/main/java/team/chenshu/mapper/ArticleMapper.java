package team.chenshu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;
import team.chenshu.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import team.chenshu.entity.vo.ArticleVo;

/**
 * <p>
 * 博客-文章表 Mapper 接口
 * </p>
 *
 * @author yu
 * @since 2021-12-04
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {


	IPage<Article> selectTags(Page<?> page, int tag);

	IPage<ArticleVo> selectPageVo(Page<?> page, int tag);

	IPage<ArticleVo> selectPageFromHot(Page<?> page);

	IPage<Article> selectTagsOrderbyClick(Page<?> page);


	IPage<Article> selectTagsOrderbyTime(Page<?> page);

	IPage<ArticleVo> selectPageFromTime(Page<?> page);

}
