package gabrieljayme.project;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ProcessamentoServlet", value = "/ProcessamentoServlet")
public class ProcessamentoServlet extends HttpServlet {
    public void init() {
        ServletContext context = getServletContext();
        context.setAttribute("lista", new ArrayList<Enderecos>());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        ArrayList<Enderecos> lista = (ArrayList<Enderecos>)context.getAttribute("lista");

        response.setContentType("text/html");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");

        lista.add(new Enderecos(nome, email));
        context.setAttribute("lista", lista);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Servlet de Processamento</h1>");
        out.println("<p>" + nome + " possui o email: " + email +"<p>");
        out.println("<p> Lista: " + lista +"<p>");
        out.println("<p><a href='index.html'>Voltar</a><p>");
        out.println("</body></html>");
    }
}
