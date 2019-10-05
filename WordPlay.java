
public class WordPlay {
	
	public boolean isVowel(char ch) {
		String vowels = "aeiou";
		int index = vowels.indexOf(Character.toLowerCase(ch));
		if(index != -1) {
			return true;
		}
		else return false;
	}
	
	public String replaceVowels(String phrase, char ch) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < phrase.length(); i++) {
			if (isVowel(phrase.charAt(i))) {
				sb.append(ch);
			}
			else {
				sb.append(phrase.charAt(i));
			}
		}
		return sb.toString();
	}
	
	public String emphasize(String phrase, char ch) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < phrase.length(); i++) {
			if (i%2 == 0 && Character.toLowerCase(phrase.charAt(i)) == ch) {
				sb.append('*');
			}
			else if(i%2 == 1 && Character.toLowerCase(phrase.charAt(i)) == ch) {
				sb.append('+');
			}
			else {
				sb.append(phrase.charAt(i));
			}
		}
		return sb.toString();
	}

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordPlay words = new WordPlay();
		//System.out.println(words.isVowel('a'));
		//System.out.println(words.isVowel('b'));
		//System.out.println(words.isVowel('o'));
		//System.out.println(words.isVowel('2'));
		
		//System.out.println(words.replaceVowels("JIMMIE is a cool dude.", '$'));
		System.out.println(words.emphasize("Mary Bella Abracadabra", 'a'));
	}

}
