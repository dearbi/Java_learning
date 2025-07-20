package 洗牌算法;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;
import static 洗牌算法.CardDemo.buyDeck;

public class Test {
    public static void main(String[] args) {
        List<Card> deck = buyDeck();
        System.out.println("刚买回来的牌:");
        System.out.println(deck);
        shuffle(deck);
        System.out.println("洗过的牌:");
        System.out.println(deck);
// 三个⼈，每个⼈轮流抓 5 张牌
        /*List<List<Card>> hands = new ArrayList<>();
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());*/
        List<Card> hand1 = new ArrayList<>();
        List<Card> hand2 = new ArrayList<>();
        List<Card> hand3 = new ArrayList<>();
        List<List<Card>> hands = new ArrayList<>();
        hands.add(hand1);
        hands.add(hand2);
        hands.add(hand3);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                hands.get(j).add(deck.remove(0));
            }
        }
        System.out.println("剩余的牌:");
        System.out.println(deck);
        System.out.println("A ⼿中的牌:");
        System.out.println(hands.get(0));
        System.out.println("B ⼿中的牌:");
        System.out.println(hands.get(1));
        System.out.println("C ⼿中的牌:");
        System.out.println(hands.get(2));

    }
}
