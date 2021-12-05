package team.chenshu.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author yu
 * @date 2021/12/5 - 20:49
 * @Content:
 */
@Getter
@Setter
@ToString
public class MenuVo {

	private Long id;


	private Integer menuId;


	private String menuIcon;

	private String menuName;

	private Integer menuSort;

	private Integer menuFid;

	private List<MenuVo> children;

}
