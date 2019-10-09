package com.chs.rabbitMq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/10/9<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/10/9            创建
 * --------------------------------------------------------------------
 * </pre>
 */
@Component
public class Receiver {

    @RabbitListener(queues="hello-queue")
    public void process(String msg) {
        System.out.println("receiver: "+msg);
    }
}
