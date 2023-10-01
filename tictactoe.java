import java.util.Scanner;
import java.util.Random;

class tictactoe
{
    public static int checkWin(char[] gameBoard)
    {
        if(gameBoard[0] == gameBoard[1] && gameBoard[0] == gameBoard[2] && (gameBoard[0]=='X' || gameBoard[0]=='O'))
            return 1;
        else if(gameBoard[3] == gameBoard[4] && gameBoard[3] == gameBoard[5] && (gameBoard[3]=='X' || gameBoard[3]=='O'))
            return 1;
        else if(gameBoard[6] == gameBoard[7] && gameBoard[6] == gameBoard[8] && (gameBoard[6]=='X' || gameBoard[6]=='O'))
            return 1;
        else if(gameBoard[0] == gameBoard[3] && gameBoard[0] == gameBoard[6] && (gameBoard[0]=='X' || gameBoard[0]=='O'))
            return 1;
        else if(gameBoard[1] == gameBoard[4] && gameBoard[1] == gameBoard[7] && (gameBoard[1]=='X' || gameBoard[1]=='O'))
            return 1;
        else if(gameBoard[2] == gameBoard[5] && gameBoard[2] == gameBoard[8] && (gameBoard[2]=='X' || gameBoard[2]=='O'))
            return 1;
        else if(gameBoard[0] == gameBoard[4] && gameBoard[0] == gameBoard[8] && (gameBoard[0]=='X' || gameBoard[0]=='O'))
            return 1;
        else if(gameBoard[2] == gameBoard[4] && gameBoard[2] == gameBoard[6] && (gameBoard[2]=='X' || gameBoard[2]=='O'))
            return 1;
        else
            return 0;
    }
    
    public static void printBoard(char[] gameBoard)
    {
        System.out.println("    | " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " |");
        System.out.println("    |---|---|---|");
        System.out.println("    | " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " |");
        System.out.println("    |---|---|---|");
        System.out.println("    | " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " |");
    }
    
    public static void playTurn(int r, char[] gameBoard, String player1, String player2)
    {
        char token;
        if(r == 1)
        {
            System.out.print("    " + player2);
            token = 'X';
        }
        
        else
        {
            System.out.print("    " + player1);
            token = 'O';
        }

        Scanner obj = new Scanner(System.in);
        System.out.print(", choose a number : ");
        int choice = obj.nextInt();
        if(choice == 0)
            gameBoard[0] = token;
        else if(choice == 1)
            gameBoard[1] = token;
        else if(choice == 2)
            gameBoard[2] = token;
        else if(choice == 3)
            gameBoard[3] = token;
        else if(choice == 4)
            gameBoard[4] = token;
        else if(choice == 5)
            gameBoard[5] = token;
        else if(choice == 6)
            gameBoard[6] = token;
        else if(choice == 7)
            gameBoard[7] = token;
        else if(choice == 8)
            gameBoard[8] = token;
    }
    
    
    public static void main(String[] args)
    {
        Scanner obj = new Scanner(System.in);
        Random rand = new Random();
        char[] gameBoard = {'.','.','.','.','.','.','.','.','.'};
        System.out.println("        ~~~ TIC - TAC - TOE ~~~");
        System.out.println("  Choose a number according to this grid to place your token!");
        System.out.println("    | 0 | 1 | 2 |");
        System.out.println("    |---|---|---|");
        System.out.println("    | 3 | 4 | 5 |");
        System.out.println("    |---|---|---|");
        System.out.println("    | 6 | 7 | 8 |");
        System.out.print("  Enter Player 1 name : ");
        String player1 = obj.nextLine();
        System.out.print("  Enter Player 2 name : ");
        String player2 = obj.nextLine();
        int r = rand.nextInt(2);
        printBoard(gameBoard);
        int k=0;
        while(checkWin(gameBoard) == 0 && k<9)
        {
            playTurn(r,gameBoard,player1,player2);
            printBoard(gameBoard);
            if(r==1)
                r=0;
            else
                r=1;
            k++;
            System.out.println();
        }
        if(k==9 && checkWin(gameBoard)==0)
            System.out.println("    ~~~ DRAW ~~~");
        else
        {
            if(r==1)
            System.out.println("    ~~~ " + player1 + " WINS ~~~");
            else
            System.out.println("    ~~~ " + player2 + " WINS ~~~");
        }
        System.out.println();
    }
}