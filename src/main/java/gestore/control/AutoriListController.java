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

@WebServlet(name = "AutoriListController", value = "/AutoriListController")
public class AutoriListController extends HttpServlet {
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/insertProduct.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
