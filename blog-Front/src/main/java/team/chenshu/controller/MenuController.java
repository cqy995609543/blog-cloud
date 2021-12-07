package team.chenshu.controller;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.web.bind.annotation.*;

import team.chenshu.entity.Menu;
import team.chenshu.service.MenuService;

import javax.annotation.Resource;
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
	public List<Menu> getMenuList(String name){
		List<Menu> menuList = menuService.getMenuList(name);
		return menuList;
	}


	@RequestMapping("/helloWorld")
	@ResponseBody
	public String helloWorld() {

		return "Hello World";

	}


}

