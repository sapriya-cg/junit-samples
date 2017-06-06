package test.junit.sample;

import junit.framework.TestCase;
import junit.sample.Tube;

import org.junit.Test;
import org.junit.runner.RunWith;

import test.junit.sample.input.generated.TubeTestInput.TestData;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class TubeTest extends TestCase {

	private Tube toTest = new Tube();

	/**
	 * Test using normal parameters.
	 * 
	 * @param data
	 *            Cannot be null
	 */
	@Test
	@UseDataProvider(value = "supplyTubeColor", location = TubeTestDataProvider.class)
	public void testGlow(Object data) {
		System.out.println("Received for testing:" + data);

		assertTrue(toTest.glow((String) data));
	}

	/**
	 * Test using XML input parameters.
	 * 
	 * @param data
	 *            Cannot be null
	 */
	@Test
	@UseDataProvider(value = "supplyTubeColor_XMLInput", location = TubeTestDataProvider.class)
	public void testGlow_XMLInput(Object data) {
		TestData testData = (TestData) data;
		System.out.println("Received for testing:" + testData.getColor());

		assertEquals(Boolean.parseBoolean(testData.getSupported()),
				toTest.glow(testData.getColor()));
	}
}
