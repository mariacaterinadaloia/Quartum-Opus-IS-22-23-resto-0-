package gestore.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import gestore.model.ProdottoBean;
import gestore.model.ProdottoDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductPageController", value = "/ProductPageController")
public class ProductPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long ISBN = Long.parseLong(request.getParameter("ISBN"));
        ProdottoDAO dao = new ProdottoDAO();
        ProdottoBean libro = new ProdottoBean();
        try {
            libro = dao.doRetrieveByKey(ISBN);
        } catch (SQLException e){
            e.printStackTrace();
        }

        request.setAttribute("libro", libro);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/productPage.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
