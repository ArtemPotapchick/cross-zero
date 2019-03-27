import java.util.Scanner;
public class Players {
  public final char Dot_Player1 = 'X';
    public final char Dot_Player2 = '0';
     private Scanner scanner = new Scanner(System.in);

    public void movePerson1(char[][] field) { // players
    int x, y;
    do {
        System.out.println("Введите координаты(Player1) :");
        x = scanner.nextInt() - 1;
        y = scanner.nextInt() - 1;
    } while (!isCellValid(x,y));
    field[y][x] = Dot_Player1;
}
    public void movePerson2(char[][] field) { // players
        int x, y;
        do {
            System.out.println("Введите координаты{Player2) :");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x,y));
        field[y][x] = Dot_Player2;

    }
}