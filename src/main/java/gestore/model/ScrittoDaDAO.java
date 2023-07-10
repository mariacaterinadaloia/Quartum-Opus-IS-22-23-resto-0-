package gestore.model;

import connection.DriverManagerConnectionPool;
import generic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScrittoDaDAO implements DAO<ScrittoDaBean> {
    private static final String TABLE_NAME = "scritto_da";
    @Override
    public ArrayList<ScrittoDaBean> doRetrieveAll() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+ ScrittoDaDAO.TABLE_NAME+"";
        ArrayList<ScrittoDaBean> ab = new ArrayList<ScrittoDaBean>();


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                ScrittoDaBean b=new ScrittoDaBean();
                b.setAutore(rs.getString("autore"));
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

    @Override
    public ScrittoDaBean doRetrieveByKey(Object key) throws SQLException {
        Long prodotto = (Long) key;
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+ ScrittoDaDAO.TABLE_NAME+" where prodotto=?";
        ScrittoDaBean b=new ScrittoDaBean();

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setLong(1, prodotto);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {
                b.setAutore(rs.getString("autore"));
                b.setProdotto(rs.getLong("prodotto"));
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
        Long prodotto = (Long) key;
        String query="delete from"+ScrittoDaDAO.TABLE_NAME+" where prodotto=?";
        Connection con=null;
        PreparedStatement ps=null;


        try {
            con= DriverManagerConnectionPool.getConnection();
            ps=con.prepareStatement(query);
            ps.setLong(1, prodotto);
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
    public void doModifyByKey(Object key, ScrittoDaBean scrittoDaBean) throws SQLException {

    }

    @Override
    public void doInsert(ScrittoDaBean scrittoDaBean) throws SQLException {
        String query="Insert into "+ ScrittoDaDAO.TABLE_NAME+" values(?,?)";
        Connection con=null;
        PreparedStatement ps=null;

        try {
            con= DriverManagerConnectionPool.getConnection();
            ps=con.prepareStatement(query);
            ps.setLong(1, scrittoDaBean.getProdotto());
            ps.setString(2, scrittoDaBean.getAutore());



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
