import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final int MAX_SIZE = 52;
    private int currentSize;
    ArrayList<Integer> deckCards = new ArrayList<Integer>();

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public int drawCard(int i) {
        return this.deckCards.get(i);
    }

    public void removeCard() {
        this.deckCards.remove(0);
    }

    Deck() {
        //デッキ作成
        for (int i = 0; i < MAX_SIZE; i++) {
            this.deckCards.add(i);
        }
        Collections.shuffle(deckCards);
        //System.out.println(this.deckCards);
    }
}
