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
			String formattedLine = ConvertDates.formatDates(line, year);
			// TODO: format rest of the text
			formattedLines.add(formattedLine);
		}
		return formattedLines;
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
