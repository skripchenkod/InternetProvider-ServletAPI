package ua.skrychenko.internetprovider.servlet.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.skrychenko.internetprovider.dto.UserDto;
import ua.skrychenko.internetprovider.service.AdminPageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("adminPage/blockUser")
public class AdminBlockUserServlet extends HttpServlet {

    AdminPageService service = new AdminPageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        UserDto userDto = objectMapper.readValue(req.getInputStream(), UserDto.class);

        service.editStatusOfUserBalance(userDto.getUserName(),userDto.getStatus());
    }
}
