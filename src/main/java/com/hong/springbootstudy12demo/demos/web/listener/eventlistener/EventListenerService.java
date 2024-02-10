package com.hong.springbootstudy12demo.demos.web.listener.eventlistener;

import com.hong.springbootstudy12demo.demos.web.event.BaseEvent;
import com.hong.springbootstudy12demo.demos.web.listener.entity.Order;
import com.hong.springbootstudy12demo.demos.web.listener.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventListenerService {

    @EventListener
    public void handlePersonEvent(BaseEvent<Person> personBaseEvent) {
        Object data = personBaseEvent.getData();
        log.info("监听到 person 开始数据加工={}", personBaseEvent);
    }

    @EventListener
    public void handleOrderEvent(BaseEvent<Order> orderBaseEvent) {
        Object data = orderBaseEvent.getData();
        log.info("监听到 order 开始数据数据加工={}", orderBaseEvent);
    }

}
