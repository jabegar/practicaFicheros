package pruebasFicheros.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import pruebasFicheros.models.Libro;
import pruebasFicheros.models.UtilesDomXML;

public class EjemploDOM {
    private static final String RUTA_RESOURCES = "src/main/resources/";
    private static final Logger logger = LogManager.getLogger(EjemploDOM.class);
    public static void main(String[] args) {
    	UtilesDomXML udx = new UtilesDomXML();
    	
    	Document doc = udx.getDocumentFromXML("libros.xml");
    	Element raiz = doc.getDocumentElement();
    	List<Libro> libros = udx.leerLibrosDesdeXML(raiz);
    	logger.debug(libros);
    }
}
