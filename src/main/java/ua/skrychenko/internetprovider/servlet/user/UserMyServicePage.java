package ua.skrychenko.internetprovider.servlet.user;

import ua.skrychenko.internetprovider.dao.ServiceDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userPage/myServices/*")
public class UserMyServicePage extends HttpServlet {
    ServiceDaoImpl serviceDao = new ServiceDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] pathInfo = req.getPathInfo().split("/");
        String user = pathInfo[1];
        String information = serviceDao.getServiceByName(user);

        resp.getWriter().write(information);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }
}
