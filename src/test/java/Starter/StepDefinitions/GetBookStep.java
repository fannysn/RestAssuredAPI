package Starter.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import Starter.Books.GetListBook;
import Starter.UserAccount.Post;
import Starter.UserAccount.PostGenerateToken;

public class GetBookStep {

    @Steps
    GetListBook getListBook;

    @Steps
    PostGenerateToken postGenerateToken;

    @Steps
    Post post;

    @Given("I set endpoint for get list book")
    public void iSetEndpointForGetListBook() {
        getListBook.getEndpoint();
    }

    @When("I request get list book")
    public void iRequestGetListBook() {
        getListBook.requestGetListBook();
    }

    @Then("I verify status code is {int}")
    public void iVerifyStatusCodeIs(int code) {
        getListBook.verifyStatusCode(code);
    }

    @And("get isbn data for other request")
    public void getIsbnDataForOtherRequest() {
        getListBook.getIsbn();
    }

    @Given("I am doing login")
    public void iAmDoingLogin() throws Exception{
        post.requestPostDetailUser("new", "Password12345!");
        post.getUserId();
        postGenerateToken.requestPostGenerateToken();
        postGenerateToken.validateDataDetailGenerateToken();
        postGenerateToken.getToken();
    }
}
