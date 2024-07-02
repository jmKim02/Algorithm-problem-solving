import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i < K + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < N + 1; i++) {
            dp[i][1] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 2; j < K + 1; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        System.out.print(dp[N][K]);
        br.close();
    }
}
