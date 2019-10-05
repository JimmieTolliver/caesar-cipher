import edu.duke.*;

public class TestCaesarCipher {
	
	public int[] countLetters(String input) {
		String alphabet ="abcdefghijklmnopqrstuvwxyz";
		int[] counts = new int [26];
		for (int i = 0; i < input.length(); i++) {
			char ch = Character.toLowerCase(input.charAt(i));
			int index = alphabet.indexOf(ch);
			if(index != -1) {
				counts[index] += 1;
			}
		}
		for(int i = 0; i < 26; i++) {
		};
		return counts;
	}
	
	public int maxIndex(int[] counts) {
		int maxValue = 0;
		int maxIndex = 0;
		for(int i = 0; i < counts.length; i++) {
			if(counts[i]> maxValue) {
				maxValue = counts[i];
				maxIndex = i;
			}
		}
		//System.out.println(maxIndex);
		return maxIndex;
	}
	
	public void breakCaesarCipher(String input) {
		int[] counts = countLetters(input);
		int key = maxIndex(counts) - 4;
		//System.out.println(key);
		CaesarCipher cc = new CaesarCipher(key);
		//cc.decrypt(input);
		System.out.println(cc.decrypt(input));
	}
	
	public void simpleTests() {
		//FileResource fr = new FileResource();
		CaesarCipher cc = new CaesarCipher(15);
		//System.out.println(fr.asString());
		//String encryptedMessage = cc.encrypt(fr.asString());
		String encryptedMessage = cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
		System.out.println(encryptedMessage);
		System.out.println(cc.decrypt(encryptedMessage));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestCaesarCipher test = new TestCaesarCipher();
		test.simpleTests();
		//test.breakCaesarCipher("ggggggggggggggggggggggggr!");
	}

}
