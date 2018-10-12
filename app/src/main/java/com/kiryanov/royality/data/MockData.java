package com.kiryanov.royality.data;

import com.kiryanov.royality.R;

import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static List<Shop> getShopList() {
        return new ArrayList<Shop>() {{
            add(new Shop(
                    "Asia food",
                    "Rostov-on-Don",
                    "77 Voroshilovsky prospect",
                    "+79880000000",
                    new Coordinate(47.224758, 39.717388),
                    "Shop oriental sweets. Sweets from Asia, a wide variety of flavors. Various teas and coffees are available. Delivery around the city is free.",
                    "10%",
                    new Category("Eat", R.drawable.ic_menu_manage),
                    "Cafe",
                    5,
                    R.drawable.ic_shop_4,
                    125
            ));

            add(new Shop(
                    "Sport Town",
                    "Rostov-on-Don",
                    "246 Tekucheva street",
                    "+79880000010",
                    new Coordinate(47.234650, 39.705992),
                    "We sell sporting goods of the best brands of Europe. The store has numerous discount and bonus programs.",
                    "15%",
                    new Category("Sport", R.drawable.ic_home_black),
                    "-",
                    4,
                    R.drawable.ic_shop_2,
                    12
            ));

            add(new Shop(
                    "Space Games",
                    "Rostov-on-Don",
                    "234 Tekucheva street",
                    "+79880000011",
                    new Coordinate(47.234009, 39.702984),
                    "The newest virtual reality attraction is waiting for you. Plunge into the world of space battles!",
                    "25%",
                    new Category("Game", R.drawable.ic_debit_card),
                    "-",
                    3,
                    R.drawable.ic_shop_1,
                    51321
            ));
        }};
    }

    public static String getUser(String login, int hash) {
        if (login.equals("1") && hash == "1".hashCode()) {
            return "{\n" +
                    "        \"id\":1,\n" +
                    "        \"phone\":\"8-909-400-92-91\",\n" +
                    "        \"sex\":\"m\",\n" +
                    "        \"name\":\"Evgeniy\",\n" +
                    "        \"surname\":\"Kiryanov\",\n" +
                    "        \"patronymic\":\"Nikolaevich\",\n" +
                    "\t\"city\":\"Salsk\"\n" +
                    "}";
        }

        if (login.equals("2") && hash == "2".hashCode()) {
            return "{\n" +
                    "        \"id\":2,\n" +
                    "        \"phone\":\"8-999-444-92-91\",\n" +
                    "        \"sex\":\"m\",\n" +
                    "        \"name\":\"Михаил\",\n" +
                    "        \"surname\":\"Фамилия\",\n" +
                    "        \"patronymic\":\"Отчество\",\n" +
                    "\t\"city\":\"Rostov\"\n" +
                    "}";
        }

        return null;
    }
}