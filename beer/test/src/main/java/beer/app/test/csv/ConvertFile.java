package beer.app.test.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertFile {

	public static void main(String args[]) {

//		int year = 2013;
//		String fileName = "beers2013.txt";
//		String newFileName = "beers2013_new.txt";

		String year = "2013";
		String extension = ".txt";
		String fileName = "beers"+year+extension;
		String newFileName = "beers"+year+"_new"+extension;
		
		ConvertFile m = new ConvertFile();

		List<String> lines = m.readFile(fileName);

		List<String> formattedLines = m.formatLines(lines, year);

		for (int i = 0; i < lines.size(); i++) {
			System.out.println("old: " + lines.get(i));
			System.out.println("new: " + formattedLines.get(i));
			System.out.println("-----------");
		}

		//m.writeFile(newFileName, formattedLines);
	}

	protected List<String> formatLines(List<String> lines, String year) {

		List<String> formattedLines = new ArrayList<String>();
		for (String line : lines) {
			String formattedLine = formatDates(line, year);
			// TODO: format rest of the text
			formattedLines.add(formattedLine);
		}
		return formattedLines;
	}

	protected String formatDates(String line, String year) {
		// d.m. --> yyyy-mm-dd
		// d.mm. --> yyyy-mm-dd
		// dd.m. --> yyyy-mm-dd
		// dd.mm. --> yyyy-mm-dd

		// d.m --> yyyy-mm-dd
		// d.mm --> yyyy-mm-dd
		// dd.m --> yyyy-mm-dd
		// dd.mm --> yyyy-mm-dd

		// d.m.yy. --> yyyy-mm-dd
		// d.mm.yy. --> yyyy-mm-dd
		// dd.m.yy. --> yyyy-mm-dd
		// dd.mm.yy. --> yyyy-mm-dd

		// d.m.yy --> yyyy-mm-dd
		// d.mm.yy --> yyyy-mm-dd
		// dd.m.yy --> yyyy-mm-dd
		// dd.mm.yy --> yyyy-mm-dd

		// d.m.yyyy. --> yyyy-mm-dd
		// d.mm.yyyy. --> yyyy-mm-dd
		// dd.m.yyyy. --> yyyy-mm-dd
		// dd.mm.yyyy. --> yyyy-mm-dd

		// d.m.yyyy --> yyyy-mm-dd
		// d.mm.yyyy --> yyyy-mm-dd
		// dd.m.yyyy --> yyyy-mm-dd
		// dd.mm.yyyy --> yyyy-mm-dd

		// m-yyyy --> yyyy-mm
		// mm-yyyy --> yyyy-mm

		// ddmmyyyy --> yyyy-mm-dd

		String formattedLine = line;
		formattedLine = ConvertFile.dateFormatter1(formattedLine);
		formattedLine = ConvertFile.dateFormatter2(formattedLine);
		formattedLine = ConvertFile.dateFormatter3(formattedLine);
		formattedLine = ConvertFile.dateFormatter4(formattedLine, year);
		return formattedLine;
	}

	/**
	 * ddmmyyyy --> yyyy-mm-dd
	 * 
	 * @param date
	 * @return date in yyyy-MM-dd format
	 * 
	 */
	protected static String dateFormatter1(String date) {
		Pattern p = Pattern.compile("\\d{8}");
		Matcher m = p.matcher(date);
		StringBuffer sb = new StringBuffer();

		while (m.find()) {
			String text = m.group();
			StringBuffer formattedDate = new StringBuffer();
			formattedDate.append(text.substring(4, 8));
			formattedDate.append("-");
			formattedDate.append(text.substring(2, 4));
			formattedDate.append("-");
			formattedDate.append(text.substring(0, 2));
			m.appendReplacement(sb, formattedDate.toString());
		}
		m.appendTail(sb);
		String ret = sb.toString().replaceFirst("\\s+$", "");
		return ret;
	}

	/**
	 * dd.mm.yyyy --> yyyy-mm-dd d.m.yyyy --> yyyy-mm-dd d.m.yy --> yyyy-mm-dd
	 * 
	 * Two first digits of the year are expected to be '20'. One digit month
	 * and/or day are filled with leading '0'.
	 * 
	 * @param date
	 * @return date in yyyy-MM-dd format
	 * 
	 */
	protected static String dateFormatter2(String date) {
		Pattern p = Pattern.compile("\\d{1,2}\\.\\d{1,2}\\.\\d{2,4}");
		Matcher m = p.matcher(date);
		StringBuffer sb = new StringBuffer();

		while (m.find()) {
			String text = m.group();
			int firstDot = text.indexOf(".");
			int lastDot = text.lastIndexOf(".");

			StringBuffer year = new StringBuffer();
			StringBuffer month = new StringBuffer();
			StringBuffer day = new StringBuffer();
			year.append(text.substring(lastDot + 1, text.length()));
			month.append(text.substring(firstDot + 1, lastDot));
			day.append(text.substring(0, firstDot));

			if (year.length() < 4) {
				year.insert(0, "20");
			}

			if (month.length() < 2) {
				month.insert(0, "0");
			}

			if (day.length() < 2) {
				day.insert(0, "0");
			}
			StringBuffer formattedDate = new StringBuffer();
			formattedDate.append(year);
			formattedDate.append("-");
			formattedDate.append(month);
			formattedDate.append("-");
			formattedDate.append(day);

			m.appendReplacement(sb, formattedDate.toString());
		}
		m.appendTail(sb);
		String ret = sb.toString().replaceFirst("\\s+$", "");
		return ret;
	}

	/**
	 * dd.mm --> yyyy-mm-dd d.m --> yyyy-mm-dd
	 * 
	 * One digit month and/or day are filled with leading '0'.
	 * 
	 * @param date
	 * @param year
	 * @return date in yyyy-MM-dd format
	 * 
	 */
	protected static String dateFormatter4(String date, String year) {
		Pattern p = Pattern.compile("\\d{1,2}\\.\\d{1,2}");
		Matcher m = p.matcher(date);
		StringBuffer sb = new StringBuffer();

		while (m.find()) {
			String text = m.group();
			int dot = text.indexOf(".");

			StringBuffer month = new StringBuffer();
			StringBuffer day = new StringBuffer();
			month.append(text.substring(dot + 1, text.length()));
			day.append(text.substring(0, dot));

			if (month.length() < 2) {
				month.insert(0, "0");
			}

			if (day.length() < 2) {
				day.insert(0, "0");
			}

			StringBuffer formattedDate = new StringBuffer();
			formattedDate.append(year);
			formattedDate.append("-");
			formattedDate.append(month);
			formattedDate.append("-");
			formattedDate.append(day);

			m.appendReplacement(sb, formattedDate.toString());
		}
		m.appendTail(sb);
		String ret = sb.toString().replaceFirst("\\s+$", "");
		return ret;
	}

	/**
	 * mm.yyyy --> yyyy-mm m.yyyy --> yyyy-mm
	 * 
	 * One digit month is filled with leading '0'.
	 * 
	 * @param date
	 * @param year
	 * @return date in yyyy-MM format
	 * 
	 */
	protected static String dateFormatter3(String date) {
		Pattern p = Pattern.compile("\\d{1,2}\\.\\d{4}");
		Matcher m = p.matcher(date);
		StringBuffer sb = new StringBuffer();

		while (m.find()) {
			String text = m.group();
			int dot = text.indexOf(".");
			StringBuffer year = new StringBuffer();
			StringBuffer month = new StringBuffer();
			year.append(text.substring(dot + 1, dot + 5));
			month.append(text.substring(0, dot));

			if (month.length() < 2) {
				month.insert(0, "0");
			}

			StringBuffer formattedDate = new StringBuffer();
			formattedDate.append(year);
			formattedDate.append("-");
			formattedDate.append(month);

			m.appendReplacement(sb, formattedDate.toString());
		}
		m.appendTail(sb);
		String ret = sb.toString().replaceFirst("\\s+$", "");
		return ret;
	}

	protected List<String> readFile(String fileName) {

		List<String> lines = new ArrayList<String>();

		BufferedReader br = null;
		try {
			File file = new File(fileName);
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					file), "UTF8"));
			String line = br.readLine();

			while (line != null) {
				lines.add(line);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Exception: " + e);
			}
		}
		return lines;
	}

	protected void writeFile(String newFileName, List<String> formattedLines) {
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(newFileName), "utf-8"));
			for(String line : formattedLines) {
				writer.write(line+"\n");
			}
		} catch (IOException e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
			}
		}

	}
}
