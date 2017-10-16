package com.liferay.samples2.unit.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.liferay.samples2.Order;
import com.liferay.samples2.OrderDao;
import com.liferay.samples2.OrderStatus;
import com.liferay.samples2.OrderChange;

public class runTest {

	OrderDao orderDao = mock(OrderDao.class);

	Order order = new Order();

	@Test
	public void anErrorOccursWhenAttemptingToChangeTheCanceledOrder() throws Exception {
				
		try {
			order.setStatus(OrderStatus.CANCEL);

			doReturn(order).when(orderDao).obtain(new Long(777));

			OrderChange orderChange = new OrderChange(orderDao);

			orderChange.change(new Long(777));
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("It is not allowed to exchange a canceled order"));
//			System.out.println(e.toString());
		}
	}
}
