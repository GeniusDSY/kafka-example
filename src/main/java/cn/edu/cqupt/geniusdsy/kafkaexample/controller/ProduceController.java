package cn.edu.cqupt.geniusdsy.kafkaexample.controller;

import cn.edu.cqupt.geniusdsy.kafkaexample.common.ErrorCode;
import cn.edu.cqupt.geniusdsy.kafkaexample.common.MessageEntity;
import cn.edu.cqupt.geniusdsy.kafkaexample.common.Response;
import cn.edu.cqupt.geniusdsy.kafkaexample.producer.SimpleProducer;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author :DengSiYuan
 * @date :2019/4/14 11:09
 * @desc :
 */
@Slf4j
@RestController
@RequestMapping("/kafka")
public class ProduceController {

    @Autowired
    private SimpleProducer simpleProducer;

    @Value("${kafka.topic.default}")
    private String topic;

    private Gson gson = new Gson();

    @GetMapping(value = "/hello",produces = {"application/json"})
    public Response sendKafka(){
        return new Response(ErrorCode.SUCCESS,"OK");
    }

    @PostMapping(value = "send",produces = {"application/json"})
    public Response sendKafka(@RequestBody MessageEntity message) {
        try {
            log.info("kafka的消息={}", gson.toJson(message));
            simpleProducer.send(topic, "key", message);
            log.info("发送kafka成功.");
            return new Response(ErrorCode.SUCCESS, "发送kafka成功");
        } catch (Exception e) {
            log.error("发送kafka失败", e);
            return new Response(ErrorCode.EXCEPTION, "发送kafka失败");
        }
    }

}
