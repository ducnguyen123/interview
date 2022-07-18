package steps;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import java.io.File;

import static org.hamcrest.Matchers.*;

public class BookSteps {

    private final String BOOK_URI = "https://fakerestapi.azurewebsites.net/api/v1/Books";
    private Response response;

    @Step
    public void validateStatusCode(int statusCode) {
        response = RestAssured.when().get(BOOK_URI);
        response.then().assertThat().statusCode(statusCode);
    }

    public void getBook(int idBook) {
        response = RestAssured.when().get(BOOK_URI + "/" + idBook);
        response.then().assertThat().statusLine("HTTP/1.1 200 OK");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema/book.json")));
    }

    @Step
    public void searchBookTitleExist(String bookTitle) {
        response = RestAssured.when().get(BOOK_URI);
        response.then().assertThat()
                .body("title",hasItem(bookTitle));
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
    public void searchBookTitleNotExist(String bookTitle) {
        response = RestAssured.when().get(BOOK_URI);
        response.then()
                .body("title",not(hasItem(bookTitle)));
    }

    @Step
    public void sizeBooks(int size) {
        response = RestAssured.when().get(BOOK_URI);
        response.then().assertThat()
                .body("size()",is(size));
    }
}
