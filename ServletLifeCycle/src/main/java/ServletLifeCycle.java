import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletLifeCycle  extends GenericServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("ServletLifeCycle init() initialized--");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("ServletLifeCycle service() called--");
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        out.println("<h1>Hello from ServletLife Cycle</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("ServletLifeCycle() destroyed--");
    }
}
