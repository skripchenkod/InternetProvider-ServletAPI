package ua.skrychenko.internetprovider.servlet;

import ua.skrychenko.internetprovider.dao.TariffDao;
import ua.skrychenko.internetprovider.dto.TariffDto;
import ua.skrychenko.internetprovider.service.BalanceService;
import ua.skrychenko.internetprovider.service.ServiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/guest")
public class GuestPageServlet extends HttpServlet {
    ServiceService service = new ServiceService();
    BalanceService balanceService = new BalanceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> services = service.getAll();
        req.setAttribute("service", services);
        List<TariffDto> tariffs = service.getTariff(req.getParameter("service"));
        req.setAttribute("tariffs", tariffs);

        HttpSession session = req.getSession(false);
        String user = (String) session.getAttribute("guest");

        req.setAttribute("balance", balanceService.getBalance(user));


        req.getServletContext().getRequestDispatcher("/jsp/guestPage.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
