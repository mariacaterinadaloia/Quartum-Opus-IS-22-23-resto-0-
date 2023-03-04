package utente.model;

import connection.DriverManagerConnectionPool;
import generic.DAO;

import java.sql.*;
import java.util.ArrayList;

public class OrdineDAO implements DAO<OrdineBean> {
    private static final String TABLE_NAME = "ordine";
    @Override
    public ArrayList<OrdineBean> doRetrieveAll() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+OrdineDAO.TABLE_NAME+"";
        ArrayList<OrdineBean> ab = new ArrayList<OrdineBean>();


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrdineBean b=new OrdineBean();
                b.setId(rs.getInt("id"));
                b.setData(new java.util.Date(rs.getDate("data").getTime()));
                b.setUtente(rs.getString("utente"));
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

    @Override
    public OrdineBean doRetrieveByKey(Object key) throws SQLException {
        Integer id= (Integer) key;
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+OrdineDAO.TABLE_NAME+"where id=?";
        OrdineBean b=new OrdineBean();

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {
                b.setId(rs.getInt("id"));
                b.setData(new java.util.Date(rs.getDate("data").getTime()));
                b.setUtente(rs.getString("utente"));
            }
            rs.close();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }

        }
        return b;
    }

    @Override
    public void doDeleteByKey(Object key) throws SQLException {
        Integer id= (Integer) key;
        String query="delete from"+OrdineDAO.TABLE_NAME+"where id=?";
        Connection con=null;
        PreparedStatement ps=null;


        try {
            con= DriverManagerConnectionPool.getConnection();
            ps=con.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    @Override
    //cambia la data, perché non ha senso cambiare niente
    public void doModifyByKey(Object key, OrdineBean ordineBean) throws SQLException {
        String query="update "+ OrdineDAO.TABLE_NAME+" set data=? where id=?";
        Connection con=null;
        PreparedStatement ps=null;

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(2, ordineBean.getId());
            ps.setDate(1,new Date(ordineBean.getData().getTime()));
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    @Override
    public void doInsert(OrdineBean ordineBean) throws SQLException {
        String query="Insert into "+ OrdineDAO.TABLE_NAME+" values(?,?)";
        Connection con=null;
        PreparedStatement ps=null;


        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setDate(1, new Date(ordineBean.getData().getTime()));
            ps.setString(2, ordineBean.getUtente());
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }


}
