package ua.skrychenko.internetprovider.servlet.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.skrychenko.internetprovider.dto.TariffDto;
import ua.skrychenko.internetprovider.service.AdminPageService;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminPage/editTariff/*")
public class AdminEditTariffServlet extends HttpServlet {

    AdminPageService service = new AdminPageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] pathInfo = req.getPathInfo().split("/");
        String id = pathInfo[1];

        ObjectMapper objectMapper = new ObjectMapper();
        TariffDto tariffDto = objectMapper.readValue(req.getInputStream(), TariffDto.class);


        service.editTariff(id, tariffDto.getName(), tariffDto.getPrice());

    }
}
