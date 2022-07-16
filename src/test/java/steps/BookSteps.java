package steps;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

public class BookSteps {

    private final String BOOK_URI = "https://fakerestapi.azurewebsites.net/api/v1/Books";
    private Response response;

    @Step
    public void validateStatusCode(int statusCode) {
        response = RestAssured.when().get(BOOK_URI);
        response.then().statusCode(statusCode);
    }

    @Step
    public void searchBookTitleExist(String bookTitle) {
        response = RestAssured.when().get(BOOK_URI);
        response.then().assertThat()
                .body("title", Matchers.hasItem(bookTitle));
//        String numberBook = bookTitle.split(" ")[1];
//        JsonArray listBook = JsonParser.parseString(response.getBody().asString()).getAsJsonArray();
//        if(!(listBook.size() < Integer.parseInt(numberBook))) {
//            for(Object object : listBook) {
//                JsonObject bookObject = (JsonObject) object;
//                if(bookObject.get("title").getAsString().equals(bookTitle))
//                    System.out.println(123);
//
//            }
//        }
    }

    @Step
    public void sizeBooks(int size) {
        response = RestAssured.when().get(BOOK_URI);
        response.then().assertThat()
                .body("size()",Matchers.is(size));
    }
}
