
public class CaesarCipherTwo {

	private String alphabet;
	private String shiftedAlphabet1;
	private String shiftedAlphabet2;
	private int mainKey1;
	private int mainKey2;
	
	public CaesarCipherTwo(int key1, int key2) {
		alphabet = "abcdefghijklmnopqrstuvwxyz";
		shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
		shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
		mainKey1 = key1;
		mainKey2 = key2;
	}
	
	public String encrypt(String input) {
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
	
	public String decrypt(String input) {
		CaesarCipherTwo cct = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
		//System.out.println(cc.encrypt(input));
		//System.out.println(mainKey);
		return cct.encrypt(input);
	}

}
