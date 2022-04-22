package Starter.Books;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.RestRequests.when;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class PostAddISBN {

    String base_url = "https://demoqa.com/BookStore/v1/Books";
    String token, isbn, userId;

    public String getEndpoint(){
        return base_url;
    }

    public JSONObject bodyAddIsbn() throws IOException {
        this.isbn = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//file_JSON//isbn.json"), StandardCharsets.UTF_8);
        this.userId = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//file_JSON//UserID.json"), StandardCharsets.UTF_8);

        JSONObject body = new JSONObject();
        body.put("userId", userId);

        HashMap<String, String> book = new HashMap<>();
        book.put("isbn", isbn);

        List<HashMap<String, String>> collection = new ArrayList<>();
        collection.add(book);
        body.put("collectionOfISBN", collection);

        return body;
    }

    public void requestAddIsbn() throws IOException {
        this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//file_JSON//token.json"), StandardCharsets.UTF_8);

        given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + this.token)
                .body(bodyAddIsbn().toJSONString());
        when().post(getEndpoint());
    }

    public void validateStatusCode(int code){
        then().statusCode(equalTo(code));
    }

    public void validateDataDetail(){
        then().body("Books[0].isbn", equalTo(this.isbn));
    }
}