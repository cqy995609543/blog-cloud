package team.chenshu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 博客-用户表
 * </p>
 *
 * @author yu
 * @since 2021-12-04
 */
@Getter
@Setter
@TableName("blogs_user")
@ApiModel(value = "User对象", description = "博客-用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String userPwd;

    private Integer userId;

    @ApiModelProperty("是否禁用登录")
    private String loginEnable;

    @ApiModelProperty("登录失败次数")
    private Integer loginError;

    @ApiModelProperty("最后登录时间")
    private LocalDateTime loginLastTime;

    @ApiModelProperty("头像")
    private String userPortrait;

    @ApiModelProperty("说明")
    private String userExplain;

    @ApiModelProperty("显示名称")
    private String userDisplayName;

    @ApiModelProperty("邮箱")
    private String userEmail;


}
