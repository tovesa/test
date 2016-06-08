package misc;

import java.util.Arrays;
import java.util.List;

public class Blaah {

	public static void main(String[] args) {

		Blaah b = new Blaah();
		System.out.println(b.genTest(Arrays.asList("a", "b", "c")));
		System.out.println(b.genTest(Arrays.asList(Integer.valueOf("2"), Integer.valueOf("3"))));
		System.out.println(b.genTest(Arrays.asList(Integer.valueOf("6"), "asd")));
	}

	private <T> String genTest(List<T> input) {
		StringBuilder sb = new StringBuilder();

		input.removeIf(element -> element.getClass().getSimpleName().equals("String"));
		for (T t : input) {
			sb.append(t.toString());
		}
		return sb.toString();
	}

}
