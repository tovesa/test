package misc;

public class TestMain {

	public static void main(String[] args) {
		int seriesLength = parseArgs(args);
		long[] fibSeries = getFibs(seriesLength);
		printFibSeries(fibSeries);
	}

	private static void printFibSeries(long[] fibSeries) {
		long index = 0;
		for (long l : fibSeries) {
			System.out.println(index + ": " + l);
			index++;
		}
	}

	private static long[] getFibs(int serieLength) {

		long[] series = new long[serieLength];
		series[0] = 0;
		series[1] = 1;

		for (int i = 2; i < serieLength; ++i) {
			series[i] = series[i - 1] + series[i - 2];
		}
		return series;
	}

	protected static int parseArgs(String[] arguments) {
		if (arguments.length == 1) {
			return Integer.parseInt(arguments[0]);
		} else if (arguments.length == 0) {
			return 10;
		}

		throw new IllegalArgumentException("Illegal number of arguments: " + arguments.length);
	}
}