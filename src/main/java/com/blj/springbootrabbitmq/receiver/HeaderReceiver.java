package com.blj.springbootrabbitmq.receiver;

import com.blj.springbootrabbitmq.config.RabbitConfig;
import com.blj.springbootrabbitmq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Header 模式
 * 消费者
 *
 * @author BaiLiJun  on 2019/10/30
 */
@Component
public class HeaderReceiver {

    //queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.HEADER_QUEUE1)
    public void receiveHeader1(byte[] message){
        System.out.println("[receiveHeader1] receive message "+new String(message));
    }

    @RabbitListener(queues = RabbitConfig.HEADER_QUEUE2)
    public void receiveHeader2(byte[] message){
        System.out.println("[receiveHeader2] receive message "+new String(message));
    }

}
