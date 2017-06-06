package test.junit.sample;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import test.junit.sample.input.generated.TubeTestInput;
import test.junit.sample.input.generated.TubeTestInput.TestData;
import test.junit.sample.input.parser.XMLDataParser;

import com.tngtech.java.junit.dataprovider.DataProvider;

/**
 * 
 * Dataprovider class for Testing Tube App
 *
 */
public class TubeTestDataProvider {

	@DataProvider
	public static Object[] supplyTubeColor() {
		Object[] data = new Object[5];
		data[0] = new String("violet");
		data[1] = new String("blue");
		data[2] = new String("green");
		data[3] = new String("yellow");
		data[4] = new String("red");
		return data;
	}

	@DataProvider
	public static Object[] supplyTubeColor_XMLInput() throws Exception {

		String xmlFilePath = "src/test/resource/TestInputFile.xml";

		XMLDataParser<TubeTestInput> xmlParser = new XMLDataParser<TubeTestInput>();

		TubeTestInput testInput = xmlParser.retrieveXMLData(new File(
				xmlFilePath), TubeTestInput.class);

		List<Object> testDataList = new ArrayList<Object>();
		for (TestData testData : testInput.getTestData()) {
			testDataList.add(testData);
		}

		return testDataList.toArray(new Object[testDataList.size()]);

	}
}
