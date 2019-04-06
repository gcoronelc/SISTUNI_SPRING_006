package pe.egcc.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import pe.egcc.app.model.ProductoBean;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

/**
 * 
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 *
 */
public class ListaProductosPdfView extends AbstractPdfView {

  @Override
  protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter write, HttpServletRequest request, HttpServletResponse response) throws Exception {

    @SuppressWarnings("unchecked")
    List<ProductoBean> listaProductos = (List<ProductoBean>) model.get("listaProductos");

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

    document.add(table);
  }

}
