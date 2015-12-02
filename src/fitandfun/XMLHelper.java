package fitandfun;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLHelper<T> {
	
<<<<<<< HEAD
	private XMLHelper()
	{
	}

	public static <T> void save(T instance, String filename) throws JAXBException
	{
		JAXBContext context = JAXBContext.newInstance(instance.getClass());
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    m.marshal(instance, new File(filename));
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T load(Class<T> typeClass, String filename) throws JAXBException, FileNotFoundException
	{
=======
	private XMLHelper() {
	}

	public static <T> void save(T instance, String filename) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(instance.getClass());
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    m.marshal(instance, new File(filename));
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T load(Class<T> typeClass, String filename) throws JAXBException, FileNotFoundException {
>>>>>>> branch 'master' of https://github.com/jexmaster/ProjectSE2015.git
		JAXBContext context = JAXBContext.newInstance(typeClass);
		Unmarshaller um = context.createUnmarshaller();
		return (T)um.unmarshal(new FileReader(filename));
	}
}
