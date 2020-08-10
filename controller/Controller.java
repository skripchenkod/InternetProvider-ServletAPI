package ua.skrypchenko.taskmvc.controller;

import ua.skrypchenko.taskmvc.service.Service;
import ua.skrypchenko.taskmvc.view.View;
import java.util.Scanner;

public class Controller {

    private View view;
    private Service service;

    public Controller(View view, Service service) {
        this.view = view;
        this.service = service;
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        view.printMessage(view.HELLO);
        boolean f=true;
        while(f){
            view.printMessage(view.MENU);
            int ch = sc.nextInt();
        switch (ch) {
            case 1:
                view.printMessage(view.INPUT_FIRST_VALUE);
                service.setFirstValue(sc.nextInt());
                view.printMessage(view.INPUT_SECOND_VALUE);
                service.setSecondValue(sc.nextInt());
                break;
            case 2:
                view.printMessage(service.plusValues());
                break;
            case 3:
                view.printMessage(service.subtractionValues());
                break;
            case 4:
                f=false;
                break;
        }}


    }


}
