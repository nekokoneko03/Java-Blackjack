import java.util.ArrayList;

public class Character {
    Hand hand;
    private String name;
    private boolean bust = false;

    public void initHand(Deck deck) {
        this.drawCard(deck);
        this.drawCard(deck);
    }

    public void drawCard(Deck deck) {
        hand.addHand(deck.drawCard(0));
        deck.removeCard();
    }

    public ArrayList<Integer> getHand () {
        return hand.handNum;
    }

    Character() {
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
