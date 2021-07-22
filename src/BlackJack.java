import java.util.Scanner;

public class BlackJack {
    Scanner sc = new Scanner(System.in);
    Deck deck = new Deck();
    Player player = new Player();
    Dealer dealer = new Dealer();

    public void run() {
        System.out.println("----------------------------------------------------------------------");
        player.initHand(deck);
        player.hand.createHandData(player.hand);
//        System.out.println(player.getHand());
//        player.hand.createHandData(player.hand);
//        player.hand.createHandSuit(player.hand);
//        player.hand.createHandScore(player.hand);
//        System.out.println("あなたの手札は" + player.hand.handData + "です。");
//        System.out.println("あなたの手札の合計スコアは" + player.hand.calcHandScoreSum(player.hand));
        player.hand.printHandData(player.hand, player.getName());

        System.out.println("");

        dealer.initHand(deck);
        dealer.hand.createHandData(dealer.hand);
//        System.out.println(dealer.getHand());
//        dealer.hand.createHandData(dealer.hand);
//        dealer.hand.createHandSuit(dealer.hand);
//        dealer.hand.createHandScore(dealer.hand);
//        System.out.println("ディーラーの手札は" + dealer.hand.handData + "です。");
//        System.out.println("ディーラーの手札の合計スコアは" + dealer.hand.calcHandScoreSum(dealer.hand));
        player.hand.printDealerHand(dealer.hand, dealer.getName());

        //System.out.println(player.hand.checkHandBust(player.hand));
        if (player.hand.checkHandBust(player.hand)) {
            if (dealer.hand.checkHandBust(dealer.hand)) {
                System.out.println(dealer.getName() + "の手札は" + dealer.hand.handData);
                System.out.println("ディーラーの勝ちです");
                System.out.println("----------------------------------------------------------------------");
                return;
            } else {
                System.out.println(dealer.getName() + "の手札は" + dealer.hand.handData);
                System.out.println("プレイヤーの勝ちです");
                System.out.println("----------------------------------------------------------------------");
                return;
            }
        }

        System.out.println("");

        System.out.println("もう一枚カードを引きますか？ > y/n");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("y")) {
                player.drawCard(deck);
                player.hand.addHandData(player.hand);
                player.hand.printHandData(player.hand,player.getName());
                if (player.hand.checkHandBust(player.hand)) {
                    System.out.println(player.getName() + "はバストしました。あなたの負けです。");
                    System.out.println("----------------------------------------------------------------------");
                    return;
                }
            } else if (input.equals("n")) {
                break;
            }
        }


        while (dealer.hand.getScoreSum() <= 17) {
            //System.out.println(dealer.hand.getScoreSum());
            System.out.println(dealer.getName() + "がドローします。");
            System.out.println("");
            dealer.drawCard(deck);
            dealer.hand.addHandData(dealer.hand);
            if (dealer.hand.checkHandBust(player.hand)) {
                System.out.println(dealer.getName() + "はバストしました。あなたの勝ちです。");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("");
            }
        }

        System.out.println(player.getName() + "の手札は" + player.hand.handData);
        System.out.println(dealer.getName() + "の手札は" + dealer.hand.handData);
        System.out.println("");
        System.out.println(player.getName() + "のスコアは" + player.hand.getScoreSum() + dealer.getName() + "のスコアは" + dealer.hand.getScoreSum());
        if (player.hand.getScoreSum() == dealer.hand.getScoreSum() || player.hand.getScoreSum() <= dealer.hand.getScoreSum()) {
            System.out.println(dealer.getName() + "の勝ちです。");
            System.out.println("----------------------------------------------------------------------");
        } else {
            System.out.println(player.getName() + "の勝ちです。");
            System.out.println("----------------------------------------------------------------------");
        }
    }
}
