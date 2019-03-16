package pe.uni.promedio.service;

import org.springframework.stereotype.Service;

@Service
public class MaterService {
	
	public double[] getPromedio(double n1, double n2, double n3, double n4){
		
		double total = n1 + n2 + n3 + n4;
		
		double[] myList = {n1, n2, n3, n4};
		
		double menorNota = myList[0];
		
		for(int i=0; i<myList.length; i++){
			if(myList[i]<menorNota){
				menorNota = myList[i];
			}
		}
		
		total = total -  menorNota;
		double promedio = total/3;
		
		double[] results =  { promedio, menorNota };
		return results;
	}
}
