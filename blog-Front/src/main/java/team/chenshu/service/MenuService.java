package team.chenshu.service;

import team.chenshu.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 博客-菜单表 服务类
 * </p>
 *
 * @author yu
 * @since 2021-12-04
 */
public interface MenuService extends IService<Menu> {

	public List<Menu> getMenuList(String MenuName);

}
