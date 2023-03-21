package Kaczki;

import java.util.Scanner;

public class Ducks {
    public static void main(String[] args) {
        System.out.println(solution());
    }
    
    static int solution() {
        Scanner input = new Scanner(System.in);
        System.out.println("Wpisz liczbę dostępnych kaczuszek");
        int N = input.nextInt();
        System.out.println("Wpisz maksymalną szerokość rzędu");
        int M = input.nextInt();
        int[][] ducks = new int[N][2];
        for (int i = 0; i < N; i++) {
            System.out.println("Wypisz wysokość kaczuszki");
            ducks[i][0] = input.nextInt();
            System.out.println("Wypisz szerokość kaczuszki");
            ducks[i][1] = input.nextInt();
        }
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (ducks[j - 1][1] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - ducks[j - 1][1]][j - 1] + ducks[j - 1][0]);
                }
            }
        }
        return dp[M][N];
    }


}
