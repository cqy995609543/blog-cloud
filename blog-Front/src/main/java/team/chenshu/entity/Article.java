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
 * 博客-文章表
 * </p>
 *
 * @author yu
 * @since 2021-12-04
 */
@Getter
@Setter
@TableName("blogs_article")
@ApiModel(value = "Article对象", description = "博客-文章表")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("文章表主键")
    private Integer aid;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("文章内容")
    private String content;

    @ApiModelProperty("关键字")
    private String keywords;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("文章是否显示 1是 0否")
    private Boolean isShow;

    @ApiModelProperty("是否删除 1是 0否")
    private Boolean isDelete;

    @ApiModelProperty("是否置顶 1是 0否")
    private Boolean isTop;

    @ApiModelProperty("是否原创")
    private Boolean isOriginal;

    @ApiModelProperty("点击数")
    private Integer click;

    @ApiModelProperty("添加时间")
    private String addtime;

    @ApiModelProperty("分类id")
    private Integer cid;

    @ApiModelProperty("标签")
    private String tags;

    @ApiModelProperty("导航栏url")
    private String topUrl;


}
