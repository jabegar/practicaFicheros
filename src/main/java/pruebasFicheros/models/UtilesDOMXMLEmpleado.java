package pruebasFicheros.models;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class UtilesDOMXMLEmpleado {
	private static final String RUTA_RESOURCES = "src/main/resources/";
	private static final Logger logger = LogManager.getLogger(UtilesDOMXMLEmpleado.class);
	private File ficheroEscribir;

	public UtilesDOMXMLEmpleado(String nombreFichero) {
		this.ficheroEscribir = new File(RUTA_RESOURCES, nombreFichero);
	}
	
	public void escribeEmpleadoEnXML(List<Empleado> empleados) {
		try {
			Document documento = this.generarDocumento("empleados");
			// Recupero la raíz del documento
			Element raiz = documento.getDocumentElement();
			for (Empleado e : empleados) {
				this.agregaEmpleadoADOM(documento, raiz, e);
				escribeDocumentoEnFichero(documento);
			}
		} catch (ParserConfigurationException e1) {
			logger.error(e1.getMessage());
		} catch (TransformerException e1) {
			logger.error(e1.getMessage());
		}
	}


	public Document generarDocumento(String nombreRaiz) throws ParserConfigurationException {
		Document documento = null;
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factoria.newDocumentBuilder();
		DOMImplementation implementacion = builder.getDOMImplementation();
		documento = implementacion.createDocument(null, nombreRaiz, null);
		return documento;
	}

	private void agregaEmpleadoADOM(Document documento, Element padre, Empleado e) {
		Element nombre = this.creaElemento("nombreApellido", e.getNombreApellido(), padre, documento);
		Element empresa = this.creaElemento("empresa", e.getEmpresa(), padre, documento);
		if (e.getIdentificador() != null) {
			padre.setAttribute("id", e.getIdentificador());
		}
		if (Integer.toString(e.getEdad()) != null) {
			Element edad = this.creaElemento("edad", Integer.toString(e.getEdad()), padre, documento);
		}
		
		Puesto p = e.getPuesto();
		Element puesto = documento.createElement("puesto");
		Element nombrePuesto = this.creaElemento("nombre", p.getNombre(), puesto, documento);
		Element salario = this.creaElemento("salario", Integer.toString(p.getSalario()), puesto, documento);
		
		if (p.getIdentificador() != null) {
			puesto.setAttribute("id", p.getIdentificador());
		}
		if (p.getDepartamento() != null) {
			Element departamento = this.creaElemento("departamento", p.getDepartamento(), puesto, documento);
		}
	}

	private Element creaElemento(String nombreElemento, String valorElemento, Element padre, Document documento) {
		Element elemento = documento.createElement(nombreElemento);
		Text texto = documento.createTextNode(valorElemento);
		padre.appendChild(elemento);
		elemento.appendChild(texto);
		return elemento;
	}
	
	private void escribeDocumentoEnFichero(Document documento) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(documento);
		StreamResult resultado = new StreamResult(this.ficheroEscribir);
		transformer.transform(source, resultado);
	}

}
