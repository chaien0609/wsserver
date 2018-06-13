package jp.co.recomot.push.infrastructure.server.dropwizard.main;

import javax.servlet.ServletRegistration;

import io.dropwizard.Application;
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class WsServerApplication extends Application<WsServerApplicationConfig> {

	public static void main(String[] args) throws Exception {
		new WsServerApplication().run("server", "src/main/resources/server.yml");
	}

	@Override
	public void initialize(Bootstrap<WsServerApplicationConfig> bootstrap) {
		bootstrap.addBundle(new ConfiguredAssetsBundle("/web-client/", "/web-client/"));
	}

	@Override
	public void run(WsServerApplicationConfig configuration, Environment environment) throws Exception {
		WsServlet wsServlet = new WsServlet();
		final ServletRegistration.Dynamic websocket = environment.servlets().addServlet("ws", wsServlet);
		websocket.setAsyncSupported(true);
		websocket.addMapping("/ws/*");
	}
}
