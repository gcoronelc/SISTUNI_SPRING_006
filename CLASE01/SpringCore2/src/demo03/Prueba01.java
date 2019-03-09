package demo03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Gustavo
 */
public class Prueba01 {

   public static void main(String[] args) {
      
      String xmlFile = "/demo03/contexto03.xml";
      BeanFactory bf; 
      bf = new ClassPathXmlApplicationContext(xmlFile);
      
      MateFacade facade;
      facade = bf.getBean(MateFacade.class);
      
      System.out.println("7 + 8 = " + facade.sumar(7, 8));
      
   }
   
}
