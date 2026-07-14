package homework_b18;

import java.util.Arrays;

public class ChangeCoins {

	public static void main(String[] args) {
		int money = 5;
		int[] coins = { 7,4,2};
		
		int[] memo = new int[money + 1];
		Arrays.fill(memo, -1);
		
		

		int result1 = changeCoins(money, coins, memo);
		System.out.println(result1);

		int result2 = changeCoins(money, coins);
		System.out.println(result2);

	}

	// TOP DOWN
	public static int changeCoins(int money, int[] coins, int[] memo) {
		if (money == 0) {
			return 0;
		}
		// check memo
		if (memo[money] != -1) {
			return memo[money];
		}
		
		int bestAnswer = -1; //haven't got best answer yet

		// check every choice of coin
		for (int coin : coins) {
			if (money < coin) {
				continue;
			}

			int currentAnswer = changeCoins(money - coin, coins, memo);

			// can't change money to coins
			if (currentAnswer == -1) {
				continue;
			}

			currentAnswer++;

			if (bestAnswer == -1 || currentAnswer < bestAnswer) {
				bestAnswer = currentAnswer;
			}
		}
		memo[money] = bestAnswer;
		return bestAnswer;
	}

	// BOTTOM UP
	public static int changeCoins(int money, int[] coins) {
		int[] memo = new int[money + 1];

		Arrays.fill(memo, -1);

		// check minimum coins change from 0 to money
		for (int i = 0; i <= money; i++) {
			if (i == 0) {
				memo[0] = 0;
				continue;
			}

			// check every choice of coin
			int bestAnswer = -1;

			for (int coin : coins) {
				if (i < coin) {
					continue;
				}

				// can't change money to coins
				if (memo[i - coin] == -1) {
					continue;
				}

				int currentAnswer = 1 + memo[i - coin];

				if (bestAnswer == -1 || currentAnswer < bestAnswer) {
					bestAnswer = currentAnswer;
				}
			}
			memo[i] = bestAnswer;
		}
		return memo[money];
	}

}
