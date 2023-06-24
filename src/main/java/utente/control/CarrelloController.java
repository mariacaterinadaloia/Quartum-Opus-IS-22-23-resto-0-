package utente.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utente.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "CarrelloController", value = "/CarrelloController")
public class CarrelloController extends HttpServlet {
    private static final String insertError = "Errore nei campi di input";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ProdottoDAO model = new ProdottoDAO();

        Carrello cart = (Carrello) request.getSession().getAttribute("carrello");
        if(cart == null) {
            cart = new Carrello();
            request.getSession().setAttribute("carrello", cart);
        }

        String action = request.getParameter("action");


            if(action != null) {
                switch (action) {
                    case "addCart": {
                        long ISBN = Long.parseLong(request.getParameter("ISBN"));
                        ProdottoBean bean = new ProdottoBean();
                        try {
                            bean = model.doRetrieveByKey(ISBN);
                        } catch (SQLException e){
                            e.printStackTrace();
                        }
                        if (bean != null) {
                            cart.addItem(bean);
                            request.setAttribute("message", "Bottiglia aggiunta al carrello");
                        }
                        break;
                    }

                    case "clearCart": {
                        cart.deleteAll();
                        request.setAttribute("message", "Carrello svuotato");
                        break;
                    }

                    case "deleteCart": {
                        long ISBN = Long.parseLong(request.getParameter("ISBN"));
                        ProdottoBean bean = new ProdottoBean();
                        try {
                            bean = model.doRetrieveByKey(ISBN);
                        } catch (SQLException e){
                            e.printStackTrace();
                        }
                        if (bean != null) {
                            cart.deleteItem(bean);
                            request.setAttribute("message", "Bottiglia cancellata dal carrello");
                        }
                        break;
                    }

                    case "buy": {
                        UtenteBean user = (UtenteBean) request.getSession().getAttribute("user");
                        if (user == null) {
                            request.setAttribute("destination", "/carrelloView.jsp");
                            request.getRequestDispatcher("/login.jsp").forward(request, response);
                            return;
                        } else {
                            OrdineBean ordine = new OrdineBean();
                            ordine.setData(new Date());
                            ordine.setUtente(user.getMail());

                            OrdineDAO od = new OrdineDAO();
                            try{
                                od.doInsert(ordine);
                            } catch (SQLException e){
                                e.printStackTrace();
                            }

                            int id=0;
                            try{
                                id = od.doGetLatestId();
                            } catch (SQLException e){
                                e.printStackTrace();
                            }

                            ContieneDAO cd = new ContieneDAO();
                            ArrayList<ProdottoBean> items = cart.getItems();
                            for(ProdottoBean x: items){
                                ContieneBean contieneBean = new ContieneBean();
                                contieneBean.setOrdine(id);
                                contieneBean.setProdotto(x.getISBN());
                                try{
                                    cd.doInsert(contieneBean);
                                } catch (SQLException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                            cart.deleteAll();
                            request.getSession().setAttribute("carrello", cart);
                            response.sendRedirect(response.encodeURL(request.getContextPath() + "/ordineEffettuato.jsp"));
                            return;
                        }

                    /*case "pay": {
                        Utente user = (Utente) request.getSession().getAttribute("user");
                        if (user == null) {
                            request.setAttribute("destination", "/carrelloView.jsp");
                            request.getRequestDispatcher("/login.jsp").forward(request, response);
                            return;
                        }
                        else {
                            request.getRequestDispatcher("/pay.jsp").forward(request, response);
                            return;
                        }
                    }*/
                    /*case "showCart": {
                        response.sendRedirect(response.encodeURL(request.getContextPath() + "/carrelloView.jsp"));
                        return;
                    }*/




                }
            }


        request.getSession().setAttribute("carrello", cart);

        this.getServletContext().getRequestDispatcher("/carrello.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
