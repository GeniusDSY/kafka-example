package cn.edu.cqupt.geniusdsy.kafkaexample.consumer;

import cn.edu.cqupt.geniusdsy.kafkaexample.common.MessageEntity;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author :DengSiYuan
 * @date :2019/4/14 11:30
 * @desc :
 */
@Slf4j
@Component
public class SimpleConsumer {

    private final Gson gson = new Gson();

    @KafkaListener(topics = "${kafka.topic.default}", containerFactory = "kafkaListenerContainerFactory")
    public void receive(MessageEntity message) {
        log.info(gson.toJson(message));
    }
}
