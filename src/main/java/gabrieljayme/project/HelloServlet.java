package gabrieljayme.project;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

//Init é chamado quando um servelet é criado
    public void init() {
        message = "Processando o pedido!";
        ServletContext context = getServletContext();
        context.setAttribute("numeroAcesso", "0");
        System.out.println("Inicializando o servlet!");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Metodo GET foi solicitado..");
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Metodo POST foi solicitado..");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ProcessamentoServlet");
        dispatcher.forward(request, response);
    }

    public void destroy() {
        System.out.println("Finalizando o servlet!");
    }
}