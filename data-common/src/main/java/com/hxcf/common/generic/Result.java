package com.hxcf.common.generic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "Result")
public class Result<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = -526388127643647282L;

    @ApiModelProperty(value = "泛型对象")
    private T data;// 数据

    @ApiModelProperty(value = "状态，T代表true，F代表false")
    private String status = "T";// 状态，T代表true，F代表false

    @ApiModelProperty(value = "数字码")
    private String code = "";// 数字码

    @ApiModelProperty(value = "提示信息")
    private String message = "";// 提示信息

    public Result() {
    }

    public Result(T data) {
        super();
        this.data = data;
    }

    public void setError(String code, String message) {
        this.code = code;
        this.message = message;
        this.status = "F";
    }

    /**
     * 构建一个data数据的成功结果
     *
     * @param data 接口数据
     * @param <T>  泛型类型
     * @return 成功结果
     */
    public static <T extends Serializable> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        return result;
    }

    /**
     * 构建一个以数字码和提示信息的失败结果
     *
     * @param code    数字码
     * @param message 提示信息
     * @param <T>     泛型类型
     * @return 失败结果
     */
    public static <T extends Serializable> Result<T> failure(String code, String message) {
        Result<T> result = new Result<>();
        result.setError(code, message);
        return result;
    }

    /**
     * 基于错误提示枚举构建失败信息
     *
     * @param tipsCodeEnum 错误提示信息
     * @param <T>          泛型类型
     * @return 失败结果
     */
    public static <T extends Serializable> Result<T> failure(TipsCodeEnum tipsCodeEnum) {
        Result<T> result = new Result<>();
        result.setError(tipsCodeEnum.getCode(), tipsCodeEnum.getMessage());
        return result;
    }

    /**
     * 判断接口status字段是否为T
     *
     * @return 判断结果
     */
    @JsonIgnore
    public boolean isSuccess() {
        return "T".equals(status);
    }

}
