package team.chenshu.mapper;

import org.springframework.stereotype.Repository;
import team.chenshu.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 博客-用户表 Mapper 接口
 * </p>
 *
 * @author yu
 * @since 2021-12-04
 */
@Repository
public interface UserMapper extends BaseMapper<User> {


}
