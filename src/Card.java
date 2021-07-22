public class Card {
    private String suit;
    private int rank;
    private int score;

    public String toSuit(int num) {
        switch (num / 13) {
            case 0:
                return "ダイヤの";
            case 1:
                return "ハートの";
            case 2:
                return "スペードの";
            case 3:
                return "クローバーの";
            default:
                return "エラー";
        }
    }

    public int toScore(int num) {
        num += 1;
        if (num == 0) {
            return 1;
        } else if (num % 13 == 0 || num % 13 >= 10) {
            return 10;
        } else {
            return (num % 13);
        }

    }

    public int toNum(int num) {
        num += 1;
        if (num % 13 == 0) {
            return 13;
        } else {
            return num % 13;
        }
    }
}
