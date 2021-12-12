package team.chenshu.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import team.chenshu.base.BaseResponse;
import team.chenshu.base.ResultUtils;
import team.chenshu.entity.vo.TagVo;
import team.chenshu.entity.vo.TypeVo;
import team.chenshu.service.MenuService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 博客-菜单表 前端控制器
 * </p>
 *
 * @author yu
 * @since 2021-12-05
 */
@RestController
@RequestMapping("/menu")
@Api(tags="菜单类别标签接口")
public class MenuController {

	@Resource
	private MenuService menuService;

	/**
	 * 获取标签
	 * @return
	 */
	@ResponseBody
	@GetMapping("/getTagList")
	@ApiOperation("获取标签")
	public BaseResponse<List<TagVo>> getTagList(){
		List<TagVo> TagList = menuService.getMenuList();
		return ResultUtils.success(TagList);
	}
	/**
	 * 获取类别
	 * @return
	 */
	@ResponseBody
	@GetMapping("/getTypeList")
	@ApiOperation("获取类别")
	public BaseResponse<List<TypeVo>> getTypeList(){
		List<TypeVo> TypeList = menuService.getMenuType();
		return ResultUtils.success(TypeList);
	}


}

