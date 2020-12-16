package org.mddarr.locationtracker.load;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class StompWebSocketLoadTestServer {

    private static Log logger = LogFactory.getLog(StompWebSocketLoadTestClient.class);

    private static final int NUMBER_OF_USERS = 200;

    private static final int BROADCAST_MESSAGE_COUNT = 2000;

    public static void main(String[] args){
        String host = "localhost";

        if(args.length > 0){
            host = args[0];
        }

        int port = 37232;
        if(args.length > 1){
            port = Integer.valueOf(args[1]);
        }

        String homeUrl = "http://{host}:{port}/home";
        logger.debug("Sending warm-up HTTP request to " + homeUrl);
        HttpStatus status = new RestTemplate().getForEntity(homeUrl, Void.class, host, port).getStatusCode();
        Assertions.assertEquals(status, HttpStatus.OK);
        final CountDownLatch connectLatch = new CountDownLatch(NUMBER_OF_USERS);
        final CountDownLatch subscribeLatch = new CountDownLatch(NUMBER_OF_USERS);
        final CountDownLatch messageLatch = new CountDownLatch(NUMBER_OF_USERS);
        final CountDownLatch disconnectLatch = new CountDownLatch(NUMBER_OF_USERS);

        final AtomicReference<Throwable> failure = new AtomicReference<>();

        StandardWebSocketClient webSocketClient = new StandardWebSocketClient();

    }
}
