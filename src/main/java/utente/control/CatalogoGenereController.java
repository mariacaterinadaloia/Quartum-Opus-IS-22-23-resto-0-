package utente.control;

import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

@WebServlet(name = "CatalogoGenereController", value = "/CatalogoGenereController")
public class CatalogoGenereController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String genere = request.getParameter("genere");
        ProdottoDAO dao = new ProdottoDAO();
        Collection<ProdottoBean> coll = new LinkedList<ProdottoBean>();
        try{
            coll = dao.doRetrieveByGenre(genere);
        } catch (SQLException e){
            e.printStackTrace();
        }

        request.setAttribute("libri", coll);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/productList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
