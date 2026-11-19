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

public class UtilesDOMPelicula {
	public Document getDocumentFromXML(File f) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc = null;
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse(f);
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

	public List<Pelicula> leerPeliculas(Element raiz) {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		NodeList peliculasNode = raiz.getElementsByTagName("Pelicula");
		for (int i = 0; i < peliculasNode.getLength(); i++) {
			Pelicula p = fromElement2Pelicula((Element) peliculasNode.item(i));
			peliculas.add(p);
		}

		return peliculas;
	}

	private Pelicula fromElement2Pelicula(Element item) {
		Pelicula p = null;
		String titulo = item.getElementsByTagName("Titulo").item(0).getTextContent();
		p = new Pelicula(titulo);
		

		if (item.getElementsByTagName("Duracion").getLength() > 0) {			
			int duracion = Integer.parseInt(item.getElementsByTagName("Duracion").item(0).getTextContent());
			p.setDuracion(duracion);
		} 
		if (item.getElementsByTagName("Genero").getLength() > 0) {
			String genero = item.getElementsByTagName("Genero").item(0).getTextContent();
			p.setGenero(genero);
		}
		if (item.getElementsByTagName("sinopsis").getLength() > 0) {
			String sinopsis = item.getElementsByTagName("sinopsis").item(0).getTextContent();
			p.setSinopsis(sinopsis);
		}
		if (item.getElementsByTagName("Fecha").getLength() > 0) {
			String fecha = item.getElementsByTagName("Fecha").item(0).getTextContent();
			p.setFecha(fecha);
		}
		if (item.getElementsByTagName("Director").getLength() > 0) {			
			String director = item.getElementsByTagName("Director").item(0).getTextContent();
			p.setDirector(director);
		}
		
		NodeList actoresNode = item.getElementsByTagName("Actores").item(0).getChildNodes();
		
		for (int i = 0; i < actoresNode.getLength(); i++) {
			p.addActor(actoresNode.item(i).getTextContent());
		}


		return p;
	}
}
