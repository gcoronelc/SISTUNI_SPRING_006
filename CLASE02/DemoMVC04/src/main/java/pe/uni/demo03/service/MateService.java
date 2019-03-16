package pe.uni.demo03.service;

import java.util.Arrays;
import org.springframework.stereotype.Service;
import pe.uni.demo03.bean.NotasDto;

@Service
public class MateService {
	
	public  NotasDto promediar(NotasDto dto){
       
		// Proceso
		int[] myList = {dto.getNota1(), dto.getNota2(), dto.getNota3(), dto.getNota4()};
		Arrays.sort(myList);
		int menor = myList[0];
		int suma = Arrays.stream(myList).sum();
		int promedio=(suma - menor)/3;
		String estado = (promedio>=14?"Aprobado":"Desaprobado");
		
		// Reporte
		dto.setMenor(menor);
		dto.setPromedio(promedio);
		dto.setEstado(estado);
		
		return dto;
	}

}
