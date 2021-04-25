package gabrieljayme.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EnderecosDAO {
    public ArrayList<Enderecos> listarEnderecos() {
        ArrayList<Enderecos> lista = new ArrayList<>();
        String nome, email;
        int id;

        try {
            //Inicializa a database
            Connection con = DatabaseConnection.initializeDatabase();

            //Criar a Statement
            Statement stmt = con.createStatement();
            ResultSet rs;

            //Criar a consulta
            rs = stmt.executeQuery("SELECT * FROM enderecos");

            while (rs.next()) {
                id = rs.getInt("idenderecos");
                nome = rs.getString("nome");
                email = rs.getString("email");
                lista.add(new Enderecos(id, nome, email));
            }

            //fechar as conexões
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    protected void insertEnderecos(String nome, String email) {
        try {
            //Inicializer a database
            Connection con = DatabaseConnection.initializeDatabase();

            //Criar um SQL
            PreparedStatement st = con.prepareStatement("INSERT INTO enderecos(nome, email) VALUES(?, ?)");

            //Configurar os parametros do Statemant
            st.setString(1, nome);
            st.setString(2, email);

            //Execução que modifica a database
            st.executeUpdate();

            //Fechar as conexões
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
