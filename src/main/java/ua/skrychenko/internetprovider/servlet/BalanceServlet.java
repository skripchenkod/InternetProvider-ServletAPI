package ua.skrychenko.internetprovider.servlet;

import ua.skrychenko.internetprovider.service.BalanceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/balance")
public class BalanceServlet extends HttpServlet {
    BalanceService balanceService = new BalanceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        String userName = (String) session.getAttribute("guest");
        String sum = req.getParameter("sum");
        int sumInt = 0;
        try {
             sumInt = Integer.parseInt(sum);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        balanceService.topUp(userName, sumInt);

        req.getServletContext().getRequestDispatcher("/jsp/balancePage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/guest");
    }
}
