package org.finastra.exam.app.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.finastra.exam.repository.data.Pacs008;

public class JaxbUnmarshaller {
	public static Pacs008 unmarshalPacs008(String filename) {
		Pacs008 pacs008 = new Pacs008();
		try {
	        File file = new File(filename);
	        JAXBContext jaxbContext = JAXBContext.newInstance(Pacs008.class);
	        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	        pacs008 = (Pacs008) unmarshaller.unmarshal(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pacs008;
	}
}
