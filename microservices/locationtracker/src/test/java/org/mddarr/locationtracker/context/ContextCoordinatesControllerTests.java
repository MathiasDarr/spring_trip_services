package org.mddarr.locationtracker.context;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.simp.annotation.support.SimpAnnotationMethodMessageHandler;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.AbstractSubscribableChannel;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.List;

/**
 * Tests CoordinateSocketController that rely on Spring TestContext framework to load the Spring configuratin.  Test the behavior of controllers using the actual spring configuration.  Using TestContext framework ensures that Spring ocnfiguration is loaded only once per test class.
 *
 *
 */

@ExtendWith(SpringExtension.class)
public class ContextCoordinatesControllerTests {

    @Autowired private AbstractSubscribableChannel clientInboundChannel;

    @Autowired private AbstractSubscribableChannel clientOutboundChannel;

    @Autowired private AbstractSubscribableChannel brokerChannel;

    private TestChannelInterceptor clientOutboundChannelInterceptor;

    private TestChannelInterceptor brokerChannelInterceptor;


    @BeforeEach
    public void setUp() throws Exception {

        this.brokerChannelInterceptor = new TestChannelInterceptor();
        this.clientOutboundChannelInterceptor = new TestChannelInterceptor();

        this.brokerChannel.addInterceptor(this.brokerChannelInterceptor);
        this.clientOutboundChannel.addInterceptor(this.clientOutboundChannelInterceptor);
    }


    @Test
    public void getPositions() throws Exception {

        StompHeaderAccessor headers = StompHeaderAccessor.create(StompCommand.SUBSCRIBE);
//        headers.setSubscriptionId("0");
//        headers.setDestination("/app/positions");
//        headers.setSessionId("0");
//        headers.setUser(new TestPrincipal("fabrice"));
//        headers.setSessionAttributes(new HashMap<>());
//        Message<byte[]> message = MessageBuilder.createMessage(new byte[0], headers.getMessageHeaders());
//
//        this.clientOutboundChannelInterceptor.setIncludedDestinations("/app/positions");
//        this.clientInboundChannel.send(message);
//
//        Message<?> reply = this.clientOutboundChannelInterceptor.awaitMessage(5);
//        Assertions.assertNotNull(reply);
//
//        StompHeaderAccessor replyHeaders = StompHeaderAccessor.wrap(reply);
//        Assertions.assertEquals("0", replyHeaders.getSessionId());
//        Assertions.assertEquals("0", replyHeaders.getSubscriptionId());
//        Assertions.assertEquals("/app/positions", replyHeaders.getDestination());
//
//        String json = new String((byte[]) reply.getPayload(), Charset.forName("UTF-8"));
//        new JsonPathExpectationsHelper("$[0].company").assertValue(json, "Citrix Systems, Inc.");
//        new JsonPathExpectationsHelper("$[1].company").assertValue(json, "Dell Inc.");
//        new JsonPathExpectationsHelper("$[2].company").assertValue(json, "Microsoft");
//        new JsonPathExpectationsHelper("$[3].company").assertValue(json, "Oracle");
    }

    @Test
    public void executeTrade() throws Exception {

//        Trade trade = new Trade();
//        trade.setAction(Trade.TradeAction.Buy);
//        trade.setTicker("DELL");
//        trade.setShares(25);
//
//        byte[] payload = new ObjectMapper().writeValueAsBytes(trade);
//
//        StompHeaderAccessor headers = StompHeaderAccessor.create(StompCommand.SEND);
//        headers.setDestination("/app/trade");
//        headers.setSessionId("0");
//        headers.setUser(new TestPrincipal("fabrice"));
//        headers.setSessionAttributes(new HashMap<>());
//        Message<byte[]> message = MessageBuilder.createMessage(payload, headers.getMessageHeaders());
//
//        this.brokerChannelInterceptor.setIncludedDestinations("/user/**");
//        this.clientInboundChannel.send(message);
//
//        Message<?> positionUpdate = this.brokerChannelInterceptor.awaitMessage(5);
//        assertNotNull(positionUpdate);
//
//        StompHeaderAccessor positionUpdateHeaders = StompHeaderAccessor.wrap(positionUpdate);
//        assertEquals("/user/fabrice/queue/position-updates", positionUpdateHeaders.getDestination());
//
//        String json = new String((byte[]) positionUpdate.getPayload(), Charset.forName("UTF-8"));
//        new JsonPathExpectationsHelper("$.ticker").assertValue(json, "DELL");
//        new JsonPathExpectationsHelper("$.shares").assertValue(json, 75);
    }


    @Configuration
    @EnableScheduling
    @ComponentScan(
            basePackages="org.mddarr.locationtracker",
            excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, value = Configuration.class)
    )
    @EnableWebSocketMessageBroker
    static class TestWebSocketConfig implements WebSocketMessageBrokerConfigurer {

        @Autowired
        Environment env;

        @Override
        public void registerStompEndpoints(StompEndpointRegistry registry) {
            registry.addEndpoint("/portfolio").withSockJS();
        }

        @Override
        public void configureMessageBroker(MessageBrokerRegistry registry) {
//			registry.enableSimpleBroker("/queue/", "/topic/");
            registry.enableStompBrokerRelay("/queue/", "/topic/");
            registry.setApplicationDestinationPrefixes("/app");
        }
    }

    /**
     * Configuration class that un-registers MessageHandler's it finds in the
     * ApplicationContext from the message channels they are subscribed to...
     * except the message handler used to invoke annotated message handling methods.
     * The intent is to reduce additional processing and additional messages not
     * related to the test.
     */
    @Configuration
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    static class TestConfig implements ApplicationListener<ContextRefreshedEvent> {

        @Autowired
        private List<SubscribableChannel> channels;

        @Autowired
        private List<MessageHandler> handlers;


        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            for (MessageHandler handler : handlers) {
                if (handler instanceof SimpAnnotationMethodMessageHandler) {
                    continue;
                }
                for (SubscribableChannel channel :channels) {
                    channel.unsubscribe(handler);
                }
            }
        }
    }
}