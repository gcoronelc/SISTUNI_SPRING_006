package pe.egcc.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 *
 */
@Controller
public class SecondController {
  
  @RequestMapping(value="division.htm")
  public String doDividir(@RequestParam("n1") int n1, @RequestParam("n2") int n2, Model model){
    
    int rpta = n1 / n2;
    
    model.addAttribute("n1", n1);
    model.addAttribute("n2", n2);
    model.addAttribute("rpta", rpta);
    
    return "division/division";
    
  }

  
}
