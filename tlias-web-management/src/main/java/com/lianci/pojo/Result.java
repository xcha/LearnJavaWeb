package com.lianci.pojo;

import lombok.Data;

@Data
public class Result {
    private Integer code;
    private String meg;
    private Object data;

    public static Result success() {
        Result result = new Result();
        result.code=1;
        result.meg ="操作成功";
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.code=1;
        result.meg="操作成功";
        result.data=data;
        return result;
    }
    public static Result error(String message) {
        Result result = new Result();
        result.code=0;
        result.meg =message;
        return result;
    }
}
