package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.ru.Дано;

public class StepDefinitions {
    @Дано("надпись Hello World")
    public void print_hello_world() {
        System.out.println("Hello, world!");
    }


}
