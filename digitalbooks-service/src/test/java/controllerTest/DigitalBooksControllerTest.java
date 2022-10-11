package controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.digitalbooks.controllers.DigitalBooksController;
import com.digitalbooks.models.Book;
import com.digitalbooks.models.Payment;
import com.digitalbooks.models.User;
import com.digitalbooks.payload.request.BookRequest;
import com.digitalbooks.payload.request.RefundRequest;
import com.digitalbooks.payload.request.UpdateRequest;
import com.digitalbooks.services.DigitalBooksService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.experimental.ExtensionMethod;

@RunWith(SpringRunner.class)
public class DigitalBooksControllerTest {
	
	@InjectMocks
	DigitalBooksController  digitalBooksController;
	
	@Mock
	DigitalBooksService digitalBooksService;
	
	
	
	@Test
	public void testSaveBook() {		
			Book book = new Book();
			book.setActive(true);
			book.setAuthor("Marvel");
			book.setCatagory("Finance");
			book.setContent("HHHHHHHHHHHHH");
			book.setIsBlocked(false);
			book.setPrice(40);
			book.setPublisher("lhlllll");
			ResponseEntity responseEntity1 = new ResponseEntity("Book Created Sucessfully" , HttpStatus.CREATED);
			Book book1= digitalBooksService.save(book);
			
			when(digitalBooksService.save(book)).thenReturn(book);
			ResponseEntity responseEntity = digitalBooksController.saveUser(book);
	        assertEquals(responseEntity1.getBody(), responseEntity.getBody());
			//assertThat(responseEntity1.equals(responseEntity));
		    
		
	}
	
	@Test
	public void searchBook() throws JsonProcessingException {
		String catagory="story222 Books";
		String price="39";
		String author="Marvel";
		Integer price1=Integer.parseInt(price);
		
		Book book = new Book();
		book.setAuthor("Marvel");
		book.setCatagory("Finance");
		book.setContent("HHHHHHHHHHHHH");
		book.setPublisher("lhlllll");
		book.setPrice(price1);
		book.setPublishedDate("2019-07-07");
		List<Book> bookList = new ArrayList<>();
		bookList.add(book);
		when(digitalBooksService.getBookByCatagoryAndAuthorAndPrice(catagory, author, price1)).thenReturn(bookList);
		Map<String,String> payload= new HashMap<String,String>();
		payload.put("author",book.getAuthor());
		payload.put("catagory",book.getCatagory());
		payload.put("publishedDate",book.getPublishedDate());
		payload.put("publisher",book.getPublisher());
		payload.put("title",book.getTitle());
		payload.put("price",book.getPrice().toString());

		ResponseEntity responseEntity = new ResponseEntity(payload , HttpStatus.OK);
		
		ResponseEntity responseEntity1=digitalBooksController.SearchBooks(catagory, author, price);
		System.out.print(responseEntity1.getBody());
		assertEquals(responseEntity.getBody(), responseEntity1.getBody());
		
	}
	
	@Test
	public void testGetAllBooks() {
		String email="kamalakar@gmail.com";
		User user = new User();
		user.setId(1L);
		user.setEmail("kamalakar@gmail.com");
		Boolean isReaderPurchased=true;
		Optional<User> optionalUser=Optional.of(user);
		when(digitalBooksService.getByEmail(email)).thenReturn(optionalUser);
		when(digitalBooksService.isPaymentAvailableByReaderId(user.getId())).thenReturn(true);
		Set<Long>  bookIdList = new HashSet<Long>();
		Map<String,Set<Long>> map = new HashMap<String,Set<Long>>();
		bookIdList.add(28L);
		map.put("bookId", bookIdList);
		when(digitalBooksService.getBookId(user.getId())).thenReturn(map);
		ResponseEntity responseEntity = new ResponseEntity(map , HttpStatus.OK);
		ResponseEntity responseEntity1= digitalBooksController.getAllBooks(email);
		assertEquals(responseEntity, responseEntity1);
		

	}
	
	@Test
	public void testReadBooks() throws JsonProcessingException {
		String bookId="28";
		String email="tkr24@gmail.com";
		Long bookId1 = Long.parseLong(bookId);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("catagory", "story222 Books");
		map.put("content", "fffffff");
		map.put("Author", "Marvel");
		when(digitalBooksService.readContent(email,bookId1)).thenReturn(map);
		ResponseEntity responseEntity = new ResponseEntity(map ,HttpStatus.OK);
		ResponseEntity responseEntity1=digitalBooksController.readBooks(email, bookId);
        assertEquals(responseEntity, responseEntity1);
	}
	
