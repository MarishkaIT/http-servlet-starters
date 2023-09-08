package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.UrlPath;

import java.io.IOException;

@WebServlet(UrlPath.DISPATCHER)
public class DispatcherServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/flights")
                .include(req, resp);

        var writer = resp.getWriter();
        writer.write("Hello 2");
//        System.out.println();


//        req.setAttribute("1", "234");
//        requestDispatcher.forward(req, resp);
    }
}
