package ua.skrychenko.internetprovider.servlet;

import ua.skrychenko.internetprovider.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminPage")
public class AdminPageServlet extends HttpServlet {
    AdminService adminService = new AdminService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String idTariff = req.getParameter("idName");
        String userName = req.getParameter("userName");
        if (name != null) {
            adminService.editNameOfTariff(idTariff, name);
        }

        String price = req.getParameter("price");
        if (price != null) {
            adminService.editPriceOfTariff(idTariff, price);
        }

        String delete = req.getParameter("delete");
        if (delete != null) {
            adminService.deleteTariff(idTariff);
        }

        String registration = req.getParameter("registration");
        if (registration != null) {
            req.getServletContext().getRequestDispatcher("/registration").forward(req, resp);
        }

        String statusOFBalance = req.getParameter("status");
        if (statusOFBalance != null) {
            adminService.editStatusOfUserBalance(userName, statusOFBalance);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
