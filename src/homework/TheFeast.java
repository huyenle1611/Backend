package homework;

public class TheFeast {

	public static void main(String[] args) {

		// test the feast
		int test = theFeast(15, 3, 2);

		System.out.println(test);

	}

	// the feast - assume all inputs meet the constraints
	// 1 < t < 1000
	// 2 < n < 105
	// 1< c < n
	// 2 < m < n

	// O(n)
	public static int theFeast(int n, int c, int m) {
		int totalBars;
		int currentWrapppers;

		totalBars = n / c;
		currentWrapppers = totalBars;

		while (currentWrapppers >= m) {
			int newBars = currentWrapppers / m;
			totalBars += newBars;
			currentWrapppers = currentWrapppers % m + newBars;
		}

		return totalBars;
	}

}
