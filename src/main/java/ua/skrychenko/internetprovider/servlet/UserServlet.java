package ua.skrychenko.internetprovider.servlet;

import com.google.gson.Gson;
import ua.skrychenko.internetprovider.entity.UserEntity;
import ua.skrychenko.internetprovider.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/users")

public class UserServlet extends HttpServlet {
    private final Gson gson = new Gson();

    UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserEntity> users = service.getAllUsers();
        String users1 = this.gson.toJson(users);

        resp.getWriter().write(users1);
    }
}
