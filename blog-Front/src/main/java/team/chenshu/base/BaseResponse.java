package team.chenshu.base;

import lombok.Data;

/**
 * @author yu
 * @date 2021/11/8 - 15:03  通用返回类
 * @Content:
 */
@Data
public class BaseResponse<T> {


	private int code ;

	private T data;

	private String message;

	public BaseResponse(int code, T data, String message) {
		this.code = code;
		this.data = data;
		this.message = message;
	}
}
