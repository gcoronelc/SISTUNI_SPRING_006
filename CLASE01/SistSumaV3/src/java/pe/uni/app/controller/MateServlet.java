package pe.uni.app.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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
      Map<String,Integer> repo = new HashMap<>();
      repo.put("num1", num1);
      repo.put("num2", num2);
      repo.put("suma", suma);
      // Response
      Gson gson = new Gson();
      String cadenaJson = gson.toJson(repo);
      PrintWriter out = response.getWriter();
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      out.print(cadenaJson);
      out.flush();
   }

   
}
