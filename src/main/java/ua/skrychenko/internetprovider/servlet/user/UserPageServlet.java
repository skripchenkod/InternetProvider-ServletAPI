package ua.skrychenko.internetprovider.servlet.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.skrychenko.internetprovider.dto.BalanceDto;
import ua.skrychenko.internetprovider.entity.ServiceEntity;
import ua.skrychenko.internetprovider.entity.TariffEntity;
import ua.skrychenko.internetprovider.service.BalanceService;
import ua.skrychenko.internetprovider.service.ServiceService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/guestPage/*")
public class UserPageServlet extends HttpServlet {

    ServiceService serviceService = new ServiceService();
    BalanceService balanceService = new BalanceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<ServiceEntity, List<TariffEntity>> map = serviceService.getAll();
        for (Map.Entry entry : map.entrySet()) {
            resp.getWriter().write(entry.getKey().toString() + entry.getValue() + "\n");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        BalanceDto balanceDto = objectMapper.readValue(req.getInputStream(), BalanceDto.class);

        String[] pathInfo = req.getPathInfo().split("/");
        String user = pathInfo[1];

        resp.getWriter().write(balanceService.buyTariff(balanceDto.getId(), user));
    }
}
