package team.chenshu.base;

/**
 * @author yu
 * @date 2021/11/8 - 15:13  相应工具类
 * @Content:
 */
public class ResultUtils {


	/**
	 *  返回成功
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> BaseResponse<T> success(T data){

			return new BaseResponse(0,data,"ok");

	}


	/**
	 *  返回失败
	 */
	public static <T> BaseResponse<T> error(int code ,String errorMessage){
		return new BaseResponse<>(code, null,errorMessage );
	}


}
