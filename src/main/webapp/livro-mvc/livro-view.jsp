<!DOCTYPE html>
<%@page import="dw.LivroModel"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Livro</title>
<meta charset="utf-8">
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 15px">
  <div class="container">
    <div class="row">
      <div class="col-md-offset-2 col-md-8">
        <ol class="breadcrumb">
          <li><a href="/">Menu</a></li>
          <li class="active">Livro</li>
        </ol>
        <div class="panel panel-default">
          <div class="panel-body">
            <form>
              <div class="form-group">
                <input
                  name="codigo"
                  value="${param.codigo}"
                  type="text"
                  placeholder="Código"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="nome"
                  value="${param.nome}"
                  type="text"
                  placeholder="Nome"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="autor"
                  value="${param.autor}"
                  type="text"
                  placeholder="Autor"
                  class="form-control">
              </div>
              <button name="op" value="incluir" class="btn btn-default">Incluir Novo</button>
              <button name="op" value="salvar" class="btn btn-default">Alterar Atual</button>
            </form>
          </div>
        </div>
        <table class="table table-bordered table-striped">
          <tr>
            <td>Código</td>
            <td>Nome</td>
            <td>Autor</td>
            <td>#</td>
          </tr>
          <%
          List<LivroModel> livros = (List<LivroModel>) request.getAttribute("livros");
          for (LivroModel v:livros) {
          %>
            <tr>
              <td><a href="livro?codigo=<%=v.getCodigo()%>&nome=<%=v.getNome()%>&autor=<%=v.getAutor()%>"><%=v.getCodigo()%></a></td>
              <td><%=v.getProduto()%></td>
              <td><%=v.getAutor()%></td>
              <td><a href="livro?op=excluir&codigo=<%=v.getCodigo()%>">Excluir</a></td>
            </tr>
          <%
          }
          %>
        </table>
      </div>
    </div>
  </div>
</body>
</html>