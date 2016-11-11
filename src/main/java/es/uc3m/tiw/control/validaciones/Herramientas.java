package es.uc3m.tiw.control.validaciones;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class Herramientas {


	public static void anadirMensaje(HttpServletRequest request, String msg) {
		if (request.getAttribute("listaResultados") == null) {
			ArrayList<String> lista = new ArrayList<String>();
			lista.add(msg);
			request.setAttribute("listaResultados", lista);
		} else {
			ArrayList<String> lista = (ArrayList<String>) request.getAttribute("listaResultados");
			lista.add(msg);
			request.setAttribute("listaResultados", lista);
		}

	}

	public static boolean validarMail(String mail) {
		Pattern plantilla = Pattern.compile("^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,4}$");
		Matcher resultado = plantilla.matcher(mail);
		if(resultado.find()==true){
			return true;
		}else return false;
	}

	public static boolean validarPass(String pass) {
		Pattern plantilla = Pattern.compile("^[A-Za-z0-9._$%&/()= -#@\u00e1\u00c1\u00e9\u00c9\u00ed\u00cd\u00f3\u00d3\u00fa\u00da\u00fc\u00dc\u00f1\u00d1]+$");
		Matcher resultado = plantilla.matcher(pass);
		if(resultado.find()==true){
			return true;
		}else return false;
	}
	
	public static boolean validarNombre(String input) {
		Pattern plantilla = Pattern.compile("^[A-Z][a-zA-Z -\u00e1\u00c1\u00e9\u00c9\u00ed\u00cd\u00f3\u00d3\u00fa\u00da\u00fc\u00dc\u00f1\u00d1]+$");
		Matcher resultado = plantilla.matcher(input);
		if(resultado.find()==true){
			return true;
		}else return false;
	}


}
