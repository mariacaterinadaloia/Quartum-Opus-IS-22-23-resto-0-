package utente.model;

import connection.DriverManagerConnectionPool;
import generic.DAO;
import gestore.model.OrdineBean;
import gestore.model.OrdineDAO;

import java.sql.*;
import java.util.ArrayList;

public class ContieneDAO implements DAO<ContieneBean> {

    private static final String TABLE_NAME = "contiene";

    @Override
    public ArrayList<ContieneBean> doRetrieveAll() throws SQLException {
        return null;
    }

    @Override
    public ContieneBean doRetrieveByKey(Object key) throws SQLException {
       return null;
    }

    @Override
    public void doDeleteByKey(Object key) throws SQLException {

    }

    @Override
    public void doModifyByKey(Object key, ContieneBean contieneBean) throws SQLException {

    }

    @Override
    public void doInsert(ContieneBean contieneBean) throws SQLException {
        String query="Insert into "+ ContieneDAO.TABLE_NAME+" values(?,?)";
        Connection con=null;
        PreparedStatement ps=null;


        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(1, contieneBean.getOrdine());
            ps.setLong(2, contieneBean.getProdotto());
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public ArrayList<ContieneBean> doRetrieveByOrderId(int id) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+ ContieneDAO.TABLE_NAME+" where ordine = ?";
        ArrayList<ContieneBean> ab = new ArrayList<ContieneBean>();


        try {
            con = DriverManagerConnectionPool.getConnection();


            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ContieneBean b=new ContieneBean();
                b.setOrdine(rs.getInt("ordine"));
                b.setProdotto(rs.getLong("prodotto"));
                ab.add(b);
            }
            rs.close();
        }finally {
            try {
                if(ps!=null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }

        }
        return ab;
    }
}
