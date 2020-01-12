package com.blj.springbootrabbitmq.test;

import com.blj.springbootrabbitmq.entity.User;
import com.blj.springbootrabbitmq.receiver.FanoutReceiver;
import com.blj.springbootrabbitmq.sender.DirectSender;
import com.blj.springbootrabbitmq.sender.FanoutSender;
import com.blj.springbootrabbitmq.sender.HeaderSender;
import com.blj.springbootrabbitmq.sender.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试类
 *
 * @author BaiLiJun  on 2019/10/30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootRabbitmqTest {
    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    private DirectSender directSender;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private HeaderSender headerSender;

    @Autowired
    private FanoutReceiver fanoutReceiver;//fanout接收器

    @Test
    public void testFanoutReceiver(){

    }

    @Test
    public void testFanoutSend(){
        User user = new User();
        user.setId("1");
        user.setName("Fanout");
        fanoutSender.send(user);
        //再次获取试试看看
        System.out.println("try again:");
        fanoutReceiver.receiveFanout1(user);
    }

    @Test
    public void testDirectSend(){
        User user = new User();
        user.setId("2");
        user.setName("Direct");
        directSender.send(user);
    }

    @Test
    public void testTopicSend(){
        User user = new User();
        user.setId("3");
        user.setName("Topic");
        topicSender.send(user);
    }

    @Test
    public void testHeaderSend(){
        headerSender.send("hello header Exchange");
    }

}
