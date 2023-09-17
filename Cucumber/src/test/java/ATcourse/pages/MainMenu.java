package ATcourse.pages;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class MainMenu {
    private final String ITEM_PATTERN = "//span[contains(@class,'main-navigation') and contains(text(),'%s')]";
    private final By dropdown_menu = By.xpath("//div[contains(@class,'b-main-navigation__dropdown b-main-navigation__dropdown_visible')]");

    public void click_menu(String menu_name) {
        $(By.xpath(String.format(ITEM_PATTERN, menu_name))).click();
    }

    public void hover_menu(String menu_name) {
        $(By.xpath(String.format(ITEM_PATTERN, menu_name))).hover();
        $(dropdown_menu).shouldBe(Condition.visible);
    }
}
