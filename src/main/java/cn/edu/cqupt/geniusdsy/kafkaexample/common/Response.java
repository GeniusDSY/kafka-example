package cn.edu.cqupt.geniusdsy.kafkaexample.common;

import lombok.Data;

/**
 * @author :DengSiYuan
 * @date :2019/4/14 11:20
 * @desc :
 */
@Data
public class Response {
    private int code;
    private String message;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
