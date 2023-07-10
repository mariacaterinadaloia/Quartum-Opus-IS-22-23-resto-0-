package gestore.control;

import gestore.model.OrdineBean;
import gestore.model.OrdineDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

@WebServlet(name = "OrdiniController", value = "/OrdiniController")
public class OrdiniController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrdineDAO dao = new OrdineDAO();
        Collection<OrdineBean> coll = new LinkedList<OrdineBean>();
        try{
            coll = dao.doRetrieveAll();
        } catch (SQLException e){
            e.printStackTrace();
        }

        request.setAttribute("ordini", coll);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminPageOrders.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
