package team.chenshu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import team.chenshu.entity.Menu;
import team.chenshu.mapper.MenuMapper;
import team.chenshu.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 博客-菜单表 服务实现类
 * </p>
 *
 * @author yu
 * @since 2021-12-04
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {


    @Autowired
	private MenuMapper 	 menuMapper;


	@Override
	public List<Menu> getMenuList(String MenuName){


		List<Menu> menuList = menuMapper.getMenuList(MenuName);

		return  menuList;


	};



}
