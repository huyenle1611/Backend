package homework_b16;

public class ChangeCoins {

	public static void main(String[] args) {
		System.out.println(changeCoins(37));  // 20 10 5 1 1 (5 coins)

	}
	public static int changeCoins(int money) {
		if (money < 0) {
            return -1; 
        }

        int[] coins = {20, 10, 5, 1};
        int coinCount = 0;

        for (int coin : coins) {
            coinCount += money / coin; 
            money %= coin;             
        }

        return coinCount;
	}

}

