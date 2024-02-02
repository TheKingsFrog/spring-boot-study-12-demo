package com.hong.springbootstudy12demo.demos.web.listener.eventlistener;

import com.hong.springbootstudy12demo.demos.web.listener.entity.PersonEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventListenerService {

    @EventListener
    public void handlePersonEvent(PersonEvent personEvent) {
        log.info("监听到PersonEvent：{}", personEvent);
    }

}