	@Test
	public void testGetBookByPaymentid() throws JsonProcessingException {
		String  email="tkr24@gmail.com";
		String paymentId="28";
		Map<String,String> map= new HashMap<String,String>();
		Long payemntid = Long.parseLong(paymentId);
		map.put("catagory", "story222 Books");
		map.put("content", "fffffff");
		map.put("Author", "Marvel");
		map.put("publishedDate","2019-07-07");
		map.put("publisher","Manoj Publications Editorial Board111");
		map.put("title","Panchatantra1111 ");
		map.put("price","39");
		when(digitalBooksService.findBookByPaymentId(email,payemntid)).thenReturn(map);
		ResponseEntity responseEntity = new ResponseEntity(map ,HttpStatus.OK);
		ResponseEntity responseEntity1 = digitalBooksController.getBookByPaymentid(email, paymentId);
		assertEquals(responseEntity, responseEntity1);
		


	}
	
	@Test
	public  void testUpdateBook() {
		UpdateRequest request = new UpdateRequest();
		String msge="updated book successfully";
		request.setActive(true);
		request.setAuthor("Marvel");
		request.setBookId("11");
		request.setCatagory("Finance");
		request.setPrice("7");
		request.setPublisher("The IronMan");
		request.setContent("jjjjj");
		request.setTitle("hljll");
		request.setIsBlocked(false);
		Map<String,String> mapString = new HashMap<String,String>();
		Long bookId = Long.parseLong(request.getBookId());
		when(digitalBooksService.isBookAvailable(bookId)).thenReturn(true);
		when(digitalBooksService.updateRequest(request)).thenReturn(msge);
		mapString.put("Decription",msge);

		ResponseEntity responseEntity = new ResponseEntity(mapString ,HttpStatus.OK);
		ResponseEntity responseEntity1=digitalBooksController.updateBook(request);
		assertEquals(responseEntity, responseEntity1);
		
	}
	
	@Test
	public void testRefund() {
		String msge="Refund request generated successfully";
		Map<String,String> mapString = new HashMap<String,String>();
		RefundRequest refundRequest = new RefundRequest();
		refundRequest.setBookId("11");
		refundRequest.setEmail("tkr24@gmail.com");
		refundRequest.setPaymentId("28");
		refundRequest.setRefundAmount(4.5);
		mapString.put("Decription", msge);
		when(digitalBooksService.paymentRequest(refundRequest)).thenReturn(msge);
		ResponseEntity responseEntity = new ResponseEntity(mapString ,HttpStatus.OK);
		ResponseEntity responseEntity1 = digitalBooksController.refund(refundRequest);
		assertEquals(responseEntity, responseEntity1);

       
		
	}

//	@Test
//	public void tesBbuyBooks() {
//		BookRequest request= new BookRequest();
//		request.setBookId("11");
//		request.setEmail("debaprasad@gmail.com");
//		request.setUsername("debaprasad");
//		Long bookId=Long.parseLong(request.getBookId());
//		when(digitalBooksService.isUserAvailable(request.getUsername())).thenReturn(true);
//
//		when(digitalBooksService.isBookAvailable(bookId)).thenReturn(true);
//		Book book = new Book();
//		book.setActive(true);
//		book.setAuthor("Marvel");
//		book.setCatagory("Finance");
//		book.setContent("HHHHHHHHHHHHH");
//		book.setIsBlocked(false);
//		book.setBookId(11L);
//		book.setPrice(40);
//		book.setPublisher("lhlllll");
//		when(digitalBooksService.getBookByBookId(bookId)).thenReturn(book);
//		User user = new User();
//		user.setEmail(request.getEmail());
//		user.setUsername(request.getUsername());
//		user.setId(3L);
//		Optional<User> optionalUser=Optional.of(user);
//		when(digitalBooksService.getUserByName(request.getUsername())).thenReturn(optionalUser);
//		Payment payment=new Payment();
//		payment.setBookId(11L);
//		payment.setReaderId(3L);
//		payment.setPaymentDate(new Date());
//		Payment payment1=new Payment();
//		payment1.setBookId(11L);
//		payment1.setPaymentId(28L);
//		
//		
//		when(digitalBooksService.savepayment(payment)).thenReturn(payment1);
//		Map<String,Long> respayload= new HashMap<String,Long>();
//
//		respayload.put("pamentId", payment.getPaymentId());
//		respayload.put("bookId", payment.getBookId());
//		
//	
//			
//	ResponseEntity responseEntity = new ResponseEntity(respayload , HttpStatus.OK);
//
//	ResponseEntity responseEntity1 = digitalBooksController.buyBooks(request);
//	//assertEquals(responseEntity, responseEntity1);
//	assertNotNull(responseEntity1);
//	
//	}
	

}
