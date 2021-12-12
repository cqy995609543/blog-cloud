package team.chenshu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import team.chenshu.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 博客-菜单表 Mapper 接口
 * </p>
 *
 * @author yu
 * @since 2021-12-05
 */
public interface MenuMapper extends BaseMapper<Menu> {


	public List<Menu> getMenuList();

	public  List<Menu> getMenuType();




}
