package TestRunner;

import config.VideoGameConfig;
import config.VideoGameEndPoint;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class VideoGameTests extends VideoGameConfig {
    String gamePayload = "{\n" +
            "  \"category\": \"Platform\",\n" +
            "  \"name\": \"Mario\",\n" +
            "  \"rating\": \"Mature\",\n" +
            "  \"releaseDate\": \"2023-12-20\",\n" +
            "  \"reviewScore\": 8\n" +
            "}";
    @Test
    public void getAllGames(){
        given()
                .when()
                .get(VideoGameEndPoint.All_Games)
                .then();
    }

    @Test
    public void getSingleGame(){
        given()
                .pathParam("VideoGameId", 3)
                .when()
                .get(VideoGameEndPoint.Single_Game)
                .then()
                .body("id",equalTo(3))
                .body("rating",equalTo("Universal"));
    }

    @Test
    public void createGame(){

        given()
                .body(gamePayload)
        .when()
                .post(VideoGameEndPoint.All_Games)
        .then();

    }

    @Test
    public void updateGame(){
        given()
                .body(gamePayload)
                .pathParam("VideoGameId",3)
        .when()
                .put(VideoGameEndPoint.Single_Game)
        .then()
                .body("id",equalTo(3));
    }

}
