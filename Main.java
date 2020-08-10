package ua.skrypchenko.taskmvc;

import ua.skrypchenko.taskmvc.controller.Controller;
import ua.skrypchenko.taskmvc.model.Model;
import ua.skrypchenko.taskmvc.service.Service;
import ua.skrypchenko.taskmvc.view.View;

public class Main {
    public static void main(String[] args) {

        Model model = new Model();
        View view = new View();
        Service service = new Service(model);
        Controller controller = new Controller(view, service);
        controller.process();

    }


}
