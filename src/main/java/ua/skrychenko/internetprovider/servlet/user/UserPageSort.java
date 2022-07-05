package ua.skrychenko.internetprovider.servlet.user;

import ua.skrychenko.internetprovider.entity.ServiceEntity;
import ua.skrychenko.internetprovider.entity.TariffEntity;
import ua.skrychenko.internetprovider.service.ServiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/usersPage/sortBy/*")
public class UserPageSort extends HttpServlet {

    private final ServiceService serviceService = new ServiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] pathInfo = req.getPathInfo().split("/");
        String sortBy = pathInfo[1];
        Map<ServiceEntity, List<TariffEntity>> map = serviceService.getAll(sortBy);
        for (Map.Entry entry : map.entrySet()) {
            resp.getWriter().write(entry.getKey().toString() + entry.getValue() + "\n");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
