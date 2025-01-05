package com.example.projekt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DrinkMenuDetail extends AppCompatActivity {

    private TextView DrinkSelectedItemText;
    private RecyclerView DrinkRecyclerView;
    private Button DrinkBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_menu_detail);

        DrinkSelectedItemText = findViewById(R.id.DrinkSelectedItemText);
        DrinkRecyclerView = findViewById(R.id.DrinkRecyclerView);
        DrinkBackButton = findViewById(R.id.DrinkBackButton);
        TextView DrinkSizeInfoText = findViewById(R.id.DrinkSizeInfoText);

        String categoryName = getIntent().getStringExtra("category_name");

        ArrayList<Alko> alkoList = new ArrayList<>();
        switch (categoryName) {
            case "Piwo":
                alkoList = getPiwoList();
                DrinkSizeInfoText.setText(getPiwoSizeInfo());
                break;
            case "Wódka":
                alkoList = getWodkaList();
                DrinkSizeInfoText.setText(getWodkaSizeInfo());
                break;
            case "Whisky":
                alkoList = getWhiskyList();
                DrinkSizeInfoText.setText(getWhiskySizeInfo());
                break;
            case "Wino":
                alkoList = getWinoList();
                DrinkSizeInfoText.setText(getWinoSizeInfo());
                break;
            case "Drinki":
                alkoList = getDrinkiList();
                DrinkSizeInfoText.setText(getDrinkiSizeInfo());
                break;
            case "Rum":
                alkoList = getRumList();
                DrinkSizeInfoText.setText(getRumSizeInfo());
                break;
            case "Gin":
                alkoList = getGinList();
                DrinkSizeInfoText.setText(getGinSizeInfo());
                break;
            case "Tequila":
                alkoList = getTequilaList();
                DrinkSizeInfoText.setText(getTequilaSizeInfo());
                break;
            case "Likiery i inne":
                alkoList = getLikieryList();
                DrinkSizeInfoText.setText(getLikierySizeInfo());
                break;
        }

        if (categoryName != null) {
            DrinkSelectedItemText.setText(categoryName);
        }

        if (alkoList != null) {
            DrinkDetailAdapter adapter = new DrinkDetailAdapter(alkoList);
            DrinkRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            DrinkRecyclerView.setAdapter(adapter);
        }

        DrinkBackButton.setOnClickListener(v -> finish());
    }

    public static ArrayList<Alko> getAllDrink() {
        ArrayList<Alko> allDrink = new ArrayList<>();
        allDrink.addAll(getPiwoList());
        allDrink.addAll(getWodkaList());
        allDrink.addAll(getWhiskyList());
        allDrink.addAll(getWinoList());
        allDrink.addAll(getDrinkiList());
        allDrink.addAll(getRumList());
        allDrink.addAll(getGinList());
        allDrink.addAll(getTequilaList());
        allDrink.addAll(getLikieryList());
        return allDrink;
    }

    private static ArrayList<Alko> getPiwoList() {
        ArrayList<Alko> alkoList = new ArrayList<>();
        alkoList.add(new Alko("Perła Chmielowa", "", "7 | 9 | 12 | 20"));
        alkoList.add(new Alko("Zwierzyniec Plis", "", "8 | 10 | 13 | 21"));
        alkoList.add(new Alko("Żywiec", "", "7 | 9 | 12 | 20"));
        alkoList.add(new Alko("Żywiec Biały", "", "7 | 9 | 12 | 20"));
        alkoList.add(new Alko("Żywiec IPA", "", "8 | 10 | 13 | 21"));
        alkoList.add(new Alko("Corona Extra", "", "9 | 11 | 14 | 22"));
        alkoList.add(new Alko("Heineken", "", "9 | 11 | 14 | 22"));
        alkoList.add(new Alko("Carlsberg", "", "9 | 11 | 14 | 22"));
        alkoList.add(new Alko("Książęce (wszystkie rodzaje)", "", "9 | 11 | 14 | 22"));
        alkoList.add(new Alko("Heindeken 0%", "", "9 | 11 | 14 | 22"));
        alkoList.add(new Alko("Żywiec Biały 0%", "", "7 | 9 | 12 | 20"));
        return alkoList;
    }

    private String getPiwoSizeInfo() {
        return "Wybierz mądrze szefie! \n" +
                "Kierowca( małe): 330ml \n" +
                "Początek (Średnie): 500ml \n" +
                "Pijak (Duży): 850ml \n" +
                "Zespołowiec (Dzbanek): 1.5l \n";
    }

    private static ArrayList<Alko> getWodkaList() {
        ArrayList<Alko> alkoList = new ArrayList<>();
        alkoList.add(new Alko("Żołądkowa", "", "10 | 100 | 120 | 230"));
        alkoList.add(new Alko("Stock", "", "10 | 100 | 120 | 230"));
        alkoList.add(new Alko("Chopin", "", "12 | 120 | 160 | 300"));
        alkoList.add(new Alko("Bocian", "", "12 | 120 | 160 | 300"));
        alkoList.add(new Alko("Finlandia", "", "12 | 120 | 160 | 300"));
        alkoList.add(new Alko("Belvedere", "", "30 | 300 | 350 | 600"));
        return alkoList;
    }

    private String getWodkaSizeInfo() {
        return "Wybierz mądrze szefie! \n" +
                "Kierowca (małe): 40ml \n" +
                "Początek (Średnie): 500ml \n" +
                "Pijak (Duży): 700ml \n" +
                "Zespołowiec (Dzbanek): 1.5l \n";
    }

    private static ArrayList<Alko> getWhiskyList() {
        ArrayList<Alko> alkoList = new ArrayList<>();
        alkoList.add(new Alko("Johny Wallker Red", "", "15 | 150 | 180 | 320"));
        alkoList.add(new Alko("Jack Daniel's", "", "20 | 170 | 200 | 400"));
        alkoList.add(new Alko("Bushmills", "", "15 | 150 | 180 | 320"));
        alkoList.add(new Alko("Monkey Shoulder", "", "25 | 190 | 230 | 450"));
        alkoList.add(new Alko("Ballantine's", "", "20 | 170 | 200 | 400"));
        alkoList.add(new Alko("Glenfiddich 12 years", "", "30 | 300 | 350 | 600"));
        return alkoList;
    }

    private String getWhiskySizeInfo() {
        return "Wybierz mądrze szefie! \n" +
                "Kierowca (małe): 40ml \n" +
                "Początek (Średnie): 500ml \n" +
                "Pijak (Duży): 700ml \n" +
                "Zespołowiec (Dzbanek): 1.5l \n";
    }

    private static ArrayList<Alko> getWinoList() {
        ArrayList<Alko> alkoList = new ArrayList<>();
        alkoList.add(new Alko("Piper-Heidsieck Brut", "", "30 | 300 | 350 | 450"));
        alkoList.add(new Alko("Maschio Prosecco Treviso Doc", "", "23 | 75 | 95 | 130"));
        alkoList.add(new Alko("Frizzante", "", "15 | 40 | 60 | 80"));
        alkoList.add(new Alko("Białe półwytrawne", "", "12 | 35 | 55 | 70"));
        alkoList.add(new Alko("Czerwone półwytrawne", "", "12 | 35 | 55 | 70"));
        alkoList.add(new Alko("Sauvignon Blanc", "", "17 | 70 | 90 | 120"));
        return alkoList;
    }

    private String getWinoSizeInfo() {
        return "Wybierz mądrze szefie! \n" +
                "Kierowca (małe): 150ml \n" +
                "Początek (Średnie): 500ml \n" +
                "Pijak (Duży): 750ml \n" +
                "Zespołowiec (Dzbanek): 1.5l \n";
    }

    private static ArrayList<Alko> getDrinkiList() {
        ArrayList<Alko> alkoList = new ArrayList<>();
        alkoList.add(new Alko("Old Hugo", "Składniki: Kraken, Maschio Prosecco, likier z kwiatów czarnego bzu, sok z limonki, angostura, mięta", "31"));
        alkoList.add(new Alko("Tymiankowe Love", "Składniki: Brugal Anejo, Marie Brizard Triple Sec, białko, syrop tymiankowy, puree marakuja, sok z cytryny", "27"));
        alkoList.add(new Alko("Rose-Mary Spritz", "Składniki: Finlandia Vodka Wildberry & Rose, Maschio Prosecco, syrop rozmarynowy, sok z limonki", "28"));
        alkoList.add(new Alko("Purple Passion", "Składniki: Woodford Reserve, syrop hibiskusowy, sok z cytryny, orange bitter, imbir", "34"));
        alkoList.add(new Alko("Tropikalny Bush", "Składniki: Bushmills Black, likier brzoskwiniowy, orgeat, puree marakuja, sok z cytryny, Angostura", "34"));
        alkoList.add(new Alko("Space Bomb", "Składniki: Gin London No1, grenadyna, syrop z kwiatów czarnego bzu, sok z cytryny, białko", "28"));
        alkoList.add(new Alko("Kraken Negroni", "Składniki: Kraken, Bottega Bitter, Kijafa Cherry, Angostura, Orange Bitter", "29"));
        alkoList.add(new Alko("Paloma", "Składniki: Jose Cuervo Silver, Spicy Mango, sok z limonki, sok grejpfrutowy, sól", "27"));
        alkoList.add(new Alko("Jack Daniel's Sour", "Składniki: Jack Daniel's Tennessee Whiskey, Angostura, sok z cytryny, syrop cukrowy, białko", "29"));
        alkoList.add(new Alko("Cuba Libre", "Składniki: Brugal Anejo, Pepsi, limonka", "26"));
        alkoList.add(new Alko("Aperol Spritz", "Składniki: Aperol, Maschio Prosecco, woda gazowana", "27"));
        return alkoList;
    }

    private String getDrinkiSizeInfo() {
        return "Ceny pod każdą pozycją podane za 500ml";
    }

    private static ArrayList<Alko> getRumList() {
        ArrayList<Alko> alkoList = new ArrayList<>();
        alkoList.add(new Alko("Brugal Blanco", "", "17"));
        alkoList.add(new Alko("Brugal 1888", "", "34"));
        alkoList.add(new Alko("Kraken Black Spiced Rum", "", "20"));
        return alkoList;
    }

    private String getRumSizeInfo() {
        return "Ceny pod każdą pozycją podane za 40ml";
    }

    private static ArrayList<Alko> getGinList() {
        ArrayList<Alko> alkoList = new ArrayList<>();
        alkoList.add(new Alko("Gunpowder Irish Gin", "", "28"));
        alkoList.add(new Alko("Gibson's London Dry", "", "16"));
        alkoList.add(new Alko("London No1", "", "22"));
        alkoList.add(new Alko("Fords", "", "20"));
        alkoList.add(new Alko("Mare", "", "32"));
        alkoList.add(new Alko("Bombay Sapphire", "", "19"));
        return alkoList;
    }

    private String getGinSizeInfo() {
        return "Ceny pod każdą pozycją podane za 40ml";
    }

    private static ArrayList<Alko> getTequilaList() {
        ArrayList<Alko> alkoList = new ArrayList<>();
        alkoList.add(new Alko("Jose Cuervo", "", "16"));
        alkoList.add(new Alko("1800 Silver", "", "26"));
        alkoList.add(new Alko("El Jimador Blanco", "", "17"));
        alkoList.add(new Alko("Herradura Plata", "", "30"));
        return alkoList;
    }

    private String getTequilaSizeInfo() {
        return "Ceny pod każdą pozycją podane za 40ml";
    }

    private static ArrayList<Alko> getLikieryList() {
        ArrayList<Alko> alkoList = new ArrayList<>();
        alkoList.add(new Alko("Disaronno", "", "18"));
        alkoList.add(new Alko("Marie Brizard Triple Sec", "", "16"));
        alkoList.add(new Alko("Bottega Limoncino", "", "16"));
        alkoList.add(new Alko("Southern Comfort", "", "18"));
        alkoList.add(new Alko("Rosolis Różany", "", "14"));
        alkoList.add(new Alko("Soberano 5 YO", "", "16"));
        alkoList.add(new Alko("Jägermeister", "", "14"));
        return alkoList;
    }

    private String getLikierySizeInfo() {
        return "Ceny pod każdą pozycją podane za 40ml";
    }





}