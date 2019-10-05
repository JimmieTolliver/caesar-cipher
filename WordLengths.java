import edu.duke.*;

public class WordLengths {
	
	public void countWordLengths(FileResource resource, int[] counts) {
		for (String s: resource.words()) {
			//System.out.println(s);
			int wordLength = s.length();
			if (Character.isLetter(s.charAt(0)) == false && Character.isLetter(s.charAt(wordLength-1)) == false) {
				if(wordLength > 1) {
					wordLength = s.length() - 2;
				}
			}
			else if (Character.isLetter(s.charAt(0)) == false || Character.isLetter(s.charAt(wordLength-1)) == false){
				wordLength = s.length() - 1;
			}
			if (wordLength >= 30) {
				counts[30] += 1;
			}
			else {
			counts[wordLength] += 1;
			}
		}
		for(int i = 1; i <= 30; i++) {
			System.out.println(i + "'s=\t" + counts[i]);
		}
	}
	
	public void test() {
		FileResource fr = new FileResource();
		int counts [] = new int [31];
		countWordLengths(fr, counts);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLengths word = new WordLengths();
		word.test();
	}
}
