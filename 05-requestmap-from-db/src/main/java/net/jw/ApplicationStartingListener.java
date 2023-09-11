package net.jw;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
class ApplicationStartingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        DefaultWebSecurityExpressionHandler handler = contextRefreshedEvent.getApplicationContext().getBean(DefaultWebSecurityExpressionHandler.class);

        System.out.println("aaa");
    }
}