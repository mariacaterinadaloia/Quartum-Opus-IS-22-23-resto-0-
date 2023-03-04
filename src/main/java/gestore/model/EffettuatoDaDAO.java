package gestore.model;

import connection.DriverManagerConnectionPool;
import generic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EffettuatoDaDAO implements DAO<EffettuatoDaBean> {
    private static final String TABLE_NAME = "effettuato_da";
    @Override
    public ArrayList<EffettuatoDaBean> doRetrieveAll() throws SQLException {
            Connection con=null;
            PreparedStatement ps=null;
            String query= "select * from "+ EffettuatoDaDAO.TABLE_NAME+"";
            ArrayList<EffettuatoDaBean> ab = new ArrayList<EffettuatoDaBean>();


            try {
                con = DriverManagerConnectionPool.getConnection();

                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();


                while (rs.next()) {
                    EffettuatoDaBean b=new EffettuatoDaBean();
                    b.setOrdine(rs.getInt("ordine"));
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
    public EffettuatoDaBean doRetrieveByKey(Object key) throws SQLException {
        String email= (String) key;
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+EffettuatoDaDAO.TABLE_NAME+"where ordine = ?";
        EffettuatoDaBean b=new EffettuatoDaBean();

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {
                b.setOrdine(rs.getInt("ordine"));
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
        Integer ordine = (Integer) key;
        String query="delete from"+EffettuatoDaDAO.TABLE_NAME+"where ordine=?";
        Connection con=null;
        PreparedStatement ps=null;


        try {
            con= DriverManagerConnectionPool.getConnection();
            ps=con.prepareStatement(query);
            ps.setInt(1, ordine);
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
    public void doModifyByKey(Object key, EffettuatoDaBean effettuatoDaBean) throws SQLException {

    }

    @Override
    public void doInsert(EffettuatoDaBean effettuatoDaBean) throws SQLException {
        String query="Insert into "+ EffettuatoDaDAO.TABLE_NAME+" values(?,?)";
        Connection con=null;
        PreparedStatement ps=null;

        try {
            con= DriverManagerConnectionPool.getConnection();
            ps.setInt(1, effettuatoDaBean.getOrdine());
            ps.setString(2,effettuatoDaBean.getUtente());
            ps=con.prepareStatement(query);

            ps.execute();


        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public ArrayList<EffettuatoDaBean> getOrdersbyUser(String mail) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+EffettuatoDaDAO.TABLE_NAME+"where utente = ?";
        ArrayList<EffettuatoDaBean> aoe = new ArrayList<EffettuatoDaBean>();
        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(1, mail);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {
                EffettuatoDaBean b=new EffettuatoDaBean();
                b.setOrdine(rs.getInt("ordine"));
                b.setUtente(rs.getString("utente"));
                aoe.add(b);
            }
            rs.close();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }

        }
        return aoe;
    }

    public  ArrayList<EffettuatoDaBean> doRetrieveByUser(String user) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+ EffettuatoDaDAO.TABLE_NAME+"where utente=?";
        ArrayList<EffettuatoDaBean> ab = new ArrayList<EffettuatoDaBean>();


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1,user);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                EffettuatoDaBean b=new EffettuatoDaBean();
                b.setOrdine(rs.getInt("ordine"));
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

}
