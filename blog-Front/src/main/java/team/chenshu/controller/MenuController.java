package team.chenshu.controller;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import team.chenshu.base.BaseResponse;
import team.chenshu.base.ResultUtils;
import team.chenshu.entity.Menu;
import team.chenshu.entity.vo.MenuVo;
import team.chenshu.service.MenuService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 博客-菜单表 前端控制器
 * </p>
 *
 * @author yu
 * @since 2021-12-04
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

	  @Resource
	  private MenuService menuService;


	  @ResponseBody
	  @GetMapping("/getMenu")
	  public List<Menu> getMenu(){
		   List<Menu> menuList = menuService.list();
		   return menuList;
	   }


	@ResponseBody
	@GetMapping("/getMenuList")
	@ApiOperation("根据一级目录获取左侧菜单栏")
	@ApiImplicitParams({
			@ApiImplicitParam(name="id",value="一级目录id",required=true,paramType="form")
	})
	public BaseResponse<List<MenuVo>> getMenuList(String id){
		List<Menu> menuList = menuService.getMenuList(id);
		List<MenuVo> menuVoList = new ArrayList<MenuVo>();
		//BeanUtils.copyProperties(menuList,menuVoList);
		menuList.forEach(item ->{
			MenuVo menuVo = new MenuVo();
			List<MenuVo> children = new ArrayList<MenuVo>();
			if(item.getMenuFid()!=0){
			menuList.forEach(i -> {
				if(item.getMenuId().equals(i.getMenuFid())){

						MenuVo menuVo1 = new MenuVo();
						menuVo.setId(item.getMenuId());
						menuVo.setLevel(item.getMenuTarget());
						menuVo.setName(item.getMenuName());
						menuVo1.setId(i.getMenuId());
						menuVo1.setLevel(i.getMenuTarget());
						menuVo1.setName(i.getMenuName());
						children.add(menuVo1);
					}

			});
				menuVo.setChildren(children);
				if(menuVo.getId() != null){
					menuVoList.add(menuVo);
				}
			}
		});
		System.out.println(menuVoList);
		if(menuVoList.size()<1){
			menuList.forEach(item ->{
				if(item.getMenuFid() != 0){
					MenuVo menuVo = new MenuVo();
					menuVo.setId(item.getMenuId());
					menuVo.setLevel(item.getMenuTarget());
					menuVo.setName(item.getMenuName());
					menuVoList.add(menuVo);
				}
			});
		}
		return ResultUtils.success(menuVoList);
	}


//	@RequestMapping("/helloWorld")
//	@ResponseBody
//	public String helloWorld() {
//
//		return "Hello World";
//
//	}


}

