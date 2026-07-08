package homework_b16;

public class SmsCount {

	public static void main(String[] args) {
		String s = "SMS messages are really short abc exy hello hello";
		System.out.println(solution(s, 8));
	}

	
	
	
	
	public static int solution(String S, int K) {

	    int smsCount = 0;
	    int currentLength = 0;

	    int start = 0;

	    while (start < S.length()) {

	        int end = start;
	        // Find the end of current word
	        while (end < S.length() && S.charAt(end) != ' ') {
	            end++;
	        }
	        int wordLength = end - start;

	        // One word is longer than K
	        if (wordLength > K) {
	            return -1;
	        }
	        // Start first SMS
	        if (currentLength == 0) {
	            smsCount++;
	            currentLength = wordLength;
	        }
	        // Add word to current SMS
	        else if (currentLength + 1 + wordLength <= K) {
	            currentLength += 1 + wordLength;
	        }
	        // Start new SMS
	        else {
	            smsCount++;
	            currentLength = wordLength;
	        }

	        // Move to next word, skip the space
	        start = end + 1;
	    }
	    return smsCount;
	}
}
