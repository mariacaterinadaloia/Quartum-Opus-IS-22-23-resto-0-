package utente.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utente.model.ProdottoBean;
import utente.model.ProdottoDAO;
import utente.model.UtenteBean;

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
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Errore nei parametri della richiesta");
        }

        request.setAttribute("libro", libro);
        response.sendRedirect(response.encodeURL(request.getContextPath() + "/productPage.jsp"));
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
