import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        String startPointName = inputPoint("Input start point(A1 format) on chessboard 8*8:");
        int[] startPoint = chessField(startPointName);
        String secondPointName = inputPoint("Input check point(A1 format) on chessboard 8*8:");
        int[] secondPoint = chessField(secondPointName);

        int[][] possibleMoves = matrixOfPossibleMoves(startPoint);
        if (possibleMoves[secondPoint[0]][secondPoint[1]] == 1) {
            System.out.println("This is the Knight's move");
        } else System.out.println("This is not the Knight's move");
    }

    public static String inputPoint(String s) {
        Scanner scanner = new Scanner(System.in);
        String pointName;
        while (true) {
            System.out.println(s);
            pointName = scanner.nextLine();
            int x = chessField(pointName)[0];
            int y = chessField(pointName)[1];
            if (isValid(x, y)) {
                break;
            } else System.err.println("Wrong point");
        }
        return pointName;
    }


    public static boolean isValid(int x, int y) {
        return ((x >= 0) & (y >= 0) & (x < 8) & (y < 8));
    }


    public static int[] chessField(String point) {
        int x = Character.getNumericValue(point.charAt(1)) - 1;
        int y = letterToNumberConverter(point.charAt(0));
        int[] chess = new int[2];
        chess[0] = x;
        chess[1] = y;
        return chess;
    }

    public static int letterToNumberConverter(char a) {
        int k = 0;
        for (char i = 'A'; i < 'Z'; i++) {
            if (i != a) {
                k++;
            } else break;
        }
        return k;
    }

    public static int[][] matrixOfPossibleMoves(int[] startPoint) {
        int[][] boardOfPossibleSteps = new int[8][8];
        int[] x = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] y = {1, -1, 2, -2, 2, -2, 1, -1};
        for (int k = 0; k < x.length; k++) {
            int dx = startPoint[0] + x[k];
            int dy = startPoint[1] + y[k];
            if (!isValid(dx, dy)) {
                continue;
            } else {
                for (int i = 0; i < boardOfPossibleSteps.length; i++) {

                    for (int j = 0; j < boardOfPossibleSteps[i].length; j++) {
                        if ((i == dx) & (j == dy)) {
                            boardOfPossibleSteps[i][j] = 1;
                            break;
                        }
                    }
                }
            }
        }
        return boardOfPossibleSteps;
    }
}


