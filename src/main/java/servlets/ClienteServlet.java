package servlets;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sg-0036936 on 13/12/2016.
 */

@WebServlet(urlPatterns = {"/cliente", "/clienteServlet", "/clienteController"})
public class ClienteServlet extends HttpServlet {

    public ClienteServlet(){
        System.out.println("Construtor do servlet.");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Inicializando o servlet.");
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Sou fã quero SERVICE.");
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Chamou pelo método GET");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Chamou pelo método POST");

        resp.setCharacterEncoding("UTF-8"); //pra funcionar acentos na mensagem

        String email = req.getParameter("email");
        resp.getWriter().println("Chamou método post com o email " + email + "!"); //print on the screen some message

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou pelo método DELETE");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou pelo método PUT"); //replace something
    }
}
