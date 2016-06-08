package misc;

public class BadLegacyCode {

	public static String mergeStrings1(String str1, String str2) {
		return str1 + str2;
	}

	public static String mergeStrings2(String str1, String str2) {
		return str1 + str2;
	}

	public final String mergeStrings3(String str1, String str2) {
		return str1 + str2;
	}

	public String mergeStrings4(String str1, String str2) {
		return str1 + str2;
	}

}
