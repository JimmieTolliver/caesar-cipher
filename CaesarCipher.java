

public class CaesarCipher {
	
	private String alphabet;
	private String shiftedAlphabet;
	private int mainKey;
	
	public CaesarCipher(int key) {
		alphabet = "abcdefghijklmnopqrstuvwxyz";
		shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
		mainKey = key;
	}

	public String encrypt (String input) {
		//String alphabet = "abcdefghijklmnopqrstuvwxyz";
		//String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			int alphaIndex = alphabet.indexOf(input.toLowerCase().charAt(i));
			if(alphaIndex != -1) {
				if(Character.isUpperCase(input.charAt(i))) {
					sb.append(Character.toUpperCase(shiftedAlphabet.charAt(alphaIndex)));
				}
				else {
					sb.append(shiftedAlphabet.charAt(alphaIndex));
				}
			}
			else {sb.append(input.charAt(i));
				
			}
		}
		return sb.toString();
	}
	
	public String decrypt(String input) {
		CaesarCipher cc = new CaesarCipher(26 - mainKey);
		//System.out.println(cc.encrypt(input));
		System.out.println(mainKey);
		return cc.encrypt(input);
	}
	
	public String encryptTwoKeys(String input, int key1, int key2 ) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
		String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if(i%2 == 0) {
				int alphaIndex = alphabet.indexOf(input.toLowerCase().charAt(i));
				if(alphaIndex != -1) {
					if(Character.isUpperCase(input.charAt(i))) {
						sb.append(Character.toUpperCase(shiftedAlphabet1.charAt(alphaIndex)));
					}
					else {
						sb.append(shiftedAlphabet1.charAt(alphaIndex));
					}
				}
				else {sb.append(input.charAt(i));
				}
			}
			else if(i%2 == 1){
				int alphaIndex = alphabet.indexOf(input.toLowerCase().charAt(i));
				if(alphaIndex != -1) {
					if(Character.isUpperCase(input.charAt(i))) {
						sb.append(Character.toUpperCase(shiftedAlphabet2.charAt(alphaIndex)));
					}
					else {
						sb.append(shiftedAlphabet2.charAt(alphaIndex));
					}
				}
				else {
					sb.append(input.charAt(i));
				}
			}
		}
		return sb.toString();
	}
	
	public void test() {
		int key1 = 23;
		int key2 = 5;
		//FileResource fr = new FileResource();
		//String message = fr.asString();
		//String encrypted = encrypt(message, key1);
		String encrypted = encryptTwoKeys("Jimmie T is one awesome dude", key1, key2);
		System.out.println("key is " + key1 + " " + key2 + "\n\n" +  encrypted);
	}

}
