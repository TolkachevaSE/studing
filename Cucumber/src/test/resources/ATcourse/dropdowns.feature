Feature: Testing the dropdowns for auto and flat
@auto
Scenario Outline: Opening the auto menu
   Given The site "https://onliner.by" is open
   When  The cursor is on the auto menu
   Then  The dropdown menu has appeared that displays "<categories_for_auto>" - division by price, by city and brand

  Examples:
    |categories_for_auto |
    |Авто до 4000 р.     |
    |Авто до 10 000 р.   |
    |Минск               |
    |Брест               |
    |Citroen             |
    |Mercedes-Benz       |



@flat
Scenario: Opening the flat menu
   Given The site "https://onliner.by" is open
   When  The cursor hovers the flat menu
   Then  The dropdown menu has appeared that displays categories - cities, number of rooms, price range



