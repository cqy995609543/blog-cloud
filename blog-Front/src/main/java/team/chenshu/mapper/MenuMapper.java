package team.chenshu.mapper;

import org.springframework.stereotype.Repository;
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
@Repository
public interface MenuMapper extends BaseMapper<Menu> {


		public List<Menu> getMenuList(String menuName);


		public  String   getMenuLists(String menuName);

}
