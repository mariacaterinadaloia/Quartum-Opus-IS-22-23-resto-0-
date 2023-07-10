package gestore.control;

import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

@WebServlet(name = "CatalogoAdminController", value = "/CatalogoAdminController")
public class CatalogoAdminController extends HttpServlet {
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminPageCatalog.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
