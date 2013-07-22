import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution {
	public static Set<String> set = new LinkedHashSet<String>();
	public static boolean used[];

	
	public static void permute(int level, String permuted,
			boolean used[], String original, Set<String> set) {
		int length = original.length();
		if (level == length) {
			if(palindrom(permuted).compareTo(permuted) == 0) {
				if(!set.contains(permuted)) {
					set.add(permuted);
				}
			}
		} else {
			for (int i = 0; i < length; i++) {
				if (!used[i]) {
					used[i] = true;
					permute(level + 1, permuted + original.charAt(i),
							used, original, set);
					used[i] = false;
				}
			}
		}
	}

	public static String palindrom(String s) {
		String aux = new String("");
		if(s.length() == 1) {
			return s;
		} else {
			for(int i = s.length() - 1; i >= 0; i--) {
				aux += s.charAt(i);
			}
			return aux;
		}
	}
	
	public static void main(String[] args) {
		String s = getInput();
		
		permute(0, "", used, s, set);
		
		System.out.println((int) (set.size() % (Math.pow(10, 9) + 7)));
	}

	public static String getInput() {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		try {
			return stdin.readLine();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	private static void yesNo() {
		String input = getInput();
		StringTokenizer st = new StringTokenizer(input, " ");
		int[] in = new int[26];
		
		while(st.hasMoreTokens()) {
			String word = st.nextToken();
			for(int i = 0; i < word.length(); i++) {
				in[word.charAt(i) - '\0' - 97] ++;
			}
		}
		
		int isOdd = 0;
//		boolean isOK = false;
//		boolean isNotOK = false;
		used = new boolean[input.length()];
		for(int i = 0; i < input.length(); i++) {
			used[i] = false;
		}
		
		for(int i = 0; i < in.length; i++) {
			if(in[i] == 1) {
				isOdd ++;
			}
			if(in[i] > 1) {
				if(in[i] % 2 == 1) {
					if(isOdd == 0) {
//						isNotOK = false;
						permute(0, "", used, input.substring(0, (input.length() - 0) / 2), set);
					}
					else {
//						isOK = true;
//						isNotOK = true;
					}
				} else {
//					isOK = true;
				}
			}
		}

//		if(!isNotOK && isOK) {
//			System.out.println("YES");
//		} else {
//			System.out.println("NO");
//		}
	}
}
