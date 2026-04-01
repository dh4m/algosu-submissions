import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main  {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] h = new int[n];
		long res = 0;
		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < n; i++) {
			while (stack.size() != 0 && h[stack.peek()] <= h[i]) {
				int pre_i = stack.pop();
				res += i - pre_i - 1;
			}
			stack.push(i);
		}
		while (stack.size() != 0) {
			int pre_i = stack.pop();
			res += n - pre_i - 1;
		}
		System.out.println(res);
	}
}