package br.com.gerenciador.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageView {
	public static void info(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", msg));
	}

	public static void error(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", msg));
	}

}
