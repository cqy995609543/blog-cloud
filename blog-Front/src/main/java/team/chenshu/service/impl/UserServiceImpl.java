package team.chenshu.service.impl;

import team.chenshu.entity.User;
import team.chenshu.mapper.UserMapper;
import team.chenshu.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客-用户表 服务实现类
 * </p>
 *
 * @author yu
 * @since 2021-12-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
