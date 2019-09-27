import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String content = "";
		File file = new File("data/"+id);
        FileReader filereader = new FileReader(file);
        int singleCh = 0;
        while((singleCh = filereader.read()) != -1){
        	content += (char)singleCh;
        }
        filereader.close();
		
		PrintWriter pw = resp.getWriter();
		pw.write(""
				+ "<html>"
				+ "	<body>"
				+ "		<h1>WEB</h1>"
				+ "		<ol>"
				+ "			<li><a href=\"read?id=HTML\">HTML</a></li>"
				+ "			<li><a href=\"read?id=CSS\">CSS</a></li>"
				+ "			<li><a href=\"read?id=JavaScript\">JavaScript</a></li>"
				+ "		</ol>"
				+ "		<h2>"+id+"</h2>"
				+ "		"+content
				+ "	</body>"
				+ "</html>");
		pw.close();
	}

}
