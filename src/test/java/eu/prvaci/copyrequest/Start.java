package eu.prvaci.copyrequest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Start {

	private static final int HTTP_PORT = 9090;

	public static void main(String[] args) throws Exception {
		Server server = new Server(HTTP_PORT);
		ServletContextHandler context = new ServletContextHandler();
		context.addServlet(CopyRequestServlet.class, "/*");
		server.setHandler(context);

		server.start();
	}
}
