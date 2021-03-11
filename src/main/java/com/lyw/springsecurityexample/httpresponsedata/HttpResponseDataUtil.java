package com.lyw.springsecurityexample.httpresponsedata;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lyw
 * @Create 2021-03-11 15:55
 */
public class HttpResponseDataUtil {

    public static HttpResponseData constructResponse(Object data,String httpCode,String message){
        return new HttpResponseData(httpCode,data,message);
    }
    @Data
    @AllArgsConstructor
    public static class HttpResponseData{
        private String httpCode;
        private Object data;
        private String message;
    }
}
