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
                    R.drawable.image_shop_5,
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
                    "Sport",
                    4,
                    R.drawable.ic_shop_2,
                    R.drawable.image_shop_4,
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
                    "Video Games",
                    3,
                    R.drawable.ic_shop_1,
                    R.drawable.image_shop_1,
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
            return "{  \n" +
                    "   \"id\":\"2\",\n" +
                    "   \"phone\":\"8-906-142-43-54\",\n" +
                    "   \"sex\":\"m\",\n" +
                    "   \"name\":\"Alex\",\n" +
                    "   \"surname\":\" Perepechaev \",\n" +
                    "   \"patronymic\":\"Victorocich\",\n" +
                    "   \"city\":\"Rostov-on-Don\"\n" +
                    "}";
        }

        if (login.equals("3") && hash == "3".hashCode()) {
            return "{\n" +
                    "   \"id\":\"3\",\n" +
                    "   \"phone\":\"8-951-742-84-24\",\n" +
                    "   \"sex\":\"m\",\n" +
                    "   \"name\":\"Sergey\",\n" +
                    "   \"surname\":\" Butenko\",\n" +
                    "   \"patronymic\":\"Sergeevich\",\n" +
                    "   \"city\":\"Sochi\"\n" +
                    "}";
        }

        if (login.equals("4") && hash == "4".hashCode()) {
            return "{\n" +
                    "   \"id\":\"4\",\n" +
                    "   \"phone\":\"8-906-345-23-53\",\n" +
                    "   \"sex\":\"f\",\n" +
                    "   \"name\":\"Sveta \",\n" +
                    "   \"surname\":\"Farafonova\",\n" +
                    "   \"patronymic\":\"Andreevna\",\n" +
                    "   \"city\":\"Sochi\"\n" +
                    "}";
        }

        if (login.equals("5") && hash == "5".hashCode()) {
            return "{\n" +
                    "   \"id\":\"5\",\n" +
                    "   \"phone\":\"8-900-453-23-14\",\n" +
                    "   \"sex\":\"f\",\n" +
                    "   \"name\":\"Dariana\",\n" +
                    "   \"surname\":\"Dariana\",\n" +
                    "   \"patronymic\":\"Victorovna\",\n" +
                    "   \"city\":\"Rostov-on-Don\"\n" +
                    "}";
        }

        return null;
    }

    public static Coalition getCoalition() {
        return new Coalition(
                "Bestshops",
                "Spend your bonuses in any of our stores! We also have a lot of common discount programs.",
                new ArrayList<Shop>() {{
                    add(getShopList().get(1));
                    add(getShopList().get(2));
                }},
                R.drawable.ic_shop_3,
                R.drawable.image_shop_3,
                13,
                "24%"
        );
    }

    public static List<Coupon> getCoupons() {
        return new ArrayList<Coupon>() {{
            add(new Coupon(
                    "\"Asian food\"",
                    "Cafe",
                    "При покупке 2-ух кофе получите 3 бесплатно",
                    R.drawable.ic_qr_coupon_1,
                    R.drawable.image_shop_5
            ));
            add(new Coupon(
                    "\"Asian food\"",
                    "Cafe",
                    "При покупке 2-ух кофе получите 3 бесплатно",
                    R.drawable.ic_qr_coupon_2,
                    R.drawable.image_shop_5
            ));
            add(new Coupon(
                    "\"Asian food\"",
                    "Cafe",
                    "При покупке 2-ух кофе получите 3 бесплатно",
                    R.drawable.ic_qr_coupon_3,
                    R.drawable.image_shop_5
            ));
        }};
    }
}
