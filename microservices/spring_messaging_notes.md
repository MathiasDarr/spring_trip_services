### Channel Interceptor ###

Spring provides common mechanism to intercept messages sent to all types of channels.  Interception can be used for observing the content of messages header & payload, transform messages header or replace by an alternative message.  

public interface ChannelInterceptor {

	Message<?> preSend(Message<?> message, MessageChannel channel);

	void postSend(Message<?> message, MessageChannel channel, boolean sent);

	boolean preReceive(MessageChannel channel);

	Message<?> postReceive(Message<?> message, MessageChannel channel);
}


preSend()
postSend()