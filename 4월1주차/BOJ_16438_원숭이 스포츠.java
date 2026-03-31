import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main  {
	static int n;
	static char[][] res;
	
	static void solve(int day, int start, int end, char team) {
		if (start > end || day >= 7)
			return ;
		if (start == end) {
			for (int i = day; i < 7; i++) {
				res[i][start] = team;
			}
			return ;
		}
		for (int i = start; i <= end; i++) {
			res[day][i] = team;
		}
		int mid = (start + end) / 2;
		solve(day + 1, start, mid, 'A');
		solve(day + 1, mid + 1, end, 'B');
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		res = new char[7][n];
		solve(0, 0, (n - 1) / 2, 'A');
		solve(0, (n - 1) / 2 + 1, n - 1, 'B');
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < n; j++) {
				bw.append(res[i][j]);
			}
			bw.append('\n');
		}
		bw.flush();
		bw.close();
	}
}