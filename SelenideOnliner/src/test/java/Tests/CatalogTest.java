package Tests;

import Elements.CatalogElements;
import Enums.CatalogEnum;
import Pages.CatalogPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;


public class CatalogTest {
    private CatalogElements catalogElements;
    private CatalogPage catalogPage;

    @BeforeEach
    public void openOnliner() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\test\\resources\\pr.properties"));
        } catch (IOException e) {
            System.out.println("Файл не найден!");
        }
        open(properties.getProperty("site"));
        catalogPage = new CatalogPage();


    }

 @ParameterizedTest
    @EnumSource()
    public void testCatalog(CatalogEnum item){
    catalogPage.openCatalog();
    catalogPage.chekCatalog(item);

    }



/*
    @Test
    public void testCatalog() {
        catalogPage.openCatalog();


        $(By.xpath("//snpan[@class=\"catalog-navigation-classifier__item-icon catalog-navigation-classifier__item-icon_id_1\"]/following-sibling::span/*")).shouldHave(text("Электроника"));
        $(By.xpath("//span[@class=\"catalog-navigation-classifier__item-icon catalog-navigation-classifier__item-icon_id_2\"]/following-sibling::span/*")).shouldHave(text("Компьютеры и сети"));



    }

    @Test
    public void testCatalog1() {
        catalogPage.openCatalog();
    //    $(By.xpath("//span[@class=\"catalog-navigation-classifier__item-icon catalog-navigation-classifier__item-icon_id_2\"]/following-sibling::span/*")).shouldHave(text("Компьютеры и сети"));
    }

    @Test
    public void testCatalog2() {
        catalogPage.openCatalog();
        $(By.xpath("//span[@class=\"catalog-navigation-classifier__item-icon catalog-navigation-classifier__item-icon_id_3\"]/following-sibling::span/*")).shouldHave(text("Бытовая техника"));
    }

    @Test
    public void testCatalog3() {
        catalogPage.openCatalog();
        $(By.xpath("//span[@class=\"catalog-navigation-classifier__item-icon catalog-navigation-classifier__item-icon_id_4\"]/following-sibling::span/*")).shouldHave(text("Стройка и ремонт"));
    }

    @Test
    public void testCatalog4() {
        catalogPage.openCatalog();
        $(By.xpath("//span[@class=\"catalog-navigation-classifier__item-icon catalog-navigation-classifier__item-icon_id_5\"]/following-sibling::span/*")).shouldHave(text("Дом1 и сад"));
    }

    @Test
    public void testCatalog5() {
        catalogPage.openCatalog();
        $(By.xpath("//span[@class=\"catalog-navigation-classifier__item-icon catalog-navigation-classifier__item-icon_id_6\"]/following-sibling::span/*")).shouldHave(text("Авто и мото"));
    }
    @Test
    public void testCatalog7() {
        catalogPage.openCatalog();
        $(By.xpath("//span[@class=\"catalog-navigation-classifier__item-icon catalog-navigation-classifier__item-icon_id_7\"]/following-sibling::span/*")).shouldHave(text("Красота и спорт"));
    }

    @Test
    public void testCatalog6() {
        catalogPage.openCatalog();
        $(By.xpath("//span[@class=\"catalog-navigation-classifier__item-icon catalog-navigation-classifier__item-icon_id_8\"]/following-sibling::span/*")).shouldHave(text("Детям1 и мамам"));
    }

    @Test
    public void testCatalog8() {
        catalogPage.openCatalog();
        $(By.xpath("//span[@class=\"catalog-navigation-classifier__item-icon catalog-navigation-classifier__item-icon_id_9\"]/following-sibling::span/*")).shouldHave(text("Работа и офис"));
    }

    @Test
    public void testCatalog9() {
        catalogPage.openCatalog();
        $(By.xpath("//span[@class=\"catalog-navigation-classifier__item-icon catalog-navigation-classifier__item-icon_id_16\"]/following-sibling::span/*")).shouldHave(text("Еда"));
    }
    */

    }