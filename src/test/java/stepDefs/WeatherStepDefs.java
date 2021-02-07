package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import recuesters.WeatherRequester;

import java.util.Map;

public class WeatherStepDefs {
    private int cityId;
    private WeatherResponse response;

    @Given("city id: {int}")
    public void set_city_id(int cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
// call Weather Requester
        WeatherRequester requester = new WeatherRequester();
        response = requester.getWeather(cityId);
    }

    @Then("lon is {double}")
    public void check_lon(double lon) {
        Assertions.assertEquals(lon, response.getCoord().getLon(), "Wrong lon");

    }

    @Then("lat is {double}")
    public void check_lat(double lat) {

    }

    @Then("id is {int}")
    public void check_id(int id) {

    }

    @Then("main is {string}")
    public void check_main(String main) {

    }

    @Then("description is {string}")
    public void check_description(String description) {

    }

    @Then("icon is {string}")
    public void check_icon(String icon) {

    }

    @Then("Base is {string}")
    public void check_base(String Base) {

    }

    @Then("temp is {double}")
    public void check_temp(double temp) {

    }

    @Then("pressure is {int}")
    public void check_pressure(int pressure) {

    }

    @Then("humidity is {int}")
    public void check_humidity(int humidity) {

    }

    @Then("temp_min is {double}")
    public void check_temp_min(double temp_min) {

    }

    @Then("temp_max is {double}")
    public void check_temp_max(double temp_max) {

    }

    @Then("visibility is {int}")
    public void check_visibility(int visibility) {

    }

    @Then("speed is {double}")
    public void check_speed(double speed) {

    }

    @Then("deg is {int}")
    public void check_deg(int deg) {

    }

    @Then("all is {int}")
    public void check_all(int all) {

    }

    @Then("dt is {int}")
    public void check_dt(int dt) {

    }

    @Then("type is {int}")
    public void check_type(int type) {

    }

    @Then("message is {double}")
    public void check_message(double message) {

    }

    @Then("country is {string}")
    public void check_country(String country) {

    }

    @Then("sunrise is {int}")
    public void check_sunrise(int sunrise) {

    }

    @Then("sunset is {int}")
    public void check_sunset(int sunset) {

    }


    @Then("name is {string}")
    public void check_name(String name) {

    }

    @Then("cod is {int}")
    public void check_cod(int cod) {

    }

    @Then("main data is:")
    public void check_main_data(Map<String, String> params) {

    }

}
