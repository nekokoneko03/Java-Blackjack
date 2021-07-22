import java.util.ArrayList;

public class Hand {
    Card card = new Card();
    private int numOfHand;
    private int scoreSum;
    //ArrayList<String> handSuits = new ArrayList<String>();
    ArrayList<Integer> handNum = new ArrayList<Integer>();
    ArrayList<String> handSuit = new ArrayList<String>();
    ArrayList<Integer> handScore = new ArrayList<Integer>();
    ArrayList<String> handData = new ArrayList<String>();
    ArrayList<Integer> handNums = new ArrayList<Integer>();

    public int getNumOfHand() {
        return numOfHand;
    }

    public void setNumOfHand(int numOfHand) {
        this.numOfHand = numOfHand;
    }

    public int getScoreSum() {
        return scoreSum;
    }

    public void setScoreSum(int scoreSum) {
        this.scoreSum = scoreSum;
    }

//    public void addHand(String suit, int num) {
//        this.handSuits.add(suit);
//        this.handNums.add(num);
//    }
//
//    public void addHandSuit(String suit) {
//        this.handSuits.add(suit);
//    }

    public void addHand(int num) {
        this.handNum.add(num);
    }

    public ArrayList<Integer> getHand () {
        return this.handNum;
    }

    public int getOneCard(int num) {
        return this.handNum.get(num);
    }

    public void createHandSuit(Hand hand, int num) {
        this.handSuit.add(card.toSuit(this.getOneCard(num)));
    }

    public void createHandScore(Hand hand, int num) {
        this.handScore.add(card.toScore(this.getOneCard(num)));
    }

    public void createHandNum(Hand hand, int num) {
        this.handNums.add(card.toNum(this.getOneCard(num)));
    }

    public void createHandData(Hand hand) {
        String handData;
        for (int i =0; i < hand.handNum.size(); i++) {
            this.createHandSuit(hand,i);
            this.createHandScore(hand,i);
            this.createHandNum(hand,i);
        }
        for (int i = 0; i <hand.handNum.size(); i++) {
            handData = this.handSuit.get(i) + this.handNums.get(i);
            this.handData.add(handData);
        }
    }

    public void addHandData(Hand hand) {
        String handData;
        this.createHandSuit(hand, this.handNum.size() - 1);
        this.createHandScore(hand, this.handNum.size() - 1);
        this.createHandNum(hand, this.handNum.size() - 1);
        handData = this.handSuit.get(handNum.size() - 1) + this.handNums.get(handNum.size() - 1);
        this.handData.add(handData);
    }

    public int calcHandScoreSum(Hand hand) {
        int handScoreSum = 0;
        for (int i = 0; i < this.handScore.size(); i++) {
            handScoreSum += this.handScore.get(i);
        }
        if (this.handScore.contains(1) && handScoreSum <= 11) {
            handScoreSum += 10;
        }
        this.scoreSum = handScoreSum;
        return handScoreSum;
    }

    public void printHandData(Hand hand, String name) {
        //System.out.println(hand.getHand());
        System.out.println(name + "の手札は" + hand.handData + "です。");
        System.out.println(name + "の手札の合計スコアは" + hand.calcHandScoreSum(hand));
    }

    public void printDealerHand(Hand hand, String name) {
        System.out.println(name + "の手札の一枚は[" + hand.handData.get(0) + "]です。");
        hand.calcHandScoreSum(hand);
    }

    public boolean checkHandBust(Hand hand) {
        return this.calcHandScoreSum(hand) >= 21;
    }
}
