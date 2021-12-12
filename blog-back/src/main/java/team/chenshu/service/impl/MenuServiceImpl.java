package team.chenshu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import team.chenshu.entity.Menu;
import team.chenshu.entity.vo.TagVo;
import team.chenshu.entity.vo.TypeVo;
import team.chenshu.mapper.MenuMapper;
import team.chenshu.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 博客-菜单表 服务实现类
 * </p>
 *
 * @author yu
 * @since 2021-12-05
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

	@Autowired
	private MenuMapper menuMapper;


	@Override
	public List<TagVo> getMenuList() {
		List<Menu> menuList = menuMapper.getMenuList();
		List<TagVo> tagVoList = new ArrayList<TagVo>();
		//返回tag标签list
		AtomicInteger index = new AtomicInteger();
		menuList.forEach((item) ->{
			TagVo tagVo = new TagVo();
			tagVo.setTagId(item.getMenuId());
			tagVo.setTagName(item.getMenuName());
			tagVoList.add(index.getAndIncrement(), tagVo);
			System.out.println(tagVoList);
		});
		return tagVoList;
	}

	@Override
	public List<TypeVo> getMenuType() {

		List<Menu> menuTypeList = menuMapper.getMenuType();
		List<TypeVo> typeVoList = new ArrayList<TypeVo>();
		//返回tag标签list
		menuTypeList.forEach((item) ->{
			TypeVo typeVo = new TypeVo();
			typeVo.setTypeId(item.getMenuId());
			typeVo.setTypeName(item.getMenuName());
			typeVoList.add(typeVo);
		});

		return typeVoList;
	}




}
