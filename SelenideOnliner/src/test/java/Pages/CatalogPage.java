package Pages;

import Elements.CatalogElements;
import Enums.CatalogEnum;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {

    public CatalogElements catElement = new CatalogElements();
    private static final String CATALOG = "//span[@class=\"b-main-navigation__text\" and text()=\"Каталог\"]";

    public void openCatalog() {
        $(By.xpath(CATALOG)).click();
    }

    public void chekCatalog(CatalogEnum item){
        catElement.getCatalogElement(item).shouldHave(text(item.getValue()));
    }
}
