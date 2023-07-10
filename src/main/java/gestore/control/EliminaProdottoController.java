package gestore.control;

import gestore.model.AutoreBean;
import gestore.model.AutoreDAO;
import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

@WebServlet(name = "EliminaProdottoController", value = "/EliminaProdottoController")
public class EliminaProdottoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codice = request.getParameter("id");
        Long ISBN = Long.parseLong(codice);
        ProdottoDAO dao = new ProdottoDAO();
        ProdottoBean bean = new ProdottoBean();
        Collection<ProdottoBean> coll = new LinkedList<ProdottoBean>();

        try{
            bean = dao.doRetrieveByKey(ISBN);
            dao.doModifyAcquistabile(bean);
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
