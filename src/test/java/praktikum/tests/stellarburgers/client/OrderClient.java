package praktikum.tests.stellarburgers.client;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.util.List;

import static io.restassured.RestAssured.given;

public class OrderClient {
    private static final String ORDERS = "/orders";

    @Step("Create order with auth and {ingredientIds.size} ingredients")
    public ValidatableResponse createWithAuth(String accessToken, List<String> ingredientIds) {
        String body = "{\"ingredients\":"+ingredientIds.toString()+"}";
        return given().header("Authorization", accessToken)
                .body(body).when().post(ORDERS).then();
    }

    @Step("Create order without auth and {ingredientIds.size} ingredients")
    public ValidatableResponse createNoAuth(List<String> ingredientIds) {
        String body = "{\"ingredients\":"+ingredientIds.toString()+"}";
        return given().body(body).when().post(ORDERS).then();
    }
}

