import java.util.Scanner;
public class RealPlayer implements Player {

    @Override
    public PlayersMove makemove(char[][] field) {
        int x,y;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты(Player) :");
        x = scanner.nextInt() - 1;
        y = scanner.nextInt() - 1;
       return ;
    }
}
