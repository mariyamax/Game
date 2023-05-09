package org.example.states;

import org.example.enums.Colors;
import org.example.models.Card;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private static final GameState INSTANCE = new GameState();

    private final static int AMOUNT = 16;

    private static List<Card> cards;

    private GameState() {
        cards = new ArrayList<>();
        cards.add(new Card(1,"Яблоко", Colors.BLUE));
        cards.add(new Card(2,"Улица", Colors.BLUE));
        cards.add(new Card(3,"Трава", Colors.BLUE));
        cards.add(new Card(4,"Освобождение", Colors.BLUE));

        cards.add(new Card(5,"Решетка", Colors.RED));
        cards.add(new Card(6,"Зависимость", Colors.RED));
        cards.add(new Card(7,"Медведь", Colors.RED));
        cards.add(new Card(8,"Игрушка", Colors.RED));

        cards.add(new Card(9,"Дом", Colors.BEIGE));
        cards.add(new Card(10,"Семья", Colors.GREY));
        cards.add(new Card(11,"Платье", Colors.BEIGE));
        cards.add(new Card(12,"Желтый", Colors.BEIGE));

        cards.add(new Card(13,"Солнце", Colors.BEIGE));
        cards.add(new Card(14,"Природа", Colors.BEIGE));
        cards.add(new Card(15,"Поле", Colors.RED));
        cards.add(new Card(16,"Гнездо", Colors.BLUE));
    }

    public List<Card> getCards() {
        return cards;
    }

    public static GameState getInstance() {
        return INSTANCE;
    }
}
