package com.meiya.springcloudstudy.common.response;

import com.meiya.springcloudstudy.common.enums.ResponseEnum;

@SuppressWarnings("rawtypes")
public class BuildResponseUtil{

    public static  ResponseData buildSuccessResponse(){
        return new ResponseData(ResponseEnum.SUCCESS);
    }

    public static <T> ResponseData buildSuccessResponse(T data){
        return new ResponseData(ResponseEnum.SUCCESS, data);
    }

    /**
     * 请求失败（使用自定义提示信息）
     * @return 统一失败返回结果体
     */
    public static ResponseData buildFailResponse(String errorMsg){
        return new ResponseData(ResponseEnum.FAIL.getCode(), errorMsg);
    }

    /**
     * 业务受理失败（使用自定义异常信息）
     * @param errorMsg
     * @return
     */
    public static ResponseData buildServiceFailResponse(String errorMsg){
        return new ResponseData(ResponseEnum.SERVICE_EXCEPTION.getCode(), errorMsg);
    }

    /**
     * 程序异常 (使用自定义异常信息）
     * @param errorMsg
     * @return
     */
    public static ResponseData buildServerErrorResponse(String errorMsg){
        return new ResponseData(ResponseEnum.SERVER_EXCEPTION.getCode(), errorMsg);
    }
}
