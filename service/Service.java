package ua.skrypchenko.taskmvc.service;

import ua.skrypchenko.taskmvc.model.Model;

public class Service {

    private Model model;

    public Service(Model model) {
        this.model = model;
    }

    public void setFirstValue(int firstValue) {

        model.setFirst(firstValue);

    }

    public void setSecondValue(int secondValue){

        model.setSecond(secondValue);

    }

    public int plusValues (){

        return model.getFirst()+model.getSecond();

    }

    public int subtractionValues(){

        return model.getFirst()-model.getSecond();

    }


}
