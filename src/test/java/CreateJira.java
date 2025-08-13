import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import com.jayway.jsonpath.*;

import io.restassured.response.Response;


public class CreateJira {
	
	@Test
	public void JiraCreate() {
	Response response =	given().header("Content-Type", "application/json")
		.header("Authorization","Basic c2F0eWFuYW5kYW0ua29tZXJhQGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBfd3RNd1RKTWZMb2lwcVVBeGdyMWVXX3JzMnJjUW1uT2lzNDBiRE5lMDRfa2h3WkRwelNzVlRrczlvZ1FSVHRoSWlOZkJtcm5XdzBlTjdRS2J2ZzZWdUY0MDh1MGxiY0VnUE5jVFZGYjQwWS13TnVQX2FvZFlrRTZQclJVcldPQWxhRllJSER0dGRzRkdmX25Mc3d3TVppS21qRjA5RC1CX0FFaXN3TEJZajA9OEFGREY2OTc=")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"TEST\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"Automationq12233 Creating Bug.\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}\r\n"
				+ "")
		.m
		.when().post("https://satyanandamkomera.atlassian.net/rest/api/3/issue")
		.then().assertThat().statusCode(201).extract().response();
	
	
	String key = response.jsonPath().getString("key");
	
	Assert.assertEquals(key,"TEST-4 ");
	
	}

}
