package jp.co.recomot.push.infrastructure.server.dropwizard.main;

import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * webSocketServlet
 *
 */
public class WsServlet extends WebSocketServlet implements WebSocketCreator {

	private static final Logger logger = LoggerFactory.getLogger(WsServlet.class);

	private static final long serialVersionUID = 1L;

	@Override
	public void configure(WebSocketServletFactory factory) {
		logger.info("WebSocket started");
		factory.setCreator(this);
	}

	@Override
	public Object createWebSocket(ServletUpgradeRequest req, ServletUpgradeResponse resp) {
		return new WsEndpoint();
	}
	
}