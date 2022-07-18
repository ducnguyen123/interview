package test;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.BookSteps;

@RunWith(SerenityRunner.class)
public class Book {

    @Steps
    BookSteps bookSteps;

    @Test
    public void verifyStatusCode() {
        bookSteps.validateStatusCode(200);
    }

    @Test
    public void verifyBookTitleExist() {
       bookSteps.searchBookTitleExist("Book 198");
    }

    @Test
    public void verifyBookTitleNotExist() {
//        bookResponse = RestAssured.when().get("https://fakerestapi.azurewebsites.net/api/v1/Books");
////        bookResponse.then().assertThat()
////                .body("title",Matchers.hasItem(Matchers.allOf(Matchers.hasEntry("title","Book 198"))));
//        JsonArray listBook = JsonParser.parseString(bookResponse.getBody().asString()).getAsJsonArray();
//        for(Object object : listBook) {
//            JsonObject bookObject = (JsonObject) object;
//            if(bookObject.get("title").getAsString().equals("Book 198"))
//                System.out.println(123);
//
//        }
    }

    @Test
    public void verifySizeBooks() {
        bookSteps.sizeBooks(200);
    }

    @Test
    public void test() {
        bookSteps.getBook(99);
    }
}
