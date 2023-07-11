package gestore.control;

import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;
import gestore.model.ScrittoDaBean;
import gestore.model.ScrittoDaDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "InserisciProdottoController", value = "/InserisciProdottoController")
public class InserisciProdottoController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Long ISBN = Long.parseLong(request.getParameter("isbn"));
        String nome = request.getParameter("nome");
        String genere = request.getParameter("genere");
        if(request.getParameter("anno") == null || request.getParameter("edizione") == null || request.getParameter("prezzo") == null){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato errato!");
            return;
        }
        int anno = Integer.parseInt(request.getParameter("anno"));
        int edizione = Integer.parseInt(request.getParameter("edizione"));
        String copertina = request.getParameter("copertina");
        String casaEditrice = request.getParameter("casa");
        double prezzo = Double.parseDouble(request.getParameter("prezzo"));
        String codiceAutore = request.getParameter("codiceAutore");
        String link = request.getParameter("link");

        if(ISBN == null || nome == null || genere == null || copertina == null || casaEditrice == null || codiceAutore == null){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato errato!");
            out.print("Errore.");
            return;
        }

        ProdottoBean bean = new ProdottoBean();
        bean.setISBN(ISBN);
        bean.setNome(nome);
        bean.setGenere(genere);
        bean.setAnno(anno);
        bean.setEdizione(edizione);
        bean.setCopertina(copertina);
        bean.setCasaEditrice(casaEditrice);
        bean.setPrezzo(prezzo);
        bean.setAcquistabile(true);
        bean.setLink(link);

        ProdottoDAO pdao = new ProdottoDAO();
        try{
            pdao.doInsert(bean);
        } catch(SQLException e){
            e.printStackTrace();
        }

        ScrittoDaDAO sdao = new ScrittoDaDAO();
        ScrittoDaBean sbean = new ScrittoDaBean();
        sbean.setProdotto(ISBN);
        sbean.setAutore(codiceAutore);
        try{
            sdao.doInsert(sbean);
        } catch(SQLException e){
            e.printStackTrace();
        }
        out.print("Successo.");
        response.sendRedirect(request.getContextPath() + "/CatalogoAdminController");
    }
}
