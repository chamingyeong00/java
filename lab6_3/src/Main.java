public class Main {
    public static void main(String[] args) {
        KawiBawiBo game = new KawiBawiBo();
        //KawiBawiBo game = new KawiBawiBo(new Player("철수"), new Player("영희"));
        //KawiBawiBo game = new KawiBawiBo(new Computer("컴퓨터1"), new Computer("컴퓨터"));
        game.run();
    }
}