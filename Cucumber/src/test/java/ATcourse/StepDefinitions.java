package ATcourse;

import ATcourse.pages.DropDownMenu;
import ATcourse.pages.MainMenu;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.open;

public class StepDefinitions {

    MainMenu mainMenu = new MainMenu();
    DropDownMenu dropDownMenu = new DropDownMenu();


    @Given("The site {string} is open")
    public void the_site_is_open(String url) {
        open(url);
    }

    @When("The cursor is on the auto menu")
    public void the_cursor_is_on_the_auto_menu() {
        mainMenu.hover_menu("Автобарахолка");
    }

    @Then("The dropdown menu has appeared that displays {string} - division by price, by city and brand")
    public void dropdownAutoMenuTest(String string) {
        Assert.assertTrue("Can't find "+string,dropDownMenu.menuDisplayed(string));
    }

    @When("The cursor hovers the flat menu")
    public void the_cursor_hovers_the_flat_menu() {
        mainMenu.hover_menu("Дома и квартиры");
    }


    @Then("The dropdown menu has appeared that displays categories - cities, number of rooms, price range")
    public void dropdownFlatMenuTest() {

       Assert.assertTrue("Can't find category Prices",dropDownMenu.menuDisplayed("До 30 000 $"));
       Assert.assertTrue("Can't find category Number of rooms",dropDownMenu.menuDisplayed("1-комнатные"));
       Assert.assertTrue("Can't find category City",dropDownMenu.menuDisplayed("Минск"));
       Assert.assertTrue("Can't find category City",dropDownMenu.menuDisplayed("Витебск"));
       Assert.assertTrue("Can't find category Number of rooms",dropDownMenu.menuDisplayed("4+-комнатные"));
    }
    }



