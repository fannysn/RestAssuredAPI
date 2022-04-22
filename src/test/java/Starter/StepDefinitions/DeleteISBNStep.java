package Starter.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import Starter.Books.DeleteISBN;

public class DeleteISBNStep {

    @Steps
    DeleteISBN deleteISBN;

    @Given("I set endpoint for delete isbn")
    public void iSetEndpointForDeleteIsbn() {
        deleteISBN.getEndpoint();
    }

    @When("I request delete isbn to user")
    public void iRequestDeleteIsbnToUser() throws Exception{
        deleteISBN.requestDelete();
    }

    @And("I validate the data detail for delete")
    public void iValidateTheDataDetailForDelete() {
        deleteISBN.validateDataDetail();
    }
}
