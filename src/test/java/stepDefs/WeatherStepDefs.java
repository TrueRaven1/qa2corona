package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Clouds;
import model.Weather;
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
        Assertions.assertEquals(lat, response.getCoord().getLat(), "Wrong lat");

    }

    @Then("weather id is {int}")
    public void check_weather_id(int id) {
        Assertions.assertEquals(id, response.getWeathers().get(0).getId(), "Wrong weather id");

    }

    @Then("main is {string}")
    public void check_main(String main) {
        Assertions.assertEquals(main, response.getWeathers().get(0).getMain(), "Wrong weather main");

    }

    @Then("description is {string}")
    public void check_description(String description) {
        Assertions.assertEquals(description, response.getWeathers().get(0).getDescription(), "Wrong weather description");

    }

    @Then("icon is {string}")
    public void check_icon(String icon) {
        Assertions.assertEquals(icon, response.getWeathers().get(0).getIcon(), "Wrong weather icon");

    }

    @Then("base is {string}")
    public void check_base(String base) {
        Assertions.assertEquals(base, response.getBase(), "Wrong base");

    }

    @Then("temp is {double}")
    public void check_temp(double temp) {
        Assertions.assertEquals(temp, response.getMain().getTemp(), "Wrong main temp");

    }

    @Then("pressure is {int}")
    public void check_pressure(int pressure) {
        Assertions.assertEquals(pressure, response.getMain().getPressure(), "Wrong main pressure");

    }

    @Then("humidity is {int}")
    public void check_humidity(int humidity) {
        Assertions.assertEquals(humidity, response.getMain().getHumidity(), "Wrong main humidity");

    }

    @Then("temp_min is {double}")
    public void check_temp_min(double temp_min) {
        Assertions.assertEquals(temp_min, response.getMain().getTemp_min(), "Wrong main temp_min");

    }

    @Then("temp_max is {double}")
    public void check_temp_max(double temp_max) {
        Assertions.assertEquals(temp_max, response.getMain().getTemp_max(), "Wrong main temp_max");

    }

    @Then("visibility is {int}")
    public void check_visibility(int visibility) {
        Assertions.assertEquals(visibility, response.getVisibility(), "Wrong visibility");

    }

    @Then("speed is {double}")
    public void check_speed(double speed) {
        Assertions.assertEquals(speed, response.getWind().getSpeed(), "Wrong wind speed");

    }

    @Then("deg is {int}")
    public void check_deg(int deg) {
        Assertions.assertEquals(deg, response.getWind().getDeg(), "Wrong wind deg");

    }

    @Then("all is {int}")
    public void check_all(int all) {
        Assertions.assertEquals(all, response.getClouds().getAll(), "Wrong clouds all");

    }

    @Then("dt is {int}")
    public void check_dt(int dt) {
        Assertions.assertEquals(dt, response.getDt(), "Wrong dt");

    }

    @Then("type is {int}")
    public void check_type(int type) {
        Assertions.assertEquals(type, response.getSys().getType(), "Wrong sys type");

    }

    @Then("sys id is {int}")
    public void check_sys_id(int id) {
        Assertions.assertEquals(id, response.getSys().getId(), "Wrong sys id");

    }

    @Then("message is {double}")
    public void check_message(double message) {
        Assertions.assertEquals(message, response.getSys().getMessage(), "Wrong sys message");

    }

    @Then("country is {string}")
    public void check_country(String country) {
        Assertions.assertEquals(country, response.getSys().getCountry(), "Wrong sys country");

    }

    @Then("sunrise is {int}")
    public void check_sunrise(int sunrise) {
        Assertions.assertEquals(sunrise, response.getSys().getSunrise(), "Wrong sys sunrise");

    }

    @Then("sunset is {int}")
    public void check_sunset(int sunset) {
        Assertions.assertEquals(sunset, response.getSys().getSunset(), "Wrong sys sunset");

    }

    @Then("id is {int}")
    public void check_id(int id) {
        Assertions.assertEquals(id, response.getId(), "Wrong id");

    }

    @Then("name is {string}")
    public void check_name(String name) {
        Assertions.assertEquals(name, response.getName(), "Wrong name");

    }

    @Then("cod is {int}")
    public void check_cod(int cod) {
        Assertions.assertEquals(cod, response.getCod(), "Wrong cod");

    }

   }
