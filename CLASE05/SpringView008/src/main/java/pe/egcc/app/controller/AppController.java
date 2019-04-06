package pe.egcc.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import pe.egcc.app.model.ProductoBean;
import pe.egcc.app.service.ProductoService;

/**
 * 
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 *
 */
@Controller
public class AppController {

  @Autowired
  protected ProductoService productoService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Model model) {
    List<ProductoBean> listaProductos = productoService.getListaProductos();
    model.addAttribute("listaProductos", listaProductos);
    return "listaProductos";
  }

  @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
  public ModelAndView getExcel() {
    List<ProductoBean> listaProductos = productoService.getListaProductos();
    return new ModelAndView("listaProductosExcelView", "listaProductos", listaProductos);
  }

  @RequestMapping(value = "/exportPdf", method = RequestMethod.GET)
  public ModelAndView getPdf() {
    List<ProductoBean> listaProductos = productoService.getListaProductos();
    return new ModelAndView("listaProductosPdfView", "listaProductos", listaProductos);
  }

  @RequestMapping(value = "/exportPdf2", method = RequestMethod.GET)
  public void getPdf2(HttpServletResponse response) throws Exception {
    List<ProductoBean> listaProductos = productoService.getListaProductos();
    
    Table table = new Table(4);
    table.addCell("ID");
    table.addCell("NOMBRE");
    table.addCell("PRECIO");
    table.addCell("STOCK");

    for (ProductoBean r : listaProductos) {

      table.addCell(String.valueOf(r.getId()));
      table.addCell(r.getNombre());
      table.addCell(String.valueOf(r.getPrecio()));
      table.addCell(String.valueOf(r.getStock()));

    }
    
    Document document = new Document();
    response.setContentType("Application/pdf");
    PdfWriter.getInstance(document, response.getOutputStream());
    document.open();
    document.add(table);
    document.close();
    
  }

}