package EntityTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.digitalbooks.models.Refund;

@SpringBootTest
public class refundEntityTest {

	Refund refund = new Refund();

	@Test
	public void refundAmountTest() {
		refund.setRefundedAmount(12.3);
		Double refundAmount = refund.getRefundedAmount();
		assertThat(12.3).isEqualTo(refundAmount);
	}

	@Test
	public void refundId() {
		refund.setRefundId(22L);
		Long refundId = refund.getRefundId();
		assertThat(22L).isEqualTo(refundId);
	}

	@Test
	public void refundStatus() {
		refund.setRefundStatus("successfully completed");
		String refundStatus = refund.getRefundStatus();
		assertEquals("successfully completed", refundStatus);
	}

	@Test
	public void paymentId() {
		refund.setPaymentId(24L);
		Long paymentId = refund.getPaymentId();
		assertThat(24L).isEqualTo(paymentId);;
	}

	@Test
	public void refundDate() {
		refund.setRefundDate(new Date());
		Date refundDate=refund.getRefundDate();
		assertEquals(new Date(), refundDate);
	}
	@Test
	public void statusId() {
		refund.setStatusId(1);
		Integer statusId = refund.getStatusId();
		assertThat(1).isEqualTo(statusId);
	}

	@Test
	public void readerId() {
		refund.setReaderId(2L);
		Long readerId = refund.getReaderId();
		assertThat(2L).isEqualTo(readerId);
	}

	@Test
	public void bookId() {
		refund.setBookId(1L);
		Long bookId = refund.getBookId();
		assertThat(1L).isEqualTo(bookId); 
	}
}
