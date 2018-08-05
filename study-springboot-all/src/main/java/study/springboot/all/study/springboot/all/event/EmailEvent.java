package study.springboot.all.study.springboot.all.event;

import org.springframework.context.ApplicationEvent;

/**
 * Spring Boot 事件处理
 * 1、
 */
public class EmailEvent extends ApplicationEvent {
    private static final long serialVersionUID = 2308376662730908752L;

    public String address;
    public String text;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public EmailEvent(Object source) {
        super(source);
    }

    public EmailEvent(Object source, String address, String text) {
        super(source);
        this.address = address;
        this.text = text;
    }
}
