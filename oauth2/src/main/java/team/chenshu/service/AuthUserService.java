package team.chenshu.service;

/**
 * @author yu
 * @date 2021/12/18 - 17:59
 * @Content:
 */
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import team.chenshu.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import team.chenshu.entity.Users;
import team.chenshu.mapper.UserMapper;

import java.util.ArrayList;

@Slf4j
@Component
public class AuthUserService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("username:" + username);
		// 查询数据库操作
		LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<Users>();

		wrapper.eq(Users::getUserName,username);
		Users users = userMapper.selectOne(wrapper);
		if (StringUtils.isBlank(users.getUserPwd())) {
			throw new UsernameNotFoundException("the user is not found");
		}
		String password = passwordEncoder.encode(users.getUserPwd());
		return new User(username, password, new ArrayList<>());
	}
}
