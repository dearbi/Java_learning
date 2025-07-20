package 洗牌算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.swap;

public class CardDemo {
    public static final String[] SUITS = {"♠", "♥", "♣", "♦"};
    // 买⼀副牌
    public static List<Card> buyDeck() {
        List<Card> deck = new ArrayList<>(52);
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                String suit = SUITS[i];
                int rank = j;
                Card card = new Card(rank,suit);
                deck.add(card);
            }
        }
        return deck;
    }

    private static void swap(List<Card> deck, int i, int j) {
        Card t = deck.get(i);
        deck.set(i, deck.get(j));
        deck.set(j, t);
    }
    private static void shuffle(List<Card> deck) {
        Random random = new Random(20190905);
        for (int i = deck.size() - 1; i > 0; i--) {
            int r = random.nextInt(i);
            swap(deck, i, r);
        }
    }


}
