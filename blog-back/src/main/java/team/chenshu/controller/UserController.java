package team.chenshu.controller;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

import team.chenshu.base.BaseResponse;
import team.chenshu.base.ResultUtils;
import team.chenshu.entity.User;
import team.chenshu.entity.vo.ArticleVo;
import team.chenshu.entity.vo.UserVo;
import team.chenshu.service.UserService;

import java.util.Optional;

/**
 * <p>
 * 博客-用户表 前端控制器
 * </p>
 *
 * @author yu
 * @since 2021-12-05
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	@ResponseBody
	@ApiOperation("博客管理系统用户注册")
	@ApiImplicitParams({
			@ApiImplicitParam(name="UserVo",value="用户对象",paramType="form"),
	})
	public BaseResponse<Boolean> register(@RequestBody UserVo userVo){
		String s = Optional.ofNullable(userVo).map(UserVo::getUserName).map(String::toUpperCase).orElse("没有上传名字");
		if("没有上传名字".equals(s)){
			return ResultUtils.error(5001,"没有上传用户名字");
		}
		User user  = new User();
		BeanUtils.copyProperties(userVo,user);
		boolean save = userService.save(user);
		return ResultUtils.success(save);
	}
}

