package org.mddarr.locationtracker.standalone;

import org.springframework.context.support.StaticApplicationContext;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.Arrays;

public class StandaloneControllerTests {
    /*
    Tests that instantiate the minimum infrastructure necessary to test annotated controller methdds and do not load Spring configuration.
     Tests send a {@link org.springframework.messaging.Message} that represents a STOMP frame and send it directly to the SimpAnnotationMethodMessageHandler

    We are testing that the controllers receive annotations


     */




//    private TestTradeService tradeService;
//
//    private TestMessageChannel clientOutboundChannel;
//
//    private TestAnnotationMethodHandler annotationMethodHandler;
//
//
//    @Before
//    public void setup() {
//
//        this.portfolioService = new PortfolioServiceImpl();
//        this.tradeService = new TestTradeService();
//        PortfolioController controller = new PortfolioController(this.portfolioService, this.tradeService);
//
//        this.clientOutboundChannel = new TestMessageChannel();
//
//        this.annotationMethodHandler = new TestAnnotationMethodHandler(
//                new TestMessageChannel(), clientOutboundChannel, new SimpMessagingTemplate(new TestMessageChannel()));
//
//        this.annotationMethodHandler.registerHandler(controller);
//        this.annotationMethodHandler.setDestinationPrefixes(Arrays.asList("/app"));
//        this.annotationMethodHandler.setMessageConverter(new MappingJackson2MessageConverter());
//        this.annotationMethodHandler.setApplicationContext(new StaticApplicationContext());
//        this.annotationMethodHandler.afterPropertiesSet();
//    }
//


}
