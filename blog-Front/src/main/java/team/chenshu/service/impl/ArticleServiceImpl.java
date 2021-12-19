package team.chenshu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import team.chenshu.entity.Article;
import team.chenshu.entity.vo.ArticleVo;
import team.chenshu.mapper.ArticleMapper;
import team.chenshu.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客-文章表 服务实现类
 * </p>
 *
 * @author yu
 * @since 2021-12-04
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public IPage<Article> selectTags(Page<?> page) {


		IPage<Article> articleIPage = articleMapper.selectTags(page);


		return articleIPage;
	}

	@Override
	public IPage<ArticleVo> selectPageVo(Page<?> page, int tag) {

		IPage<ArticleVo> articleIPage = articleMapper.selectPageVo(page,tag);

		return articleIPage;
	}


}
