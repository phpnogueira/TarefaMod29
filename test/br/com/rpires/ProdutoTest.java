package br.com.rpires;

import br.com.rpires.dao.ClienteDAO;
import br.com.rpires.dao.IClienteDAO;
import br.com.rpires.domain.Cliente;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class ProdutoTest {
    @Test
    public void cadastrarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Rodrigo Pires");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = dao.excluir(clienteBD);
        assertNotNull(qtdDel);
    }

    @Test
    public void consultarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("02");
        cliente.setNome("Maria Silva");
        dao.cadastrar(cliente);

        Cliente clienteBD = dao.consultar("02");
        assertNotNull(clienteBD);
        assertEquals("02", clienteBD.getCodigo());
        assertEquals("Maria Silva", clienteBD.getNome());

        dao.excluir(clienteBD);
    }

    @Test
    public void excluirTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("03");
        cliente.setNome("João Sousa");
        dao.cadastrar(cliente);

        Cliente clienteBD = dao.consultar("03");
        assertNotNull(clienteBD);

        Integer qtdDel = dao.excluir(clienteBD);
        assertEquals(Integer.valueOf(1), qtdDel);

        Cliente clienteExcluido = dao.consultar("03");
        assertNull(clienteExcluido);
    }
    @Test
    public void atualizarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("04");
        cliente.setNome("Ana Costa");
        dao.cadastrar(cliente);

        Cliente clienteBD = dao.consultar("04");
        assertNotNull(clienteBD);

        clienteBD.setNome("Ana Costa Atualizada");
        Integer qtdAtualizada = dao.atualizar(clienteBD);
        assertEquals(Integer.valueOf(1), qtdAtualizada);

        Cliente clienteAtualizado = dao.consultar("04");
        assertEquals("Ana Costa Atualizada", clienteAtualizado.getNome());

        dao.excluir(clienteAtualizado);
    }

    @Test
    public void listarTodosTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente1 = new Cliente();
        cliente1.setCodigo("05");
        cliente1.setNome("Carlos Lima");
        dao.cadastrar(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("06");
        cliente2.setNome("Fernanda Alves");
        dao.cadastrar(cliente2);

        List<Cliente> clientes = dao.buscarTodos();
        assertNotNull(clientes);
        assertTrue(clientes.size() >= 2);

        dao.excluir(cliente1);
        dao.excluir(cliente2);
    }
}
