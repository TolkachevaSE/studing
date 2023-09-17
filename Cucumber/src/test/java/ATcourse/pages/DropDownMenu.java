package ATcourse.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;

public class DropDownMenu {

    private String ITEM_PATTERN =
         "//span[contains(@class,'navigation__dropdown-advert-sign') and contains(text(),'%s')]";

    public boolean menuDisplayed(String name) {
        ElementsCollection elements = $$x(String.format(ITEM_PATTERN,name));
        if(elements.isEmpty()){
            return false;
        }

       for(SelenideElement element:elements){
        if(element.isDisplayed()) {
            return true;}
       }
       return false;
           }
}
