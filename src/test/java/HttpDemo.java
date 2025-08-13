import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import com.jayway.jsonpath.*;

import io.restassured.response.Response;


public class HttpDemo {
	
	@Test
	void getReq() {
		
		
	Response response =	given()
		.when()
			.get("https://fakestoreapi.com/products")
		.then()
			.extract().response();
	
	 List<String> title = response.jsonPath().getList("title");
	
	 System.out.println(title);
		
		
	}

}
