package team.chenshu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import team.chenshu.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import team.chenshu.entity.Menu;
import team.chenshu.entity.vo.ArticleVo;

/**
 * <p>
 * 博客-文章表 Mapper 接口
 * </p>
 *
 * @author yu
 * @since 2021-12-05
 */
public interface ArticleMapper extends BaseMapper<Article> {


	/**
	 * <p>
	 * 查询 : 根据state状态查询用户列表，分页显示
	 * </p>
	 *
	 * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
	 * @return 分页对象
	 */
	IPage<Article> selectTags(Page<?> page);

	IPage<ArticleVo> selectPageVo(Page<?> page);

}
