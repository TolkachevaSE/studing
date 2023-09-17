package Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CompTest {
    //.открыть секцию каталога "Компьютеры и сети". Убедиться что появляется вертикальный список пунктов секции и присутствуют как минимум
    //пункты "Ноутбуки,компьютеры, мониторы","Комплектующие","Хранение данных","Сетевое оборудование".


    @BeforeAll
    public static void openCatalog() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\test\\resources\\pr.properties"));
        } catch (IOException e) {
            System.out.println("Файл не найден!");
        }
        open(properties.getProperty("site"));
        $(By.xpath("//span[@class=\"catalog-navigation-classifier__item-icon catalog-navigation-classifier__item-icon_id_2\"]/following-sibling::span/*")).click();

    }

    @Test
    public void testSpis() {
        $(By.xpath("//div[@class=\"catalog-navigation-list__aside-list\"]")).should(exist);
    }

    @Test
    public void testNout() {

        $(By.xpath("//div[@data-id=\"2\"]/div/*")).shouldHave(text("                    Ноутбуки, компьютеры, мониторы                "));
    }

    @Test
    public void testKomplect() {

        $(By.xpath("//div[@data-id=\"2\"]/div/*")).shouldHave(text("                    Комплектующие                "));
    }

    @Test
    public void testHraneDannih() {

        $(By.xpath("//div[@data-id=\"2\"]/div/*")).shouldHave(text("Хранение данных "));
    }

    @Test
    public void testSetevoeOborud() {

        $(By.xpath("//div[@data-id=\"2\"]/div/*")).shouldHave(text("Сетевое оборудование"));
    }


}
