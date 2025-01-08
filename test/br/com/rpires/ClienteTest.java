/**
 *
 */
package br.com.rpires;

import org.junit.Test;

import br.com.rpires.dao.ClienteDAO;
import br.com.rpires.dao.IClienteDAO;
import br.com.rpires.domain.Cliente;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteTest {

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

    // criar teste para consultar um cliente na tabela tb_cliente_2 do banco de dados vendas_online_2.


    //criar teste para excluir um cliente na tabela tb_cliente_2 do banco de dados vendas_online_2.


    //criar teste para atualizar um cliente na tabela tb_cliente_2 do banco de dados vendas_online_2.



    // criar teste para listar todos os clientes na tabela tb_cliente_2 do banco de dados vendas_online_2.

}
