package jp.co.recomot.push.infrastructure.server.dropwizard.main;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("message")
public class MessageResource {

	@POST
    @Consumes("text/plain")
    public void sendMessage(String msg) throws Exception {
    }
}
