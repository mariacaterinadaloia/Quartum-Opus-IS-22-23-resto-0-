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

@WebServlet(name = "InitServlet", value = "/InitServlet", loadOnStartup = 0)
public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ProdottoDAO dao = new ProdottoDAO();
        Collection<ProdottoBean> coll = new LinkedList<ProdottoBean>();
        try{
            coll = dao.doRetrieveAll();
        } catch (SQLException e){
            e.printStackTrace();
        }
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("listaLibri", coll);
        super.init();
    }
}
