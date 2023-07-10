package utente.control;

import gestore.model.OrdineBean;
import gestore.model.OrdineDAO;
import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

@WebServlet(name = "VisualizzaOrdiniController", value = "/VisualizzaOrdiniController")
public class VisualizzaOrdiniController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        OrdineDAO dao = new OrdineDAO();
        Collection<OrdineBean> coll = new LinkedList<OrdineBean>();
        try{
            coll = dao.doRetrieveByUser(email);
        } catch (SQLException e){
            e.printStackTrace();
        }

        request.setAttribute("ordini", coll);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/visualizzaOrdini.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
