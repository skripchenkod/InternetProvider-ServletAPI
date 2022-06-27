package ua.skrychenko.internetprovider.servlet.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.skrychenko.internetprovider.dto.BalanceDto;
import ua.skrychenko.internetprovider.service.BalanceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guestPage/topUpBalance/*")
public class UserTopUpBalancePage extends HttpServlet {
    BalanceService balanceService = new BalanceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] pathInfo = req.getPathInfo().split("/");
        String user = pathInfo[1];
        ObjectMapper objectMapper = new ObjectMapper();
        BalanceDto balanceDto = objectMapper.readValue(req.getInputStream(), BalanceDto.class);
        balanceService.topUp(user, balanceDto.getSum());
    }
}
