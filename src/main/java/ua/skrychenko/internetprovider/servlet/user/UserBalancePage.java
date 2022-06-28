package ua.skrychenko.internetprovider.servlet.user;

import ua.skrychenko.internetprovider.dto.BalanceDto;
import ua.skrychenko.internetprovider.service.BalanceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userPage/balance/*")
public class UserBalancePage extends HttpServlet {

    BalanceService service = new BalanceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] pathInfo = req.getPathInfo().split("/");
        String user = pathInfo[1];
        List<BalanceDto> balanceDtos = service.getBalance(user);

        for (BalanceDto balanceDto : balanceDtos) {
            resp.getWriter().write(balanceDtos.toString() + balanceDto.getStatus());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
