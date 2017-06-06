package test.junit.sample.input.parser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * 
 * Common marshaller.
 *
 * @param <T>
 */
public class XMLDataParser<T> {

	/**
	 * Method to retrieve XML data from given XML file.
	 * 
	 * @param xmlFile
	 *            Cannot be null
	 * @param classType
	 *            Type to convert to, cannot be null.
	 * @return Not null.
	 * @throws Exception
	 */
	public T retrieveXMLData(File xmlFile, Class<T> classType) throws Exception {

		JAXBContext jaxbContext = JAXBContext.newInstance(classType);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		@SuppressWarnings("unchecked")
		T testInput = (T) jaxbUnmarshaller.unmarshal(xmlFile);
		return testInput;

	}

}
