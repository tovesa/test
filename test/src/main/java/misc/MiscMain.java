package misc;

import java.util.Arrays;
import java.util.List;

public class MiscMain {

	public static void main(String[] args) {
		String s = parseArgs(args);
		int value = add(s);
		System.out.println("Value: " + value);
	}

    protected static String parseArgs(String[] args) {
		if(args.length == 1) {
			return args[0];
		}
		
		throw new IllegalArgumentException("Illegal number of arguments: " + args.length);
	}

	protected static int add(String str) {      
		int returnValue = 0;
        List<String> numbers =  parseString(str);
        returnValue = doAdd(numbers);
        
        return returnValue;
    }

	protected static List<String> parseString(String str) {
		String[] subStrings = null;
		subStrings = str.split(",|:");

		return Arrays.asList(subStrings);
	}

	protected static int doAdd(List<String> numbers) {
		int returnValue = 0;
		for(String n : numbers) {
			returnValue += Integer.parseInt(n);
		}
		return returnValue;
	}
}
