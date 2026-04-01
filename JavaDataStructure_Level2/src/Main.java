import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		rank = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			if (st.hasMoreTokens()) {
				int count = Integer.parseInt(st.nextToken());

				if (count > 0) {
					int firstStudent = Integer.parseInt(st.nextToken());

					for (int j = 1; j < count; j++) {
						int nextStudent = Integer.parseInt(st.nextToken());
						union(firstStudent, nextStudent);
					}
				}
			}
		}

		int[] groupSize = new int[N + 1];
		int maxFriends = 0;

		for (int i = 1; i <= N; i++) {
			int root = find(i);
			groupSize[root]++;
			if (groupSize[root] > maxFriends) {
				maxFriends = groupSize[root];
			}
		}

		System.out.println(maxFriends);
	}

	public static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	public static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX != rootY) {
			if (rank[rootX] < rank[rootY]) {
				parent[rootX] = rootY;
			} else if (rank[rootX] > rank[rootY]) {
				parent[rootY] = rootX;
			} else {
				parent[rootY] = rootX;
				rank[rootX]++;
			}
		}
	}
}