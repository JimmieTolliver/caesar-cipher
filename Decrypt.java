
public class Decrypt {
	
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
	
	public void decrypt(String input) {
		int letterCounts[] = countLetters(input);
		int maxIndex = maxIndex(letterCounts);
		int key = maxIndex - 4;
		if(maxIndex < 4) {
			key = 26 - (4 - maxIndex);
		}
		
		CaesarCipher cc = new CaesarCipher();
		System.out.println(cc.encrypt(input, 26-key));
	}
	
	public void decryptTwoKeys(String input) {
		StringBuilder even = new StringBuilder();
		StringBuilder odd = new StringBuilder();
		
		for (int i = 0; i < input.length(); i++) {
			if(i%2 == 0) {
				even.append(input.charAt(i));
			}
			else {
				odd.append(input.charAt(i));
			}
		}
		
		int oddLetterCounts[] = countLetters(odd.toString());
		int evenLetterCounts[] = countLetters(even.toString());

		int maxIndexOdd = maxIndex(oddLetterCounts);
		int maxIndexEven = maxIndex(evenLetterCounts);
		
		int key2 = maxIndexOdd - 4;
		if(maxIndexOdd < 4) {
			key2 = 26 - (4 - maxIndexOdd);
		}
		
		int key1 = maxIndexEven - 4;
		if(maxIndexEven < 4) {
			key1 = 26 - (4 - maxIndexEven);
		}
		
		System.out.println(key1 +" "+ key2);
		CaesarCipher cc = new CaesarCipher();
		System.out.println(cc.encryptTwoKeys(input, 26-key1, 26-key2));
		//System.out.println(cc.encryptTwoKeys(input, 24, 6));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Decrypt decipher = new Decrypt();
		String ecryptedMessege = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
		//decipher.decrypt(ecryptedMessege);
		decipher.decryptTwoKeys(ecryptedMessege);
	}

}
