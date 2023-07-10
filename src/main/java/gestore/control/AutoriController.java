package gestore.control;

import gestore.model.AutoreBean;
import gestore.model.AutoreDAO;
import gestore.model.OrdineBean;
import gestore.model.OrdineDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

@WebServlet(name = "AutoriController", value = "/AutoriController")
public class AutoriController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AutoreDAO dao = new AutoreDAO();
        Collection<AutoreBean> coll = new LinkedList<AutoreBean>();
        try{
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
        doGet(request, response);
    }
}
