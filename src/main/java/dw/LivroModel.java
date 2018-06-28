package dw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LivroModel {

    private String codigo;
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String produto) {
        this.nome = nome;
    }

    private String autor;
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    private static Connection obterConexao() throws SQLException {
        //Estabelecer uma conexão com o banco de dados.
        String url = "jdbc:derby://localhost:1527/livrodb;create=true";
        String user = "app";
        String password = "app";
        return DriverManager.getConnection(url, user, password);
    }

    public void incluir() throws SQLException {
        Connection conn = obterConexao();

        //Obter sentença SQL.
        String sql = "insert into livro (codigo, nome, autor) values (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, codigo);
        pstmt.setString(2, nome);
        pstmt.setString(3, autor);
        pstmt.execute();
    }

    public void salvar() throws SQLException {
        Connection conn = obterConexao();

        //Obter sentença SQL.
        String sql = "update livro set nome = ?, autor = ? where codigo = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, nome);
        pstmt.setString(2, autor);
        pstmt.setString(3, codigo);
        pstmt.execute();
    }

    public void excluir() throws SQLException {
        Connection conn = obterConexao();

        //Obter sentença SQL.
        String sql = "delete from livro where codigo = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, codigo);
        pstmt.execute();
    }

    public static List<LivroModel> listar() throws SQLException {
        Connection conn = obterConexao();

        Statement stmt = conn.createStatement();
        String sql = "select codigo, produto, quantidade from livro order by codigo";
        ResultSet rs = stmt.executeQuery(sql);

        List<LivroModel> listaDeLivros = new ArrayList<>();
        while (rs.next()) {
            // Cria um livro para o registro.
            LivroModel livro = new LivroModel();
            livro.setCodigo(rs.getString("codigo"));
            livro.setNome(rs.getString("nome"));
            livro.setAutor(rs.getString("autor"));
            // Adiciona o livro na lista de livros.
            listaDeLivros.add(livro);
        }
        return listaDeLivros;
    }
}
