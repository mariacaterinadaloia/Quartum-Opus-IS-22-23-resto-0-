package gestore.control;

import gestore.model.AutoreBean;
import gestore.model.AutoreDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

@WebServlet(name = "EliminaAutoreController", value = "/EliminaAutoreController")
public class EliminaAutoreController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codice = request.getParameter("id");
        AutoreDAO dao = new AutoreDAO();
        Collection<AutoreBean> coll = new LinkedList<AutoreBean>();

        try{
            dao.doDeleteByKey(codice);
            coll = dao.doRetrieveAll();
        } catch (SQLException e){
            e.printStackTrace();
        }

        request.setAttribute("autori", coll);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminPageAuthors.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
