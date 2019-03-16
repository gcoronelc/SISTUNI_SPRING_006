package pe.uni.demo03.prueba;

import pe.uni.demo03.bean.NotasDto;
import pe.uni.demo03.service.MateService;

public class Prueba01 {
	
	public static void main(String[] args) {
		// Datos
		NotasDto dto = new NotasDto(15, 16, 12, 17);
		
		// Proceso
		MateService mateService = new MateService();
		dto = mateService.promediar(dto);
		
		// Reporte
		System.out.println("Menor: " + dto.getMenor());
		System.out.println("Promedio: " + dto.getPromedio());
		System.out.println("Estado: " + dto.getEstado());
	}
	
	
}
