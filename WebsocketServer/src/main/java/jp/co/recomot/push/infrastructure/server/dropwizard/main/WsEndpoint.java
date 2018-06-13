package jp.co.recomot.push.infrastructure.server.dropwizard.main;

import java.io.IOException;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebSocket
public class WsEndpoint {

	private static final Logger logger = LoggerFactory.getLogger(WsEndpoint.class);
	private Session session;

	public WsEndpoint() {

	}

	public Session getSession() {
		return session;
	}

	@OnWebSocketConnect
	public void onConnect(Session session) throws IOException {
		logger.info("ws onConnect");
		this.session = session;
		session.getRemote().sendString("{\"code\":\"OK\"}");
	}

	@OnWebSocketMessage
	public void onMessage(Session session, String message) throws IOException {
		logger.info("ws onMessage remote={}", session.getRemoteAddress());
		session.getRemote().sendString(message);
	}

	@OnWebSocketClose
	public void onClose(int statusCode, String reason) {
		logger.info("ws onClose");
	}

	@OnWebSocketError
	public void onError(Throwable e) {
		logger.error("ws onError");
		session.close();
	}
	
	

}
