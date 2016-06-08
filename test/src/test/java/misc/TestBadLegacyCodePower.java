package misc;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replay;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(BadLegacyCode.class)
public class TestBadLegacyCodePower {

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
	public void testMergeStrings1() {
		System.out.println("testMerge1");
		mockStatic(BadLegacyCode.class);
		expect(BadLegacyCode.mergeStrings1(STR1, STR2)).andReturn("PowerMockedFizzBuzz");
		replay(BadLegacyCode.class);
		String merged = this.bl.merge1(STR1, STR2);
		assertEquals("PowerMockedFizzBuzz", merged);
	}

	@Test
	public void testMergeStrings2() {
		System.out.println("testMerge2");
		mockStatic(BadLegacyCode.class);
		expect(BadLegacyCode.mergeStrings1(STR1, STR2)).andReturn("PowerMockedFizzBuzz");
		replay(BadLegacyCode.class);
		String merged = this.bl.merge1(STR1, STR2);
		assertEquals("PowerMockedFizzBuzz", merged);
	}

	@Test
	public void testMergeStrings3() {
		System.out.println("testMerge3");
		String merged = this.bl.merge3(STR1, STR2);
		assertEquals("FizzBuzz", merged);
	}

	@Test
	public void testMergeStrings4() {
		System.out.println("testMerge4");
		String merged = this.bl.merge4(STR1, STR2);
		assertEquals("FizzBuzz", merged);
	}

}
