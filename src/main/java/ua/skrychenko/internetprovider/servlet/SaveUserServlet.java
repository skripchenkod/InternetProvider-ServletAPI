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

@WebServlet("/saveUser")
public class SaveUserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        UserDto userDto = objectMapper.readValue(req.getInputStream(), UserDto.class);

        userService.saveUser(userDto.getUserName(), userDto.getPassword());
    }
}
