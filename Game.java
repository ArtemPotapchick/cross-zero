public class Game {
    static  final char Dot_Player1 = 'X';
    static final char Dot_Player2 = '0';
    public  int Size_X = 3;
    public  int Size_Y =3;
    private final char Empty_Dot = '*';
    public final char[][] field = new char[Size_Y][Size_X];
    private final int forWin = 3;


    private Player playerX;
    private Player playerO;

    public Game(Player playerX, Player playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
    }


    public void initField() { //game
        for (int i = 0; i < Size_Y; i++) {
            for (int j = 0; j < Size_X; j++) {
                field[i][j] = Empty_Dot;
            }
        }
    }
    public void printField() { //game
        for (int i = 0; i < Size_Y; i++) {
            for (int j = 0; j < Size_X; j++) {
                System.out.print(field[i][j] + "\t");
            }
            System.out.println();
        }

    }
    public void setSymbol(int x, int y, char sym) {
        field[y][x] = sym;
    }
    public boolean isCellValid(int x, int y) { //game
        if (x < 0 || x >= Size_X || y < 0 || y >= Size_Y) {
            return false;
        }
        if (field[y][x] != Empty_Dot) {
            return false;
        }
        return true;
    }
     public boolean isFreePlace() {  // game
        for (int i = 0; i < Size_Y; i++) {
            for (int j = 0; j < Size_X; j++) {
                if (field[i][j] == Empty_Dot) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkWin(char sym) {  //game
        for (int i = 0; i < Size_Y; i++) {
            int res = 0;
            for (int j = 0; j < Size_X; j++) {
                if (field[i][j] == sym) {
                    res++;
                }
            }
            if (res == forWin) return true;
        }
        for (int i = 0; i < Size_Y; i++) {
            int res = 0;

            for (int j = 0; j < Size_X; j++) {
                if (field[j][i] == sym) {
                    res++;
                }
            }
            if (res == forWin) return true;
        }
        int firstDiag = 0;
        for (int i = 0; i < Size_Y; i++) {
            for (int j = 0; j < Size_X; j++) {
                if (j == i && field[i][j] == sym) firstDiag++;
            }
        }
        if (firstDiag == forWin) return true;
        int secondDiag = 0;
        for ( int i =0,j=Size_Y-1;i<Size_X && j>=0; i++,j-- ){
            if (field[i][j] == sym) secondDiag++;
        }
        if(secondDiag == forWin)return true;
        return  false;
    }

    public void start() {
        initField();
        printField();
        while (true){
            PlayersMove move = playerX.makemove(field);
            printField();
            if(checkWin(Dot_Player1)){
                System.out.println("Победа игрока1");
                break;
            }
            if(!isFreePlace()){
                System.out.println("Ничья");
                break;
            }
             playerO.makemove(field);
            System.out.println();
            printField();
            if(checkWin(Dot_Player2)){
                System.out.println("Победа игрока2");
                break;
            }
            if(!isFreePlace()){
                System.out.println("Ничья");
                break;
            }
        }
    }

}

