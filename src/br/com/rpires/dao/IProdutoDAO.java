package br.com.rpires.dao;

import br.com.rpires.domain.Cliente;
import br.com.rpires.domain.Produto;

import java.util.List;

public interface IProdutoDAO {
    public Integer cadastrar(Cliente cliente) throws Exception;

    public Cliente consultar(String codigo) throws Exception;

    public Integer excluir(Cliente clienteBD) throws Exception;

    public Integer atualizar(Cliente cliente) throws Exception;

    public List<Cliente> buscarTodos() throws Exception;
}
