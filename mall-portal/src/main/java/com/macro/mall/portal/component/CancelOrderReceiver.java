package com.macro.mall.portal.component;

import com.macro.mall.portal.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 取消订单消息的消费者-------------(监听的是死信消息转发后的普通消息队列)
 * /////其实就是每次下单--> 发送一个延时消息-->长时间没有得到处理(未付款)--->转发给普通消息队列--->被取消订单的消费者接收到-->取消订单
 * 消息队列的模式: 路由模式
 *
 * Created by macro on 2018/9/14.
 */
@Component
@RabbitListener(queues = "mall.order.cancel")//监听的是普通消息, 说明延时消息过期之后才会进去这里
public class CancelOrderReceiver {
    //日志
    private static final Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);
    //前台订单管理类
    @Autowired
    private OmsPortalOrderService portalOrderService;
    //接收消息的方法, 需要加RabbitHandler注解, 接收到了一个订单号
    @RabbitHandler
    public void handle(Long orderId){
        portalOrderService.cancelOrder(orderId);
        LOGGER.info("process orderId:{}",orderId);
    }
}
