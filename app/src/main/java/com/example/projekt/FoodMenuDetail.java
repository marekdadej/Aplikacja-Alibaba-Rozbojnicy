package com.example.projekt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodMenuDetail extends AppCompatActivity {

    private TextView selectedItemText;
    private RecyclerView recyclerView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu_detail);

        selectedItemText = findViewById(R.id.selectedItemText);
        recyclerView = findViewById(R.id.recyclerView);
        backButton = findViewById(R.id.backButton);
        TextView sizeInfoText = findViewById(R.id.sizeInfoText);

        String categoryName = getIntent().getStringExtra("category_name");

        ArrayList<Food> foodList = new ArrayList<>();
        switch (categoryName) {
            case "Kebab":
                foodList = getKebabList();
                sizeInfoText.setText(getKebabSizeInfo());
                break;
            case "Talerz":
                foodList = getPlateList();
                sizeInfoText.setText(getPlateSizeInfo());
                break;
            case "Sałatki":
                foodList = getSaladList();
                sizeInfoText.setText(getSaladSizeInfo());
                break;
            case "Desery":
                foodList = getDessertList();
                sizeInfoText.setText(getDessertSizeInfo());
                break;
            case "Napoje":
                foodList = getDrinkList();
                sizeInfoText.setText(getDrinkSizeInfo());
                break;
        }

        if (categoryName != null) {
            selectedItemText.setText(categoryName);
        }

        if (foodList != null) {
            FoodDetailAdapter adapter = new FoodDetailAdapter(foodList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }

        backButton.setOnClickListener(v -> finish());
    }

    public static ArrayList<Food> getAllDishes() {
        ArrayList<Food> allDishes = new ArrayList<>();
        allDishes.addAll(getKebabList());
        allDishes.addAll(getPlateList());
        allDishes.addAll(getSaladList());
        return allDishes;
    }

    public static ArrayList<Food> getAllDesserts() {
        return getDessertList();
    }

    public static ArrayList<Food> getAllDrinks() {
        return getDrinkList();
    }


    static ArrayList<Food> getKebabList() {
        ArrayList<Food> kebabList = new ArrayList<>();
        kebabList.add(new Food("🥙 Piękna klasyka", "Mięsko: drobiowe, wołowe, baranie lub mieszane\nChlebek: pita, tortilla lub buła\nAutorska kompozyjka warzyw\nSosiowo do wyboru do koloru bracie", "18 | 21 | 28 | 38"));
        kebabList.add(new Food("🥙 Serowy potwór", "Mięsko: drobiowe, wołowe, baranie lub mieszane\nChlebek: pita, tortilla lub buła\nAutorska kompozyjca warzyw\nSosiowo do wyboru do koloru bracie\nSerek: mozarella, chedar lub halloumi", "20 | 23 | 30 | 40"));
        kebabList.add(new Food("🥙 Jankes", "Mięsko: drobiowe, wołowe, baranie lub mieszane\nChlebek: pita, tortilla lub buła\nAutorska kompozyjca warzyw\nSosiowo do wyboru do koloru bracie\nFryty: belgijskie lub z batatów", "20 | 23 | 30 | 40"));
        kebabList.add(new Food("🥙 Prawdziwy chłop", "Mięsko: drobiowe, wołowe, baranie lub mieszane\nChlebek: pita, tortilla lub buła\nSosiowo do wyboru do koloru bracie\nPodwójne mięsko", "23 | 26 | 33 | 43"));
        kebabList.add(new Food("🥙 🌶 Świat w ogniu", "Mięsko: drobiowe, wołowe, baranie lub mieszane\nChlebek: pita, tortilla lub buła\nSosiowo: tabasco lub chilli\nPapryka: jalapeno, habanero lub chilli", "21 | 24 | 31 | 41"));
        kebabList.add(new Food("🌱 Vege", "Mięsko: seitan, kotlety sojowe, falafel lub tofu\nChlebek: pita, tortilla lub buła\nAutorska kompozyjca warzyw\nSosiowo do wyboru do koloru bracie", "16 | 19 | 26 | 36"));
        return kebabList;
    }

    private String getKebabSizeInfo() {
        return "Wybierz mądrze szefie! \n" +
                "Mikrus (Mały): 20 cm \n" +
                "Kompakt (Średni): 30 cm \n" +
                "Moloch (Duży): 40 cm \n" +
                "Tytan (XXL): 60 cm \n";
    }

    static ArrayList<Food> getPlateList() {
        ArrayList<Food> plateList = new ArrayList<>();
        plateList.add(new Food("🥙 Box", "Mięsko: drobiowe, wołowe, baranie lub mieszane\nAutorska kompozyjca warzyw\nSosiowo do wyboru do koloru bracie", "18 | 22"));
        plateList.add(new Food("🥙 Piękna klasyka", "Mięsko: drobiowe, wołowe, baranie lub mieszane\nAutorska kompozyjca warzyw\nSosiowo do wyboru do koloru bracie", "21 | 25"));
        plateList.add(new Food("🥙 Serowy potwór", "Mięsko: drobiowe, wołowe, baranie lub mieszane\nAutorska kompozyjca warzyw\nSosiowo do wyboru do koloru bracie\nSerek: mozarella, chedar lub halloumi", "23 | 27"));
        plateList.add(new Food("🥙 Jankes", "Mięsko: drobiowe, wołowe, baranie lub mieszane\nAutorska kompozyjca warzyw\nSosiowo do wyboru do koloru bracie\nFryty: belgijskie lub z batatów", "23 | 27"));
        plateList.add(new Food("🥙 Prawdziwy chłop", "Mięsko: drobiowe, wołowe, baranie lub mieszane\nSosiowo do wyboru do koloru bracie\nPodwójne mięsko", "26 | 30"));
        plateList.add(new Food("🥙 🌶 Świat w ogniu", "Mięsko: drobiowe, wołowe, baranie lub mieszane\nSosiowo: tabasco lub chilli\nPapryka: jalapeno, habanero lub chilli", "24 | 28"));
        plateList.add(new Food("🥙 Dla dzieci", "Stripsy: 4 szt. | 6 szt.\nFryty: belgijskie lub z batatów\nSosiwo: ketchup, czosnkowy lub jogurtowy", "20 | 25"));
        plateList.add(new Food("🌱 Vege", "Mięsko: seitan, kotlety sojowe, falafel lub tofu\nAutorska kompozyjca warzyw\nSosiowo do wyboru do koloru bracie", "19 | 23"));
        return plateList;
    }

    private String getPlateSizeInfo() {
        return "Wybierz mądrze szefie! \n" +
                "Talerzyk Mały 150g \n" +
                "Talerzyk Duży 350g";
    }

    static ArrayList<Food> getSaladList() {
        ArrayList<Food> saladList = new ArrayList<>();
        saladList.add(new Food("🌱 Sałatka grecka", "Składniki: kawałki ogórka, pomidora, czerwonej cebuli, oliwek, sera feta\nDressing: oliwa z oliwek, cytryna, bazylia i oregano", "18"));
        saladList.add(new Food("🌱 Sałatka z kuskusem", "Składniki: kuskus, grillowane warzywa: cukinia, papryka, bakłażan, świeże zioła, orzechy: pistacje, migdały\nDressing: sok z cytryny, oliwa z oliwek", "19"));
        saladList.add(new Food("🌱 Sałatka z falafelem", "Składniki: liście sałaty, pomidor, czerwona cebula, kawałki ogórka, kuleczki falafela, hummus, oliwki\nDressing: tahini", "20"));
        saladList.add(new Food("🌱 Sałatka colesław", "Składniki: biała kapusta, marchewka, majonez, kwaśna śmietana lub jogurt, ocet jabłkowy, przyprawy", "17"));
        saladList.add(new Food("🌱 Sałatka caprese", "Składniki: plasterki pomidora, plastry mozzarelli, świeże liście bazylii, oliwki\nDressing: oliwa z oliwek i ocet balsamiczny", "21"));
        saladList.add(new Food("🌱 Sałatka z awokado i mango", "Składniki: plasterki awokado, pokrojone mango, mieszanki sałat, czerwony grejpfrut\nDressing: oliwa z oliwek, sok z cytryny, miód", "22"));
        return saladList;
    }

    private String getSaladSizeInfo() {
        return "Jeden rozmiar!";
    }

    static ArrayList<Food> getDessertList() {
        ArrayList<Food> dessertList = new ArrayList<>();
        dessertList.add(new Food("Baklawa", "Klasyczny bliskowschodni deser składający się z warstw chrupiącego ciasta filo lub yufki, orzechów i syropu", "10"));
        dessertList.add(new Food("Halva", "Popularny deser bliskowschodni, halva, wykonana z sezamu lub pasty z orzechów, jest słodka i bogata w smaku", "11"));
        dessertList.add(new Food("Lokum", "Inaczej znane jako turecki rahat lokum, to delikatne, żelowe słodycze o różnych smakach, często posypane cukrem pudrem lub kokosem", "12"));
        dessertList.add(new Food("Sernik", "Klasyk wśród deserów, sernik może być świetnym wyborem dla kebabowni, szczególnie jeśli oferują różne smaki, takie jak tradycyjny, czekoladowy czy owocowy", "9"));
        dessertList.add(new Food("Babeczki", "Małe babeczki w różnych smakach: waniliowe, czekoladowe, marchewkowe (3 szt.)", "13"));
        dessertList.add(new Food("Sorbet", "Świeży i orzeźwiający sorbet owocowy: truskawkowy, cytrynowy, malinowy", "10"));
        return dessertList;
    }

    private String getDessertSizeInfo() {
        return "Jeden rozmiar!";
    }

    static ArrayList<Food> getDrinkList() {
        ArrayList<Food> drinkList = new ArrayList<>();

        drinkList.add(new Food("🍹 Koktajl owocowy", "Z mixu świeżych owoców: truskawki, banany, mango, ananas, maliny", "15"));
        drinkList.add(new Food("🧃 Sok pomarańczowy", "Świeżo wyciskany sok z pomarańczy", "10"));
        drinkList.add(new Food("🍉 Sok arbuzowy", "Orzeźwiający sok ze świeżego arbuza", "11"));
        drinkList.add(new Food("🍎 Sok jabłkowy", "Naturalny sok z jabłek, lekko słodki", "9"));
        drinkList.add(new Food("🍍 Sok ananasowy", "Świeży sok z ananasa, naturalnie słodki", "10"));
        drinkList.add(new Food("🍑 Sok brzoskwiniowy", "Delikatny sok z brzoskwiń, orzeźwiający i słodki", "9"));
        drinkList.add(new Food("🍊 Sok grejpfrutowy", "Orzeźwiający sok z grejpfrutów", "10"));
        drinkList.add(new Food("🥥 Smoothie", "Smoothie z jogurtem i owocami: truskawki, banan, jagody", "14"));
        drinkList.add(new Food("🍓 Koktajl jagodowy", "Koktajl z jagodami, bananem i mlekiem", "13"));
        drinkList.add(new Food("🍓 Smoothie truskawkowe", "Smoothie z truskawkami, jogurtem i miodem", "12"));
        drinkList.add(new Food("🥤 Cola", "Popularny napój gazowany", "7"));
        drinkList.add(new Food("🍹 Mirinda", "Orzeźwiający napój gazowany o smaku pomarańczowym", "6"));
        drinkList.add(new Food("🥤 Sprite", "Napój gazowany o smaku cytrusowym", "6"));
        drinkList.add(new Food("🍵 Herbata", "Wybór herbat: czarna, zielona, owocowa", "6"));
        drinkList.add(new Food("🍑 Fuzetea brzoskwiniowa", "Herbatka mrożona z brzoskwiniowym smakiem", "7"));
        drinkList.add(new Food("🍓 Fuzetea cytrynowa", "Herbatka mrożona o smaku cytrynowym", "7"));
        drinkList.add(new Food("🍷 Nestea", "Herbatka mrożona, różne smaki, np. brzoskwiniowy, cytrynowy", "6"));
        drinkList.add(new Food("🥤 Woda mineralna", "Woda gazowana lub niegazowana", "5"));
        drinkList.add(new Food("🥤 Woda kokosowa", "Orzeźwiająca woda kokosowa, naturalnie słodka", "9"));
        drinkList.add(new Food("🍓 Woda z jagodami", "Woda mineralna z dodatkiem świeżych jagód", "6"));
        drinkList.add(new Food("🍈 Woda z melonem", "Woda z dodatkiem świeżego melona, lekko słodka", "8"));
        drinkList.add(new Food("🥛 Mleko", "Świeże mleko pełnotłuste lub 2%", "4"));
        return drinkList;
    }



    private String getDrinkSizeInfo() {
        return "Ceny za 500ml";
    }

}

