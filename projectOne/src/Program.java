import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program {
    private static char [][] field = new char[8][8];
    private static boolean kingDead = false;
    private static boolean whiteTurn = true;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                field[i][j] = '_';
            }
        }
        Scanner in = new Scanner(System.in);
        printFigures();
        printField(field);

        while (!kingDead) {
            if(whiteTurn){
                System.out.println("\nХод белых!");
                System.out.println("Кем ходить?");
                String whom = in.next();
                int prX = whom.charAt(1) - '1', prY = whom.charAt(0) - 'A';
                System.out.println("\nКуда ходить?");
                String where = in.next();
                int pX = where.charAt(1) - '1', pY = where.charAt(0) - 'A';
                if (field[prX][prY] == 'L') {
                    field[pX][pY] = 'L';
                    field[prX][prY] = '_';
                    printField(field);
                    whiteTurn = false;
                }
                if (field[prX][prY] == 'H') {
                    field[pX][pY] = 'H';
                    field[prX][prY] = '_';
                    printField(field);
                    whiteTurn = false;
                }
                if (field[prX][prY] == 'F') {
                    field[pX][pY] = 'F';
                    field[prX][prY] = '_';
                    printField(field);
                    whiteTurn = false;
                }
                if (field[prX][prY] == 'D') {
                    field[pX][pY] = 'D';
                    field[prX][prY] = '_';
                    printField(field);
                    whiteTurn = false;
                }
                if (field[prX][prY] == 'K') {
                    field[pX][pY] = 'K';
                    field[prX][prY] = '_';
                    printField(field);
                    whiteTurn = false;
                }
                if (field[prX][prY] == 'P') {
                    field[pX][pY] = 'P';
                    field[prX][prY] = '_';
                    printField(field);
                    whiteTurn = false;
                }
                else {
                    System.out.println("Такой ход невозможен!");
                    printField(field);
                    continue;
                }
                System.out.println("x = "+ pY + "\n" + "y = "+ pX);
            }
            else if(!whiteTurn){
                System.out.println("\nХод черных!");
                System.out.println("Кем ходить?");
                String whom = in.next();
                int prX = whom.charAt(1) - '1', prY = whom.charAt(0) - 'A';
                System.out.println("\nКуда ходить?");
                String where = in.next();
                int pX = where.charAt(1) - '1', pY = where.charAt(0) - 'A';
                if (field[prX][prY] == 'l') {
                    field[pX][pY] = 'l';
                    field[prX][prY] = '_';
                    printField(field);
                    whiteTurn = true;
                }
                if (field[prX][prY] == 'h') {
                    field[pX][pY] = 'h';
                    field[prX][prY] = '_';
                    printField(field);
                    whiteTurn = true;
                }
                if (field[prX][prY] == 'f') {
                    field[pX][pY] = 'f';
                    field[prX][prY] = '_';
                    printField(field);
                    whiteTurn = true;
                }
                if (field[prX][prY] == 'd') {
                    field[pX][pY] = 'd';
                    field[prX][prY] = '_';
                    printField(field);
                    whiteTurn = true;
                }
                if (field[prX][prY] == 'k') {
                    field[pX][pY] = 'k';
                    field[prX][prY] = '_';
                    printField(field);
                    whiteTurn = true;
                }
                if (field[prX][prY] == 'p') {
                    field[pX][pY] = 'p';
                    field[prX][prY] = '_';
                    printField(field);
                    whiteTurn = true;
                }
                else {
                    System.out.println("Такой ход невозможен!");
                    printField(field);
                    continue;
                }
                System.out.println("x = "+ pY + "\n" + "y = "+ pX);
            }
            }
        }

        private static void printField ( char[][] a){
            System.out.print(" |  ");
            for (char i = 'A'; i <= 'H'; i++) {
                System.out.print(i + "  ");
            }
            System.out.println();
            for (int i = 0; i < 27; i++){
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

