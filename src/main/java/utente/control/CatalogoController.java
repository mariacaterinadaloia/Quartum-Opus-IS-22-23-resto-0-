package utente.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utente.model.ProdottoBean;
import utente.model.ProdottoDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

@WebServlet(name = "CatalogoController", value = "/CatalogoController")
public class CatalogoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdottoDAO dao = new ProdottoDAO();
        Collection<ProdottoBean> coll = new LinkedList<ProdottoBean>();
        try{
            coll = dao.doRetrieveAll();
        } catch (SQLException e){
            e.printStackTrace();
        }

        request.setAttribute("libri", coll);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/productList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
