package Elements;

import Enums.CatalogEnum;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CatalogElements {

    private static final String ITEM_PATTERN = "//span[@class=\"catalog-navigation-classifier__item-icon catalog-navigation-classifier__item-icon_id_%d\"]/following-sibling::span/*";


    public void clickOnItem(CatalogEnum item) {
        $(By.xpath(String.format(ITEM_PATTERN, item.getId()))).click();
    }

    public SelenideElement getCatalogElement(CatalogEnum item) {
        return $(By.xpath(String.format(ITEM_PATTERN, item.getId())));
    }


}
