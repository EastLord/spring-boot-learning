package com.dongjun.security.demo.core;

import com.alibaba.fastjson.JSON;

/**
 * 返回的结果信息
 * @author dongjun
 */
public class ResultMsg {

    /**
     * 响应码 resultCode
     */
    private int resultCode;

    /**
     * 返回的信息 message
     */
    private String message;

    /**
     * 返回的数据 data
     */
    private Object data;

    public int getResultCode() {
        return resultCode;
    }

    public ResultMsg setResultCode(int resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultMsg setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResultMsg setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
