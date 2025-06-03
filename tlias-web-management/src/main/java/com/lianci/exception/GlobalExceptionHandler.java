package com.lianci.exception;

import com.lianci.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.DuplicateFormatFlagsException;

@Slf4j
@RestControllerAdvice// 全局异常处理
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("程序出错了：", e);
        return Result.error("服务器发生异常");
    }

    @ExceptionHandler
     public Result handleException(DuplicateKeyException e) {
        log.error("程序出错了：", e);
        String message = e.getMessage();
        int i = message.lastIndexOf("Duplicate entry");
        String errMsg= message.substring(i);
        String[] arr= errMsg.split(" ");
        return Result.error(arr[2]+"已存在");
    }

    @ExceptionHandler
    public Result handleBuinessException(BusinessException businessException) {
        log.error("服务器异常", businessException);
        return Result.error(businessException.getMessage());
    }
}
