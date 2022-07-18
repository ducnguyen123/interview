package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import net.thucydides.core.annotations.Steps;
import steps.BookSteps;

import java.util.List;

public class BookStepDefinitions {

    @Steps
    BookSteps bookSteps;

    @Given("Test API feature")
    public void testAPIfeature() {

    }

    @Then("Verify status code {int}")
    public void verifyStatusCode(int statusCode) {
        bookSteps.validateStatusCode(statusCode);
    }

    @And("Check the book exist {string}")
    public void checkBookExist(String bookTitle) {
        bookSteps.searchBookTitleExist(bookTitle);
    }

    @And("Check the book not exist {string}")
    public void checkBookNotExist(String bookTitle) {
        bookSteps.searchBookTitleNotExist(bookTitle);
    }

    @And("Verify total size of book {int}")
    public void verifyTotalSizeOfBook(int size) {
        bookSteps.sizeBooks(size);
    }

    @When("Get Book")
    public void getBook(DataTable listBook) {
        List<String> rows = listBook.asList(String.class);
        for (String book : rows) {
            bookSteps.getBook(Integer.parseInt(book));
        }
    }
}
