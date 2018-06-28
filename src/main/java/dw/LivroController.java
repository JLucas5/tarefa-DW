package dw;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/livro-mvc/livro")
public class LivroController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        op = (op == null ? "" : op);

        LivroModel livro = new LivroModel();
        livro.setCodigo(request.getParameter("codigo"));
        livro.setNome(request.getParameter("produto"));
        String autor = request.getParameter("quantidade");
        autor = (autor == null ? "0" : autor);
        livro.setAutor(autor);

        List<LivroModel> livros = null;
        try {
            if (op.equals("incluir")) {
                livro.incluir();
            } else if (op.equals("salvar")) {
                livro.salvar();
            } else if (op.equals("excluir")) {
                livro.excluir();
            }

            livros = LivroModel.listar();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Adiciona a variável na requisição para o JSP trabalhar.
        request.setAttribute("livros", livros);

        //Redireciona requisição para o JSP.
        request.
                getRequestDispatcher("/livro-mvc/livro-view.jsp").
                forward(request, response);
    }
}
