package utente.control;

import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utente.model.ContieneBean;
import utente.model.ContieneDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

@WebServlet(name = "VisualizzaDettaglioOrdineController", value = "/VisualizzaDettaglioOrdineController")
public class VisualizzaDettaglioOrdineController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idOrdine = Integer.parseInt(request.getParameter("id"));
        ContieneDAO cd = new ContieneDAO();
        ArrayList<ContieneBean> list = new ArrayList<ContieneBean>();
        try{
            list = cd.doRetrieveByOrderId(idOrdine);
        } catch (SQLException e){
            e.printStackTrace();
        }

        ProdottoDAO dao = new ProdottoDAO();
        Collection<ProdottoBean> coll = new LinkedList<ProdottoBean>();
        for (ContieneBean x: list) {
            try{
                coll.add(dao.doRetrieveByKey(x.getProdotto()));
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        request.setAttribute("libri", coll);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/visualizzaDettaglioOrdine.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
