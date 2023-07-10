package gestore.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;
import utente.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

@WebServlet(name = "ProductPageController", value = "/ProductPageController")
public class ProductPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long ISBN = Long.parseLong(request.getParameter("ISBN"));
        ProdottoDAO dao = new ProdottoDAO();
        ProdottoBean libro = new ProdottoBean();

        RecDiDAO recDiDAO = new RecDiDAO();
        Collection<RecDiBean> recDiBeanCollection = new LinkedList<RecDiBean>();
        ArrayList<RecensioneBean> recensioni = new ArrayList<RecensioneBean>();
        RecensioneDAO recDAO = new RecensioneDAO();
        RecDaBean recDaBean = new RecDaBean();
        RecDaDAO recDaDAO = new RecDaDAO();
        UtenteDAO utenteDAO = new UtenteDAO();

        try {
            libro = dao.doRetrieveByKey(ISBN);
        } catch (SQLException e){
            e.printStackTrace();
        }

        try{
            recDiBeanCollection = recDiDAO.doRetrieveByProduct(ISBN);
            for(RecDiBean x: recDiBeanCollection){
                RecensioneBean recensione = recDAO.doRetrieveByKey(x.getRecensione());
                RecDaBean bean = recDaDAO.doRetrieveByKey(x.getRecensione());
                UtenteBean utenteBean = utenteDAO.doRetrieveByKey(bean.getUtente());
                recensione.setNome(utenteBean.getNome());
                recensione.setCognome(utenteBean.getCognome());
                recensioni.add(recensione);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        request.setAttribute("libro", libro);
        request.setAttribute("recensioni", recensioni);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/productPage.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
