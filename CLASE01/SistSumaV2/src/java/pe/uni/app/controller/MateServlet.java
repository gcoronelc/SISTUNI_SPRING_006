package pe.uni.app.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.uni.app.service.MateService;

/**
 *
 * @author Gustavo
 */
@WebServlet(name = "MateServlet", 
        urlPatterns = {"/MateSumar", "/MateRestar","/MateMultiplicar"})
public class MateServlet extends HttpServlet {

   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException {
      // Datos
      int num1 = Integer.parseInt(request.getParameter("num1"));
      int num2 = Integer.parseInt(request.getParameter("num2"));
      // Proceso
      MateService mateService = new MateService();
      int suma = mateService.sumar(num1, num2);
      // Reporte
      request.setAttribute("num1", num1);
      request.setAttribute("num2", num2);
      request.setAttribute("suma", suma);
      // Forward
      RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
      rd.forward(request, response);
   }

   
}
