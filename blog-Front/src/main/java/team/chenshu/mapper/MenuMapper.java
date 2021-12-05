package team.chenshu.mapper;

import team.chenshu.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 博客-菜单表 Mapper 接口
 * </p>
 *
 * @author yu
 * @since 2021-12-04
 */
public interface MenuMapper extends BaseMapper<Menu> {


		public ArrayList<Menu> getMenuList(String menuName);

}
