package gabrieljayme.project;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDBEndereco", value = "/ServletDBEndereco")
public class ServletDBEndereco extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");

        EnderecosDAO dao = new EnderecosDAO();
        dao.insertEnderecos(nome, email);

        request.getSession().setAttribute("lista", dao.listarEnderecos());

//        response.sendRedirect("mostrarDados.jsp");

        RequestDispatcher dispatcher = request.getRequestDispatcher("mostrarDados.jsp");
        dispatcher.forward(request, response);
    }
}
