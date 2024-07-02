import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  N의 값이 0~40까지로 제한되어 있어 2차원 배열 선택
 *  fibonacci 개념과 dp 개념을 결합
 *  이미 한 번 기록이 된 단계는 추가적으로 업데이트하지 않아도 된다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 초기 dp n = 0, n = 1일 때 횟수
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            for (int j = 2; j <= num; j++) {
                if (dp[j][0] == 0 && dp[j][1] == 0) {
                    dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
                    dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
                }
            }

            sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
