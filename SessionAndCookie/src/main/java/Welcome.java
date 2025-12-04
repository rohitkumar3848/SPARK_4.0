import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/welcome")
public class Welcome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false); //Don't create session if already exist
        System.out.println("Req is -->"+session);
        String name =(session!=null)? (String) session.getAttribute("userName"):"Guest";
        String email =(session!=null)? (String)session.getAttribute("userEmail"):"Not available";

        Cookie[] cookies = req.getCookies();
        String cookiesStr = "Guest";

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase("user")) {
                        URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8.name());
                }
            }
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();


        out.println("<h2>Weclome buddy, "+name+"</h2>");
        out.println("<h2>Your email, "+email+"</h2>");
    }
}
