package com.bai.front.service.model;

import com.bai.front.service.enums.ResultCodeEnum;
import org.springframework.util.StringUtils;

import java.io.Serializable;


public class ResultApi<T> implements Serializable {

    private int code ;

    private String message;

    private Data<T> data;

    private static final ResultApi<?> AJAX_FAIL = new ResultApi<Object>(ResultCodeEnum.FAIL);

    private static final ResultApi<?> AJAX_SUCCESS = new ResultApi<Object>(ResultCodeEnum.SUCCESS);

    protected ResultApi() {
        this.data = Data.<T> getInstance();
    }

    protected ResultApi(ResultCodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getDesc();
    }

    public Data<T> getData() {
        return data;
    }

    public T getDataIn() {
        if (data == null) {
            return null;
        }
        return data.getData();
    }

    /**
     * 放对象
     *
     * @param obj
     */
    public ResultApi<T> setDataObj(T obj) {
        if (data == null) {
            data = Data.<T> getInstance();
        }
        this.data.setData(obj);
        return this;
    }

    /**
     * 放列表
     *
     * @param list
     * @param total
     */
    public ResultApi<T> setDataList(T list, int total) {
        if (data == null) {
            data = Data.<T> getInstance();
        }
        this.data.setTotal(total);
        this.data.setData(list);
        return this;
    }

    public ResultApi<T> setData(Data<T> data) {
        this.data = data;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResultApi<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultApi<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public static <T> ResultApi<T> success() {
        return new ResultApi<T>(ResultCodeEnum.SUCCESS);
    }

    public static <T> ResultApi<T> success(String message) {
        ResultApi<T> resultApi = new ResultApi<T>(ResultCodeEnum.SUCCESS);
        resultApi.setMessage(message);
        return resultApi;
    }

    /**
     * 分页返回对象
     *
     * @param message
     * @param list
     * @param total
     * @return
     */
    public static <T> ResultApi<T> success(String message, T list, int total) {
        ResultApi<T> resultApi = new ResultApi<T>(ResultCodeEnum.SUCCESS);
        resultApi.setMessage(message);
        resultApi.setDataList(list, total);
        return resultApi;
    }

    public static <T> ResultApi<T> success(String message, T item) {
        ResultApi<T> resultApi = new ResultApi<T>(ResultCodeEnum.SUCCESS);
        resultApi.setMessage(message);
        Data<T> data = Data.<T> getInstance();
        data.setTotal(0);
        data.setData(item);
        resultApi.setData(data);
        return resultApi;
    }

    public static <T> ResultApi<T> success(T item) {
        ResultApi<T> resultApi = new ResultApi<T>(ResultCodeEnum.SUCCESS);
        Data<T> data = Data.<T> getInstance();
        data.setData(item);
        resultApi.setData(data);
        return resultApi;
    }

    public static <T> ResultApi<T> bizFail(String message) {
        ResultApi<T> resultApi = new ResultApi<T>(ResultCodeEnum.BIZ_FAIL);
        if (!StringUtils.isEmpty(message))
            resultApi.setMessage(message);
        return resultApi;
    }

    public static <T> ResultApi<T> fail() {
        return new ResultApi<T>(ResultCodeEnum.FAIL);
    }

    public static <T> ResultApi<T> fail(String message) {
        ResultApi<T> resultApi = new ResultApi<T>(ResultCodeEnum.FAIL);
        resultApi.setMessage(message);
        return resultApi;
    }

    public static <T> ResultApi<T> fail(ResultCodeEnum codeEnum) {
        return new ResultApi<T>(codeEnum);
    }

    /**
     * 简单的返回成功，不支持set操作
     *
     * @author oldwang
     * @return
     */
    public static ResultApi<?> ajaxSuccess() {
        return AJAX_SUCCESS;
    }

    /**
     * 简单的返回失败，不支持set操作
     *
     * @author oldwang
     * @return
     */
    public static ResultApi<?> ajaxFail() {
        return AJAX_FAIL;
    }


    public boolean isSuccess() {
        return ResultCodeEnum.SUCCESS.getCode() == this.getCode();
    }
}
