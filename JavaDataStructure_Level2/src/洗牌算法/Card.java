package 洗牌算法;

public class Card {
    public int rank; // 牌⾯值
    public String suit; // 花⾊

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format("[%s %d]", suit, rank);
    }
}
