package com.liferay.samples2;

public class TrocaPedido {

	private PedidoDao pedidoDao;

	public TrocaPedido(PedidoDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}

	public void trocar(Long codigoPedido) throws Exception {
		Pedido pedido = pedidoDao.obter(codigoPedido);
		if (StatusPedido.CANCELADO == pedido.getStatus()) {
			throw new Exception("Nao e permitido realizar troca de um pedido cancelado");
		} else {
			System.out.println("E permitido realizar troca do pedido");
		}
	}
}