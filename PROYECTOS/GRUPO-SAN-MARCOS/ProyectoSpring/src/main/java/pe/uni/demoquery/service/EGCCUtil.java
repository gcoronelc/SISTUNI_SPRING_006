package pe.uni.demoquery.service;

import java.util.List;
import java.util.Map;

import pe.uni.demoquery.dto.ClienteDto;

public class EGCCUtil {
	
	public static String ListMapToString( List<Map<String,Object>> lista){
		String respuesta = "";
		if( lista.size() == 0 ){
			return respuesta;
		}
		// Columnas
		String[] columnas = lista.get(0).keySet().toArray(new String[0]);
		for (int i = 0; i < columnas.length; i++) {
			respuesta += columnas[i];
			if(i < (columnas.length - 1)){
				respuesta += "|";
			}
		}
		// Data
		respuesta += "¬";
		for (int fila = 0; fila < lista.size(); fila++) {
			Map<String,Object> rec = lista.get(fila);
			for (int i = 0; i < columnas.length; i++) {
				respuesta += rec.get(columnas[i]).toString();
				if(i < (columnas.length - 1)){
					respuesta += "|";
				}
			}
			// Insertar codito
			if(fila < (lista.size() - 1)){
				respuesta += "¬";
			}
		}
		return respuesta;
	}
	
	
	public static String ListClientesToString( List<ClienteDto> lista){
		String respuesta = "";
		if( lista.size() == 0 ){
			return respuesta;
		}
		// Columnas
		respuesta += "CODIGO|PATERNO|MATERNO|NOMBRE¬";
		// Data
		for (int fila = 0; fila < lista.size(); fila++) {
			ClienteDto rec = lista.get(fila);
			respuesta += rec.getCodigo() + "|";
			respuesta += rec.getPaterno() + "|";
			respuesta += rec.getMaterno() + "|";
			respuesta += rec.getNombre() + "|";
			// Insertar codito
			if(fila < (lista.size() - 1)){
				respuesta += "¬";
			}
		}
		return respuesta;
	}

}
