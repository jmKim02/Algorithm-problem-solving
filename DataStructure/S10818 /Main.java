import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Stack 메소드 활용 - push, pop, peek, isEmpty, size
 * 
 * Stack 클래스는 Vector 클래스를 상속받고
 * Vector 클래스는 List 인터페이스를 구현하므로 size() 메서드를 사용할 수 있다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int n  = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();

            if (comm.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (comm.equals("pop")) {
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.pop()).append("\n");
                }
            } else if (comm.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (comm.equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (comm.equals("top")) {
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.peek()).append("\n");
                }
            } else {
                System.out.println("Command Error!\n");
            }
        }

        System.out.print(sb);
        br.close();
    }
}
