package EntityTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.digitalbooks.models.Book;

@SpringBootTest
public class BookEntityTest {
	Book book = new Book();

	@Test
	public void bookIdTest() {
		book.setBookId(1L);
		Long id = book.getBookId();
		assertThat(1L).isEqualTo(id);

	}

	@Test
	public void authorTest() {
		book.setAuthor("kamalakar");
		String author = book.getAuthor();
		assertEquals("kamalakar", author);

	}

	@Test
	public void titleTest() {
		book.setTitle("world is Awesome");
		String title = book.getTitle();
		assertEquals("world is Awesome", title);

	}

	@Test
	public void catagoryTest() {
		book.setCatagory("General");
		String catagory = book.getCatagory();
		assertEquals("General", catagory);

	}

	@Test
	public void priceTest() {
		book.setPrice(12);
		Integer price = book.getPrice();
		assertThat(12).isEqualTo(price);

	}

	@Test
	public void publisherTest() {
		book.setPublisher("kamal");
		String publisher = book.getPublisher();
		assertEquals("kamal", publisher);

	}

	@Test
	public void activeTest() {
		book.setActive(true);
		Boolean active = book.getActive();
		assertEquals(true, active);

	}

	@Test
	public void contentTest() {
		book.setContent("Awesome");
		String content = book.getContent();
		assertEquals("Awesome", content);

	}

	@Test
	public void publisherTest1() {
		book.setPublisher("sea");
		String publisher = book.getPublisher();
		assertEquals("sea", publisher);

	}

	@Test
	public void publisherDatetetest() {
		book.setPublishedDate("2000-09-10");
		String releasedate = book.getPublishedDate();
		assertEquals("2000-09-10", releasedate);
	}

	@Test
	public void contenttest() {
		book.setContent("mas");
		String content = book.getContent();
		assertEquals("mas", content);
	}

}
