package Enums;

public enum CatalogEnum {

    Electro("Электроника",1), Comp("Компьютеры и сети",2),Tehn("Бытовая техника",3),
    Stroj("Стройка и&nbsp;ремонт",4),  Dom("Дом и сад",5), Avto("Авто и мото",6),
    Krasota("Красота и спорт",7), Kids("Детям и мамам",8), Work("Работа и офис",9),
    Eda("Еда",16);

    private String value;
    private int id;

    CatalogEnum(String value, int id){
        this.value=value;
        this.id=id;}

    public String getValue() {
        return value;
    }
    
    public int getId() {return id;}
}
