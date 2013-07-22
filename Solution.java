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
}
