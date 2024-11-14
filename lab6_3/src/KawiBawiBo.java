public class KawiBawiBo {
    private final String[] s = {"가위", "바위", "보"};
    private Player[]  players = new Player[2];

    public KawiBawiBo(){
        players[0] = new Player("철수");
        players[1] = new Computer("컴퓨터");
    }

    public KawiBawiBo(Player player0, Player player1){
        players[0] = player0;
        players[1] = player1;
    }

    public void run(){
        int choiceOfPlayer0, choiceOfPlayer1;
        while(true){
            choiceOfPlayer0 = players[0].turn();
            if(choiceOfPlayer0 == 4)
                break;
            choiceOfPlayer1 = players[1].turn();
            System.out.println(players[0].getName() + "(" + s[choiceOfPlayer0-1] + ") : " + players[1].getName() + "(" + s[choiceOfPlayer1-1] + ")");
            int diff = choiceOfPlayer0 - choiceOfPlayer1;
            switch(diff) {
                case 0:
                    System.out.println("비겼습니다.");
                    break;
                case -1:
                case 2:
                    System.out.println(players[1].getName() + "이겼습니다.");
                    break;
                case 1:
                case -2:
                    System.out.println(players[0].getName() + "이겼습니다.");
                    break;
            }
        }
    }

}
