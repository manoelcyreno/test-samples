package com.liferay.samples2;

public class OrderChange {

	private OrderDao orderDao;

	public OrderChange(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void change(Long codeChange) throws Exception {
		Order order = orderDao.obtain(codeChange);
		if (OrderStatus.CANCEL == order.getStatus()) {
			throw new Exception("It is not allowed to exchange a canceled order");
		} else {
			System.out.println("It is allowed to change the order");
		}
	}
}