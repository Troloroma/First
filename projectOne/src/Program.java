import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Program {
    private static char [][] field = new char[8][8];
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                field[i][j] = '_';
            }
        }
        Scanner in = new Scanner(System.in);
        int prX = 0, prY = 1;
        printFigures();
        printField(field);

        while (true) {
            System.out.println("Ходи!");
            String s = in.next();
            int pY = s.charAt(0) - 'A', pX = s.charAt(1) - '1';
            System.out.println(pX + " " + pY);
            if (true) {
                field[pX][pY] = '♞';
                field[prX][prY] = '-';
                prX = pX;
                prY = pY;
                printField(field);
            } else {
                System.out.println("Такой ход невозможен!");
                continue;
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

