package misc;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

//@RunWith(PowerMockRunner.class)
public class TestBadLegacyCode {

	private BadLegacy bl;
	private static final String STR1 = "Fizz";
	private static final String STR2 = "Buzz";
	private long startTime;
	private long endTime;
	private static long totalStartTime;
	private static long totalEndTime;

	@Before
	public void before() {
		this.startTime = System.nanoTime();
		this.bl = new BadLegacy();
	}

	@After
	public void after() {
		this.endTime = System.nanoTime();
		long time = (this.endTime - this.startTime) / 1000000;
		System.out.println("TEST EXECUTION TIME: " + time + " ms");
		System.out.println("------------------------");
	}

	@BeforeClass
	public static void beforeClass() {
		totalStartTime = System.nanoTime();
	}

	@AfterClass
	public static void afterClass() {
		totalEndTime = System.nanoTime();
		long totalTime = (totalEndTime - totalStartTime) / 1000000;
		System.out.println("TOTAL EXECUTION TIME: " + totalTime + " ms");
		System.out.println("------------------------");
	}

	@Test
	public void testMerge1() {
		System.out.println("testMerge1");
		String merged = this.bl.merge1(STR1, STR2);
		assertEquals("FizzBuzz", merged);
	}

	@Test
	public void testMerge2() {
		System.out.println("testMerge2");
		String merged = this.bl.merge1(STR1, STR2);
		assertEquals("FizzBuzz", merged);
	}

	@Test
	@Ignore
	public void testMerge3() {
		System.out.println("testMerge3");
		String merged = this.bl.merge1(STR1, STR2);
		assertEquals("FizzBuzz", merged);
	}

	@Test
	public void testMerge4() {
		System.out.println("testMerge4");
		String merged = this.bl.merge1(STR1, STR2);
		assertEquals("FizzBuzz", merged);
	}

}
