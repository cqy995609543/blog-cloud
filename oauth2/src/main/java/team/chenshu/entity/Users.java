package team.chenshu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 博客-用户表
 * </p>
 *
 * @author yu
 * @since 2021-12-05
 */
@Getter
@Setter
@TableName("blogs_user")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String userName;

    private String userPwd;

    private Integer userId;

    private String loginEnable;

    private Integer loginError;

    private LocalDateTime loginLastTime;

    private String userPortrait;

    private String userExplain;

    private String userDisplayName;

    private String userEmail;


}
