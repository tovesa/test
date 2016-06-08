package misc;

public class BadLegacy {

	private BadLegacyCode blc = new BadLegacyCode();

	public BadLegacy(BadLegacyCode blc1) {
		this.blc = blc1;
	}

	public BadLegacy() {
	}

	public String merge1(String str1, String str2) {
		return BadLegacyCode.mergeStrings1(str1, str2);
	}

	public String merge2(String str1, String str2) {
		return BadLegacyCode.mergeStrings2(str1, str2);
	}

	public String merge3(String str1, String str2) {
		return this.blc.mergeStrings3(str1, str2);
	}

	public String merge4(String str1, String str2) {
		return this.blc.mergeStrings4(str1, str2);
	}

}
