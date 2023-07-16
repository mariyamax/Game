package org.example.states;

import org.example.enums.Cast;
import org.example.enums.Colors;
import org.example.models.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.util.Collections.shuffle;

public class GameState {

    private static final GameState INSTANCE = new GameState();

    private final static int AMOUNT = 16;

    public int bCounter = 0;

    public int rCounter = 0;

    private static List<Card> cards;

    private GameState() {
        cards = new ArrayList<>();
        cards.add(new Card(1,"Яблоко", Colors.BLUE.value));
        cards.add(new Card(2,"Улица", Colors.BLUE.value));
        cards.add(new Card(3,"Трава", Colors.BLUE.value));
        cards.add(new Card(4,"Освобождение", Colors.BLUE.value));

        cards.add(new Card(5,"Решетка", Colors.RED.value));
        cards.add(new Card(6,"Зависимость", Colors.RED.value));
        cards.add(new Card(7,"Медведь", Colors.RED.value));
        cards.add(new Card(8,"Игрушка", Colors.RED.value));

        cards.add(new Card(9,"Дом", Colors.BEIGE.value));
        cards.add(new Card(10,"Семья", Colors.GREY.value));
        cards.add(new Card(11,"Платье", Colors.BEIGE.value));
        cards.add(new Card(12,"Желтый", Colors.BEIGE.value));

        cards.add(new Card(13,"Солнце", Colors.BEIGE.value));
        cards.add(new Card(14,"Природа", Colors.BEIGE.value));
        cards.add(new Card(15,"Поле", Colors.RED.value));
        cards.add(new Card(16,"Гнездо", Colors.BLUE.value));

        print();
    }

    public List<Card> getCards() {
        return cards;
    }

    private void print() {
        List<Colors> colors = new ArrayList<>();
        colors.add(Colors.GREY);
        colors.add(Colors.RED);
        colors.add(Colors.RED);
        colors.add(Colors.RED);
        colors.add(Colors.RED);
        colors.add(Colors.RED);
        colors.add(Colors.RED);
        colors.add(Colors.BEIGE);
        colors.add(Colors.BEIGE);
        colors.add(Colors.BEIGE);
        colors.add(Colors.BLUE);
        colors.add(Colors.BLUE);
        colors.add(Colors.BLUE);
        colors.add(Colors.BLUE);
        colors.add(Colors.BLUE);
        colors.add(Colors.BLUE);
        shuffle(colors);
        Iterator iter = cards.iterator();
        for (Colors color: colors) {
            ((Card)iter.next()).setColor(color.value);
        }
    }

    public static GameState getInstance() {
        return INSTANCE;
    }

    public void addPointToRed() {
        rCounter++;
    }

    public void addPointToBlue() {
        bCounter++;
    }

    public void gameOver(Cast cast) {
        switch (cast) {
            case RED:
                rCounter = -1;
                break;
            case BLUE:
                bCounter = -1;
                break;
        }
    }

}
