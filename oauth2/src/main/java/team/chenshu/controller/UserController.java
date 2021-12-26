package team.chenshu.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.chenshu.Utils.RedisUtils;
import team.chenshu.service.AuthUserService;

import javax.annotation.Resource;

/**
 * @author yu
 * @date 2021/12/21 - 22:37
 * @Content:
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Resource
	private AuthUserService authUserService;
	@Resource
	private RedisUtils redisUtils;
	/**
	 * 获取用户信息
	 */
//	@PostMapping("/userInfo")
//	public String userInfo() {
//		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
//		return JSON.toJSONString(authUserService.userInfo(userName));
//	}

	@GetMapping("/getKey")
	public String getRedisKey(){


		String test = (String)redisUtils.get("test");

		return test;

	}





}
