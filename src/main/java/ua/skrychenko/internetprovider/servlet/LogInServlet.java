package ua.skrychenko.internetprovider.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.skrychenko.internetprovider.dto.UserDto;
import ua.skrychenko.internetprovider.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logIn")
public class LogInServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        UserDto userDto = objectMapper.readValue(req.getInputStream(), UserDto.class);

        String role = userService.chekUser(userDto);

        if (role.equals("guest")) {
            resp.getWriter().write("You are guest");
        } else if (role.equals("admin")) {
            resp.getWriter().write("You are admin");
        } else resp.getWriter().write("incorrect user name or password");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
