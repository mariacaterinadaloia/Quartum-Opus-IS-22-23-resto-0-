package utente.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utente.model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "InserisciRecensioneController", value = "/InserisciRecensioneController")
public class InserisciRecensioneController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recensione = request.getParameter("testoRec");
        String mail = request.getParameter("mail");
        Long ISBN = Long.parseLong(request.getParameter("ISBN"));
        PrintWriter out = response.getWriter();
        if(recensione == null){
            out.print("Errore nell'inserimento");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Recensione vuota!");
            return;
        }

        RecensioneDAO dao = new RecensioneDAO();
        RecDaDAO dao1 = new RecDaDAO();
        RecDiDAO dao2 = new RecDiDAO();

        RecensioneBean bean = new RecensioneBean();
        RecDaBean bean1 = new RecDaBean();
        RecDiBean bean2 = new RecDiBean();

        bean.setText(recensione);
        int recId =0;
        try{
            dao.doInsert(bean);
            recId = dao.doGetLatestId();
        } catch (SQLException e){
            e.printStackTrace();
        }

        bean1.setRecensione(recId);
        bean1.setUtente(mail);
        try{
            dao1.doInsert(bean1);
        } catch (SQLException e){
            e.printStackTrace();
        }

        bean2.setRecensione(recId);
        bean2.setProdotto(ISBN);
        try{
            dao2.doInsert(bean2);
        } catch (SQLException e){
            e.printStackTrace();
        }

        out.print("Recensione inserita con successo");
        String url = "/VisualizzaOrdiniController?email=" + mail;
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
