import java.io.IOException;
import java.util.Scanner;

public class Program {
    private static char[][] field = new char[8][8];
    private static boolean whiteTurn = true;

    public static void main(String[] args) throws IOException {
        boolean kingDead = false;
        boolean canWalk = false;
        boolean kingWillDie;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                field[i][j] = '_';
            }
        }
        Scanner in = new Scanner(System.in);
        printFigures();
        printField(field);

        while (!kingDead) {
            if (whiteTurn) {
                kingWillDie = false;
                System.out.println("\nХод белых!");
                System.out.println("Кем ходить?");
                String whom = in.next();
                int prX = whom.charAt(1) - '1', prY = whom.charAt(0) - 'A';
                System.out.println("Куда ходить?");
                String where = in.next();
                int pX = where.charAt(1) - '1', pY = where.charAt(0) - 'A';
                if (field[pX][pY] == '_' || field[pX][pY] == 'l' || field[pX][pY] == 'h' || field[pX][pY] == 'f' || field[pX][pY] == 'd' || field[pX][pY] == 'k') {
                    canWalk = true;
                    if(field[pX][pY] == 'k')
                        kingWillDie = true;

                }
                if (canWalk) {
                    if (field[prX][prY] == 'L') {       //ход ладьи
                        field[pX][pY] = 'L';
                        field[prX][prY] = '_';
                        printField(field);
                        canWalk = false;
                    }
                    else if (field[prX][prY] == 'H') {      //ход коня
                        if((pX - prX)*(pX - prX) + (pY - prY)*(pY - prY) == 5){
                            field[pX][pY] = 'H';
                            field[prX][prY] = '_';
                            printField(field);
                            canWalk = false;
                        }
                        else {
                            System.out.println("\nТакой ход невозможен!\n");
                            printField(field);
                            continue;
                        }
                    } else if (field[prX][prY] == 'F') {    //ход ферзя(слон)
                        field[pX][pY] = 'F';
                        field[prX][prY] = '_';
                        printField(field);
                        canWalk = false;
                    } else if (field[prX][prY] == 'D') {    //ход дамы
                        field[pX][pY] = 'D';
                        field[prX][prY] = '_';
                        printField(field);
                        canWalk = false;
                    } else if (field[prX][prY] == 'K') {    //ход короля
                        field[pX][pY] = 'K';
                        field[prX][prY] = '_';
                        printField(field);
                        canWalk = false;
                    } else if (field[prX][prY] == 'P') {    //ход пешки
                        if(pX == prX - 1 && field[prX - 1][prY] == '_' && pY == prY){
                            field[pX][prY] = 'P';
                            field[prX][prY] = '_';
                            printField(field);
                            canWalk = false;
                        }
                        else if ( field[pX - 1][pY - 1] == 'l'
                                || field[pX - 1][pY - 1] == 'h'
                                || field[pX - 1][pY - 1] == 'f'
                                || field[pX - 1][pY - 1] == 'd'
                                || field[pX - 1][pY - 1] == 'k'
                                || field[pX - 1][pY + 1] == 'l'
                                || field[pX - 1][pY + 1] == 'h'
                                || field[pX - 1][pY + 1] == 'f'
                                || field[pX - 1][pY + 1] == 'd'
                                || field[pX - 1][pY + 1] == 'k')
                        {
                            field[pX][pY] = 'P';
                            field[prX][prY] = '_';
                            printField(field);
                            canWalk = false;
                        }
                        else {
                            System.out.println("\nТакой ход невозможен!\n");
                            printField(field);
                            continue;
                        }
                    }
                } else {
                    System.out.println("\nТакой ход невозможен!\n");
                    printField(field);
                    continue;
                }
                System.out.println("x = " + pY + "\n" + "y = " + pX);
                if(kingWillDie){
                    System.out.println("Белые победили!\n");
                    kingDead = true;
                    continue;
                }
                whiteTurn = false;
            }

            if (!whiteTurn) {
                kingWillDie = false;
                System.out.println("\nХод черных!");
                System.out.println("Кем ходить?");
                String whom = in.next();
                int prX = whom.charAt(1) - '1', prY = whom.charAt(0) - 'A';
                System.out.println("Куда ходить?");
                String where = in.next();
                int pX = where.charAt(1) - '1', pY = where.charAt(0) - 'A';

                if (field[pX][pY] == '_' || field[pX][pY] == 'L' || field[pX][pY] == 'H' || field[pX][pY] == 'F' || field[pX][pY] == 'D' || field[pX][pY] == 'K') {
                    canWalk = true;
                    if(field[pX][pY] == 'K')
                        kingWillDie = true;
                }

                if (canWalk) {
                    if (field[prX][prY] == 'l') {
                        field[pX][pY] = 'l';
                        field[prX][prY] = '_';
                        printField(field);
                        canWalk = false;
                    } else if (field[prX][prY] == 'h') {
                        if((pX - prX)*(pX - prX) + (pY - prY)*(pY - prY) == 5){
                            field[pX][pY] = 'h';
                            field[prX][prY] = '_';
                            printField(field);
                            canWalk = false;
                        }
                        else {
                            System.out.println("\nТакой ход невозможен!\n");
                            printField(field);
                            continue;
                        }
                    } else if (field[prX][prY] == 'f') {
                        field[pX][pY] = 'f';
                        field[prX][prY] = '_';
                        printField(field);
                        canWalk = false;
                    } else if (field[prX][prY] == 'd') {
                        field[pX][pY] = 'd';
                        field[prX][prY] = '_';
                        printField(field);
                        canWalk = false;
                    } else if (field[prX][prY] == 'k') {
                        field[pX][pY] = 'k';
                        field[prX][prY] = '_';
                        printField(field);
                        canWalk = false;
                    } else if (field[prX][prY] == 'p') {
                        if(pX == prX - 1 && field[prX - 1][prY] == '_' && pY == prY){
                            field[pX][prY] = 'p';
                            field[prX][prY] = '_';
                            printField(field);
                            canWalk = true;
                        }
                        else if (field[pX + 1][pY - 1] == 'L'
                                || field[pX + 1][pY - 1] == 'H'
                                || field[pX + 1][pY - 1] == 'F'
                                || field[pX + 1][pY - 1] == 'D'
                                || field[pX + 1][pY - 1] == 'K'
                                || field[pX + 1][pY + 1] == 'L'
                                || field[pX + 1][pY + 1] == 'H'
                                || field[pX + 1][pY + 1] == 'F'
                                || field[pX + 1][pY + 1] == 'D'
                                || field[pX + 1][pY + 1] == 'K')
                        {
                            field[pX][pY] = 'p';
                            field[prX][prY] = '_';
                            printField(field);
                            canWalk = true;
                        }
                        else {
                            System.out.println("\nТакой ход невозможен!\n");
                            printField(field);
                            continue;
                        }
                    } else {
                        System.out.println("\nТакой ход невозможен!");
                        printField(field);
                        continue;
                    }
                } else {
                    System.out.println("\nТакой ход невозможен!");
                    printField(field);
                    continue;
                }
                System.out.println("x = " + pY + "\n" + "y = " + pX);
                if(kingWillDie){
                    System.out.println("Черные победили!\n");
                    kingDead = true;
                    continue;
                }
                whiteTurn = true;
            }
        }
    }

    private static void printField(char[][] a) {
        System.out.print(" |  ");
        for (char i = 'A'; i <= 'H'; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 0; i < 27; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(i + 1 + "|  ");
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static void printFigures() {
        field[0][0] = 'l';
        field[0][1] = 'h';
        field[0][2] = 'f';
        field[0][3] = 'd';
        field[0][4] = 'k';
        field[0][5] = 'f';
        field[0][6] = 'h';
        field[0][7] = 'l';
        for (int i = 0; i < 8; i++) {
            field[1][i] = 'p';
        }

        field[7][0] = 'L';
        field[7][1] = 'H';
        field[7][2] = 'F';
        field[7][3] = 'D';
        field[7][4] = 'K';
        field[7][5] = 'F';
        field[7][6] = 'H';
        field[7][7] = 'L';
        for (int i = 0; i < 8; i++) {
            field[6][i] = 'P';
        }
    }
}

