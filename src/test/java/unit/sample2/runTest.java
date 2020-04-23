package unit.sample2;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author manoelcyreno
 *
 */
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
			Assert.assertTrue(e.getMessage().contains("It is not allowed to exchange a canceled order"));
		}
	}
}
