package TestRunner;

import config.FootballGameConfig;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class FootballTests extends FootballGameConfig {
    @Test
    public void getDetailsOfAllAreas(){
        given()
                .queryParam("areas",2000)
                .when()
                .get("areas")
                .then()
                .body("count",equalTo(1));

    }

    @Test
    public void getDetailOfSingleArea(){
        String areaIds = "2000,2001,2003";
        given()
                .queryParam("areas",areaIds)
                .when()
                .get("areas")
                .then()
                .body("count",equalTo(2))
                .body("filters.areas[0]",equalTo(2000));
    }
}
