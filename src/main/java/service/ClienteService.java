package service;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sg-0036936 on 17/12/2016.
 */
public class ClienteService {

    private static List<Cliente> listaClientes = new ArrayList<Cliente>();

    public void cadastrar(Cliente cliente){
        listaClientes.add(cliente);
    }

    public List<Cliente> getListaClientes(){
        return listaClientes;
    }

    public void excluir(int indice){
        listaClientes.remove(indice);
    }

    public Cliente getClienteIndice(int indice){
        return listaClientes.get(indice);
    }

}
