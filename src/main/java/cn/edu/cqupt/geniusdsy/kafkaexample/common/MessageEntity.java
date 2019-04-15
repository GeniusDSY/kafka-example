package cn.edu.cqupt.geniusdsy.kafkaexample.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author :DengSiYuan
 * @date :2019/4/14 11:22
 * @desc :
 */
@Data
@EqualsAndHashCode
public class MessageEntity {
    private String title;
    private String body;

    @Override
    public String toString() {
        return "MessageEntity{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}