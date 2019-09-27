import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Launcher {

	public static void main(String[] args) throws LifecycleException {
		
		Tomcat server = new Tomcat();
		
		Context app = server.addWebapp("/app", new File("WebContent").getAbsolutePath());
		
		server.setPort(9999);
		server.start();
		server.getServer().await();

	}

}
