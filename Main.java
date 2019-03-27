

public class Main {

    public static void main(String[] args) {

        Players players = new Players();
        Player playerX = new RealPlayer();
        Player playerO = new RealPlayer();
        Game game = new Game(playerX, playerO);

        game.start();


    }
}