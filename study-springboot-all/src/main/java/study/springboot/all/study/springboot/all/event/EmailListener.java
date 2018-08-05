package study.springboot.all.study.springboot.all.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 时间监听
 */
@Component
public class EmailListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof EmailEvent) {
            EmailEvent emailEvent = (EmailEvent) event;
            System.out.println("the source is:" + emailEvent.getSource());
            System.out.println("the address is:" + emailEvent.address);
            System.out.println("the email's context is:" + emailEvent.text);
        } else {
            System.out.println(event.getSource());
        }
    }
}
