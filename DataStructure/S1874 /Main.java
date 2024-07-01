import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * push, pop이 어떤 경우에 되어야 할 지 고민해보자.
 * push - 현재 입력받은 값(value)보다 가장 최근에 스택에 넣은 값(count)이 작은 경우 
 * pop - 스택의 최상단 값이 현재 입력받은 값과 같은 경우
 * 값이 다르면 왜 pop을 할 수 없을까?
 * -> 값이 다르다는 것은 아직 스택에 제거하지 못한 나보다 높은 값이 남아 있다는 의미
 * -> 입력 예시2의 3 4의 경우를 생각해보면, 3의 차례일 때 스택의 최상단 값은 4이다.
 * -> 이 때, 3을 pop 하기위해 4를 먼저 pop 해야하고 결과적으로 이후에 4를 pop 할 수 없는 상황
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        int flag = 1;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());

            while (value >= count) {
                stack.push(count++);
                sb.append("+").append("\n");
            }

            if (stack.isEmpty() || stack.peek() != value) {
                flag = 0;
                /*
                    입력을 끝까지 받지 않아도 되는 경우를 가정한다면 flag를 따로 사용하지 않고 바로 종료도 가능하다.
                    flag를 사용한 이유는 입력 예시2의 경우처럼 수열이 안되는 경우에도 입력은 끝까지 받도록 하기 위함이다.
                    
                    System.out.print("NO");
                    return;
                 */
            } else {
                stack.pop();
                sb.append("-").append("\n");
            }
        }

        if (flag == 0) {
            System.out.print("NO");
        } else {
            System.out.print(sb);
        }
        br.close();
    }
}
