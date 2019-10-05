import edu.duke.FileResource;

/*THIS IS OLD CODE BEFORE MAKING A MORE OBJECT ORIENTED DESIGN WITH THE CAESERCIPHER CLASSES AND RESPECTIVE TEST CLASSES
i.e.,
CaesarCipher
CaesarCipherTwo
TestCaesarCipher
TestCaesarCipherTwo
 */

public class TestCaesarCipherTwo {
	
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
	
/*	public String encryptTwoKeys(String input, int key1, int key2 ) {
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
	*/
	public void breakCaesarCipher(String input) {
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
		CaesarCipherTwo ct = new CaesarCipherTwo(key1, key2);
		System.out.println(ct.decrypt(input));
		//System.out.println(cc.encryptTwoKeys(input, 24, 6));
	}
	
/*	public void breakCaesarCipher(String input) {
		int[] counts = countLetters(input);
		int key = maxIndex(counts) - 4;
		//System.out.println(key);
		CaesarCipherTwo cc = new CaesarCipherTwo(key1, key2);
		//cc.decrypt(input);
		System.out.println(cc.decrypt(input));
	}
*/
	public void simpleTests() {
		//FileResource fr = new FileResource();
		CaesarCipherTwo cc = new CaesarCipherTwo(21,8);
		//System.out.println(fr.asString());
		//String encryptedMessage = cc.encrypt(fr.asString());
		String encryptedMessage = cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
		System.out.println(encryptedMessage);
		System.out.println(cc.decrypt(encryptedMessage));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestCaesarCipherTwo test = new TestCaesarCipherTwo();
		//test.simpleTests();
		//test.breakCaesarCipher("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
		test.breakCaesarCipher("Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin\n" + 
				"\n" + 
				"Sei sw klv deec lrpcqrvbw sw fyi jytgvwj yej sivr jiyzxwyc tscprffvrxzsew edsek hzjwiiiex kisltj nmklzr xyi hvtrvkqvrk, azxy iijirvtl kisltj zr sklvv hvtrvkqvrkw ek Uybi, nmkl sklvv mewkmkykij, eeh azxy zruyjxic. Rw av dsmi mexf klv zrwsiqrxzse rkv, xyi jfglw sw jgziegv zw wymwxzrx wvfq xyi hzwtsmiic sw ein zrwsiqrxzse ks xyi gfqgykekmfrrpcc mexvrjmmi xrwb fj tistijwzrx rru rrrppdzrx zrwsiqrxzse.\n" + 
				"\n" + 
				"Ni lrzv fykwkeehzrx gvfkiedw me xifqvximt tsdtlxzrx; mexvveik jcjxvqj, rvxnsiozrx, eeh wvglvzxp; fzscsxmtec tsdtlxzrx; qvqfvp jcjxvqj rru dejwzzv ueke qrrrkvqvrk; eeh pveirzrx rru dsuicmek. Klv iijirvtl mexvvvwkw sw fyi wetycxp fzvvceg nmkl xyiji eiirw eeh azxy iijirvtlvv eiirw me fxyii umjgztcmeij jytl ej smfpfkp, iekzrviimek, eeeskitlescsxc, rru vrmmiseqvrkec jgziegvw.\n" + 
				"\n" + 
				"GJ Uigx Tysks Av rpjs hf nsio me r eydfvv sw fxyii zqgsixrrk rvvej zrtplhzrx tsdtlxvv kieglzgj rru mmjyrpzdrxzse, wvrjsi eikafvbw, eydiimtec rrrppwzw, jswxneii iekzrviimek, tsdtciomkc xyifvp, eeh vfffxzgj.\n" + 
				"\n" + 
				"Klv uigeixdiex mj rvxyrfcc yemhyv zr xyi wpqsmfwzw xyek vbzwkw fvxnivr xyi iuytekmfr kislt eeh xyi vvwveigy wetycxp. Xyi wprvvxc fvxnivr xyid yej sivr e ovc xf klv jytgvwj zr gfrkmeyrpcc vvjfvdmek xyi glvimtycyd rru zrkixvrxzrx iijirvtl eeh iuytekmfr. Klv uigeixdiex mj lwzrx r uyrp egtisrgy ks gfqsmei vvwveigy rru vhlgrxzse. Fimekzrx iijirvtl mexf klv tyivzglplq mj klv sijx arc xf kvrme jxlhvrkw esslx xyi qfwk rhmeegvh xvgyrfpfkp rru ks hzwjidmeeki xyi prxvwk uimicsgqvrkw sw tsdtlxzrx kitlescsxc me jstmvxp.\n" + 
				"\n" + 
				"TW Hvtk Glfxf Ni iegfyiexi yehvvxvrhleki wkyuiexj ks kvx mezfpmiu nmkl sekfmek qrnfv vvwveigy gvfnvgkw xyvfyxl xyi G-WLVW gvfkied, yehvvxvrhleki xyijij, Vvwveigy Vbgiimvrti jfv Yehvvxvrhlekij (VVY) jygtfvk, mehvtvruiex wkyumvw, vxt. Wfqv fj slv iogvtkmfrrp jzvjx qrnfvj xvrhleki azxy umjxzrtxzse, aymtl mezfpmij r jmxrzjzgrrk iijirvtl gfqgseiex, rru zr qrrp tejij klv iijirvtl lrw vvwlpkiu zr tlfcmtekmfrj zr pveumek gfrwiiiegvw.\n" + 
				"\n" + 
				"Xyi idmeiegv fj slv vvwveigy rru kirgymek jrglpkc mj klv smxkvwk jxiiekkl sw klv uigeixdiex. Deec jrglpkc qvqsiiw lrzv sivr vvgfkemqiu sskl ek lrzzvvjmkc eeh rrxzseec cimicw jfv xyizv iogvpciegv zr vvwveigy, iuytekmfr, rru jiizzgv. Lzkypp mmjmspv, qlpkmumjgztcmeeic tisaitxj rvv sizrx tsehlgkiu, wgsewfvvh fp meimfyj wyehzrx rkvrtmvw.\n" + 
				"\n" + 
				"Xyi hvtrvkqvrk gvfzzhvw ee vbkvvqvpp jxzqlprxzrx, tisuytxzzv, eeh jimvrupp vrmmiseqvrk zr xyi jfvd fj gcejwisfq, fjwmti, rru ces jtrgv; gfqgykmek mejiejxiytxlvv; xvetlzrx jygtfvk; eeh kieuyrxv wicpfajlztj rru rwjmjxrrkwymgw. Zx ieespvw jrglpkc eeh wkyuiexj ks etgfqgpzwy klvmi wycp tfxvrkmrp. Klv uigeixdiex mj tsewkvlgkiu ks iegfyiexi merfzrxzzv tscprffvrxzsew edsek xyi wtmvrtij, iekzrviimek, vrmmiseqvrkec jxlhzij, eeh qvhzgzrv.\n" + 
				"");
	}

}
