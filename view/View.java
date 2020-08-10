package ua.skrypchenko.taskmvc.view;

public class View {

    public String INPUT_FIRST_VALUE = "Input first value";
    public String INPUT_SECOND_VALUE = "Input second value";
    public String HELLO = "Hello!!!\n";

    public String MENU = "choose the item \n Input values - 1 \n Plus values - 2 \n Subtraction values - 3 \n exit - 4";

    public void printMessage(String message) {

        System.out.println(message);

    }

    public void printMessage(int message){

        System.out.println(message);
    }


}
