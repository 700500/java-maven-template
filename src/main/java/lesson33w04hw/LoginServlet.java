package lesson33w04hw;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = new BufferedReader(new FileReader(new File("content/html/login.html"))).lines().collect(Collectors.joining("\n"));

        try (PrintWriter w = resp.getWriter()) {
            w.write(result);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("Login");
        String password = req.getParameter("Password");

        DataBase db = new DataBase();
        String result = db.check(login, password);

        try(PrintWriter w = resp.getWriter()){
            w.write(result);
        }
    }
}
