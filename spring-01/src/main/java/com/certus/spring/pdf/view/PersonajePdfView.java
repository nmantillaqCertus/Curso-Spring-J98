package com.certus.spring.pdf.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.certus.spring.models.Personaje;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("Formulario")
public class PersonajePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Personaje personaje = (Personaje)model.get("personaje");
		
		//Construir el PDF
		PdfPTable table = new PdfPTable(1);
		table.addCell("Datos del Personaje");
		table.addCell("Nombre: "+personaje.getNombres());
		
		document.add(table);
		
	}

}
