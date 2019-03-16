package pe.uni.demo03.service;

import org.springframework.stereotype.Service;

import pe.uni.demo03.bean.Notas;

@Service
public class MateService {
	
	public  Notas Promedio(int n1, int n2, int n3, int n4){
	    
	    Notas bean = new Notas();
	    
	    
		int[] myList = {n1,n2,n3,n4};
		
		int i, min = n1;
 
		min=myList[0];
 
		for(i = 1; i < myList.length; i++)
		{
			if(min>myList[i])
			{
				min=myList[i];
			}

		}
	    
		
		int promedio=((n1+n2+n3+n4)-min)/3;
		
	    
		 if(promedio>=14){
		     
		     bean.setEstado("APROBADO");
		     
		 }else{
		     
		     bean.setEstado("DESAPROBADO");
		 }
		
		 
		 bean.setNotasEliminadas(String.valueOf(min)); 
		 bean.setNotas(String.valueOf(n1)+"-"+String.valueOf(n2)+"-"+String.valueOf(n3)+"-"+String.valueOf(n4));
		 bean.setPromedio(String.valueOf(promedio));
		

	    
	    return bean;
	}

}
