package pruebasFicheros.models;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UtilesDomXML {
    private static final String RUTA_RESOURCES = "src/main/resources/";
	
    public Document getDocumentFromXML(String nombreFichero) {
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder;
         Document doc = null;
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse(new File(RUTA_RESOURCES + nombreFichero));
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 2. Leer el fichero XML
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         return doc;
	}
    
    public Libro fromElement2Libro(Element raiz) {
    	Libro libro = new Libro(raiz.getElementsByTagName("titulo").item(0).getTextContent());
    	libro.setAutor(raiz.getElementsByTagName("autor").item(0).getTextContent());
    	libro.setCategoria(raiz.getAttribute("categoria"));
    	libro.setId(raiz.getAttribute("id"));
    	libro.setEditorial(this.fromElement2Editorial((Element) raiz.getElementsByTagName("editorial").item(0)));
    	return libro;
    }
    
    public Editorial fromElement2Editorial(Element raiz) {
    	Editorial editorial = new Editorial();
    	editorial.setNombre(raiz.getElementsByTagName("nombre").item(0).getTextContent());
    	editorial.setCif(raiz.getElementsByTagName("cif").item(0).getTextContent());
    	return editorial;
    }
    
    public List<Libro> leerLibrosDesdeXML(Element raiz) {
    	List<Libro> libros = new ArrayList<Libro>();
    	NodeList librosElement = raiz.getElementsByTagName("libro");
    	
    	for (int i = 0; i < librosElement.getLength(); i++) {
			Libro libro = fromElement2Libro((Element)librosElement.item(i));
			libros.add(libro);
		}
    	
    	return libros;
    }
}
