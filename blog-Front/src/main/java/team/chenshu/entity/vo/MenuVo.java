package team.chenshu.entity.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.chenshu.entity.Menu;

import java.util.List;

/**
 * @author yu
 * @date 2021/12/18 - 21:12
 * @Content:
 */

@Getter
@Setter
@ToString
public class MenuVo extends Menu {

	private Integer id;

	private String level;

	private  String name;

	private List<MenuVo> children;



}
