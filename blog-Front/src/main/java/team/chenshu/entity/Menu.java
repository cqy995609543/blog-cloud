package team.chenshu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 博客-菜单表
 * </p>
 *
 * @author yu
 * @since 2021-12-04
 */
@Getter
@Setter
@TableName("blogs_menu")
@ApiModel(value = "Menu对象", description = "博客-菜单表")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("菜单id")
    private Integer menuId;

    @ApiModelProperty("菜单图标")
    private String menuIcon;

    @ApiModelProperty("菜单名称")
    private String menuName;

    @ApiModelProperty("排序")
    private Integer menuSort;

    @ApiModelProperty("打开方式")
    private String menuTarget;

    @ApiModelProperty("菜单路径")
    private String menuUrl;

    @ApiModelProperty("父菜单id")
    private Integer menuFid;


}
