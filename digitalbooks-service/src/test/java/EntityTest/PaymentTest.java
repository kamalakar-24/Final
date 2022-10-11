package EntityTest;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.digitalbooks.models.Payment;

@SpringBootTest
public class PaymentTest {
	Payment payment = new Payment();

	@Test
	public void paymentIdtest() {
		payment.setPaymentId(1L);
		Long id = payment.getPaymentId();
		assertThat(1L).isEqualTo(id);
	}

@Test
	public void readerIdtest() {
		payment.setReaderId(1L);
		Long id = payment.getReaderId();
		assertThat(1L).isEqualTo(id);
}

	@Test
	public void bookidtest() {
		payment.setBookId(3L);
		Long id = payment.getBookId();
		assertThat(3L).isEqualTo(id);
	}

	@Test
	public void pricetest() {
		payment.setPrice(150);
		Integer price = payment.getPrice();
		assertThat(150).isEqualTo(price);
	}

   @Test
    public void paymentdatetest() {
        payment.setPaymentDate(new Date());
        Date paymentdate = payment.getPaymentDate();
        assertEquals(new Date(), paymentdate);
    }

}
