package servlets;

import model.Cliente;
import service.ClienteService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sg-0036936 on 13/12/2016.
 */

@WebServlet(urlPatterns = {"/cliente", "/clienteServlet", "/clienteController"})
public class ClienteServlet extends HttpServlet {


    //Objeto que gerencia a lista.
    ClienteService clienteService;

    public ClienteServlet() {
        System.out.println("Construtor do servlet.");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Inicializando o servlet.");
        clienteService = new ClienteService();
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Sou fã quero SERVICE.");
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cliente cliente = new Cliente();
        String i = req.getParameter("i");
        if (i != null && i != "") {
                clienteService.excluir(Integer.parseInt(i));
            }


        RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
        req.setAttribute("lista", clienteService.getListaClientes());
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Chamou pelo método POST");

        resp.setCharacterEncoding("UTF-8"); //pra funcionar acentos na mensagem


        //recebendo o email
        String email = req.getParameter("email");
        //Colocando email de um cliente na classe cliente
        Cliente novoCliente = new Cliente();
        novoCliente.setEmail(email);
        //colocando o email na lista clientes
        clienteService.cadastrar(novoCliente);

        RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
        req.setAttribute("msg", "Cadastrado com sucesso!");
        req.setAttribute("lista", clienteService.getListaClientes());
        dispatcher.forward(req, resp);

        //redirecionamento
        //resp.sendRedirect("cliente");

        //resp.getWriter().println("Chamou método post com o email " + email + "!"); //print on the screen some message

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
