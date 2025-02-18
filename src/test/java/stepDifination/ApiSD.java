package stepDifination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiSD {

	private Response response;

	@Given("baseurl")
	public void baseurl() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2/store";
	}

	@When("user send endpath {string}")
	public void user_send_endpath(String endpoint) {
		RestAssured.basePath = endpoint;
	}

	@When("user send a GET request")
	public void user_send_a_get_request() {
		response = RestAssured.get().then().extract().response();
		System.out.println(response.asString());
	}

	@Then("the  status code should be {int}")
	public void the_status_code_should_be(int value) {
		response.then().statusCode(value);
	}

	@Then("the response should contain {string}")
	public void the_response_should_contain(String key) {
		String jsonstring = response.asString();
		System.out.println(jsonstring);
		if (jsonstring.contains(key)) {
			System.out.println("The value " + key + " is present");
		} else {
			System.out.println("The value " + key + " is not present");
		}
	}

	@When("user send a POST request")
	public void user_send_a_post_request() {
		String json = "{\r\n" + "  \"id\": 0,\r\n" + "  \"petId\": 0,\r\n" + "  \"quantity\": 0,\r\n"
				+ "  \"shipDate\": \"2025-02-15T10:11:23.269Z\",\r\n" + "  \"status\": \"placed\",\r\n"
				+ "  \"complete\": true\r\n" + "}";

		response = RestAssured.given().header("Content-Type", "application/json").body(json).post().then().extract()
				.response();
		System.out.println(response.asString());
	}

	@When("user send a GET request {int}")
	public void user_send_a_get_request(int id) {

		response = RestAssured.given().formParam("orderId", id).get().then().extract().response();
		System.out.println(response.asString());
	}

	@When("user send a DELETE request with id  {int}")
	public void user_send_a_delete_request_with_id(int id) {
		response = RestAssured.given().formParam("orderId", id).delete().then().extract().response();
		System.out.println(response.asString());
	}
}
