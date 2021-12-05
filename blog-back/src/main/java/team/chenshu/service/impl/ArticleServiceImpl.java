package team.chenshu.service.impl;

import team.chenshu.entity.Article;
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
 * @since 2021-12-05
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
