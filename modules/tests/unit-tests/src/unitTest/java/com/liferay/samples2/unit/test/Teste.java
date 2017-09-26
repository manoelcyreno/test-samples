package com.liferay.samples2.unit.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.liferay.samples2.Pedido;
import com.liferay.samples2.PedidoDao;
import com.liferay.samples2.StatusPedido;
import com.liferay.samples2.TrocaPedido;

public class Teste {

	// Crio um mock para a minha interface de acesso a dados de pedido
	PedidoDao pedidoDao = mock(PedidoDao.class);

	Pedido pedido = new Pedido();


	@Test
	public void deveOcorrerErroQuandoTentarTrocarPedidoCancelado() throws Exception {
				
		try {
			pedido.setStatus(StatusPedido.CANCELADO);

			// Aqui utilizo o Mockito para para retornar o pedido acima quando o método
			// "obter" for chamado para o id 777
			doReturn(pedido).when(pedidoDao).obter(new Long(777));

			TrocaPedido trocaPedido = new TrocaPedido(pedidoDao);

			trocaPedido.trocar(new Long(777));
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Nao e permitido realizar troca de um pedido cancelado"));
			System.out.println(e.toString());
		}
	}
}
