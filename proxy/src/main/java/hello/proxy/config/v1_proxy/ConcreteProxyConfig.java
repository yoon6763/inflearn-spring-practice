package hello.proxy.config.v1_proxy;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.config.v1_proxy.concretproxy.OrderControllerConcreteProxy;
import hello.proxy.config.v1_proxy.concretproxy.OrderRepositoryConcreteProxy;
import hello.proxy.config.v1_proxy.concretproxy.OrderServiceConcreteProxy;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public OrderControllerV2 orderControllerV2Proxy(LogTrace logTrace) {
        OrderControllerV2 target = new OrderControllerV2(orderServiceV2Proxy(logTrace));
        return new OrderControllerConcreteProxy(target, logTrace);
    }

    @Bean
    public OrderServiceV2 orderServiceV2Proxy(LogTrace logTrace) {
        OrderServiceV2 target = new OrderServiceV2(orderRepositoryV2Proxy(logTrace));
        return new OrderServiceConcreteProxy(target, logTrace);
    }

    @Bean
    public OrderRepositoryV2 orderRepositoryV2Proxy(LogTrace logTrace) {
        OrderRepositoryV2 target = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(target, logTrace);
    }

}
