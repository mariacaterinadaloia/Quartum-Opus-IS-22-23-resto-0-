package utente.model;

import connection.DriverManagerConnectionPool;
import generic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteDAO implements DAO<UtenteBean> {
        private static final String TABLE_NAME = "utente";

        @Override
        public ArrayList<UtenteBean> doRetrieveAll() throws SQLException {
            Connection con=null;
            PreparedStatement ps=null;
            String query= "select * from "+UtenteDAO.TABLE_NAME+"";
            ArrayList<UtenteBean> ab = new ArrayList<UtenteBean>();


            try {
                con = DriverManagerConnectionPool.getConnection();

                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();


                while (rs.next()) {
                    UtenteBean b=new UtenteBean();
                    b.setMail(rs.getString("mail"));
                    b.setNome(rs.getString("nome"));
                    b.setDatadinascita(new java.util.Date(rs.getDate("datadinascita").getTime()));
                    b.setCognome(rs.getString("cognome"));
                    b.setPassword(rs.getString("password"));
                    b.setGestore(rs.getBoolean("gestore"));
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
        public UtenteBean doRetrieveByKey(Object key) throws SQLException{
            String email= (String) key;
            Connection con=null;
            PreparedStatement ps=null;
            String query= "select * from "+UtenteDAO.TABLE_NAME+"where mail=?";
            UtenteBean b=new UtenteBean();

            try {
                con= DriverManagerConnectionPool.getConnection();

                ps=con.prepareStatement(query);
                ps.setString(1, email);
                ResultSet rs= ps.executeQuery();

                while(rs.next()) {
                    b.setMail(rs.getString("email"));
                    b.setNome(rs.getString("nome"));
                    b.setDatadinascita(new java.util.Date(rs.getDate("datadinascita").getTime()));
                    b.setCognome(rs.getString("cognome"));
                    b.setPassword(rs.getString("password"));
                    b.setGestore(rs.getBoolean("gestore"));
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
        public void doDeleteByKey(Object key) throws SQLException{
            String email= (String) key;
            String query="delete from"+UtenteDAO.TABLE_NAME+"where mail=?";
            Connection con=null;
            PreparedStatement ps=null;


            try {
                con= DriverManagerConnectionPool.getConnection();
                ps=con.prepareStatement(query);
                ps.setString(1, email);
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
        //for password
        public void doModifyByKey(Object key, UtenteBean utenteBean) throws SQLException{
            String query="update "+ UtenteDAO.TABLE_NAME+" set password=? where mail=?";
            Connection con=null;
            PreparedStatement ps=null;
            utenteBean.setPassword((String) key);
            try {
                con= DriverManagerConnectionPool.getConnection();

                ps=con.prepareStatement(query);
                ps.setString(2, utenteBean.getMail());
                ps.setString(1, (String) key);
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
        public void doInsert(UtenteBean utenteBean) throws SQLException{
            String query="Insert into "+ UtenteDAO.TABLE_NAME+" values(?,?,?,?,?,?)";
            Connection con=null;
            PreparedStatement ps=null;

            try {
                con= DriverManagerConnectionPool.getConnection();

                ps=con.prepareStatement(query);
                ps.setString(1, utenteBean.getMail());
                ps.setString(3,utenteBean.getNome());
                ps.setDate(5, new java.sql.Date(utenteBean.getDatadinascita().getTime()));
                ps.setString(4, utenteBean.getCognome());
                ps.setBoolean(6, utenteBean.isGestore());
                ps.setString(2, utenteBean.getPassword());

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

