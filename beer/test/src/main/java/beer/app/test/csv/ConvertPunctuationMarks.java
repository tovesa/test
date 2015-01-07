package beer.app.test.csv;


public class ConvertPunctuationMarks {

	public static String formatPunctuationMarks(String line, String character) {

		String formattedLine = line;
		formattedLine = dotFormatter(formattedLine);
		return formattedLine;
	}

	/**
	 * 
	 */
	protected static String dotFormatter(String line) {

		StringBuffer sb = new StringBuffer();
		sb.append(line);
		String ret = sb.toString();
		return ret;
	}

}
