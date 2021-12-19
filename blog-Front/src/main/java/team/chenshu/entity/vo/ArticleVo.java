package team.chenshu.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yu
 * @date 2021/12/11 - 21:57
 * @Content:
 */
@Getter
@Setter
@ApiModel(value = "Article对象", description = "博客-文章表")
public class ArticleVo {
	@ApiModelProperty("标题")
	private String title;
	@ApiModelProperty("作者")
	private String author;
	@ApiModelProperty("添加时间")
	private String addtime;
	@ApiModelProperty("标签")
	private int[] tags;
	@ApiModelProperty("分类id")
	private Integer cid;
	@ApiModelProperty("描述")
	private String description;
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty("文章id")
	private Long id;
	@ApiModelProperty("文章是否显示 1是 0否")
	private Boolean isShow;
	@ApiModelProperty("文章内容")
	private String content;
	@ApiModelProperty("文章观看数")
	private String click;

}
