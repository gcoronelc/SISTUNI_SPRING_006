package pe.uni.demo03.service;

import org.springframework.stereotype.Service;

@Service
public class MateService {
	
	public double promedio(int n1, int n2, int n3, int n4){
		return ((n1 + n2+ n3 + n4)/4);
	}
	
	public String Situación(double prom){
		String situa="Aprobado";
		if(prom<14){
			situa="Desaprobado";
		}
		
		
		return (situa);
	}

}
