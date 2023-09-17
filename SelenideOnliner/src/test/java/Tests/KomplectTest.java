package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class KomplectTest {
    //открыть пункт "Комплектующие". Проверить что в появившемся списке комплектующих все элементы содержат название, количество товаров и минимальную цену.


    @BeforeAll
    public static void openCatalog() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\test\\resources\\pr.properties"));
        } catch (IOException e) {
            System.out.println("Файл не найден!");
        }

        System.out.println(properties.getProperty("site"));
        open(properties.getProperty("site"));
        $(By.xpath("//span[@class=\"catalog-navigation-classifier__item-icon catalog-navigation-classifier__item-icon_id_2\"]/following-sibling::span/*")).click();
        $(byText("Комплектующие")).click();
    }


    @Test
    public void testElem(){
        Assertions.assertAll(
                () -> Assertions.assertFalse($(By.xpath("//a[@href=\"https://catalog.onliner.by/videocard\"]/*/span[@class=\"catalog-navigation-list__dropdown-title\"]")).getText().isEmpty()),
                () -> Assertions.assertFalse($(By.xpath("//a[@href=\"https://catalog.onliner.by/videocard\"]/*/span[@class=\"catalog-navigation-list__dropdown-description\"]")).getText().isEmpty())
                );
    }
}
