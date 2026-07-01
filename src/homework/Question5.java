package homework;

public class Question5 {

	public static void main(String[] args) {
		Question5 solution = new Question5();

	    String S = "SMS messages are really short";
	    int K = 12;

	    System.out.println(solution.solution(S, K));
	}

	public int solution(String S, int K) {

        String[] words = S.split(" ");

        int count = 0;
        int currentLength = 0;

        for (String word : words) {
            int wordLength = word.length();

            // A single word can't exceed K
            if (wordLength > K) {
                return -1;
            }

            // Start a new SMS
            if (currentLength == 0) {
                count++;
                currentLength = wordLength;

            // Add the word if it still fits (+1 for the space)
            } else if (currentLength + 1 + wordLength <= K) {
                currentLength += 1 + wordLength;

            // Doesn't fit, start a new SMS
            } else {
                count++;
                currentLength = wordLength;
            }
        }

        return count;
    }
}
