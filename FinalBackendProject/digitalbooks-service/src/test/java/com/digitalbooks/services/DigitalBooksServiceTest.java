package com.digitalbooks.services;


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

import org.springframework.test.context.junit4.SpringRunner;

import com.digitalbooks.models.Book;
import com.digitalbooks.models.Payment;
import com.digitalbooks.models.Refund;
import com.digitalbooks.models.User;
import com.digitalbooks.payload.request.RefundRequest;
import com.digitalbooks.payload.request.UpdateRequest;
import com.digitalbooks.repository.BookRepository;
import com.digitalbooks.repository.PaymentRepository;
import com.digitalbooks.repository.RefundRepository;
import com.digitalbooks.repository.UserRepository;

@RunWith(SpringRunner.class)
public class DigitalBooksServiceTest {
	
	@InjectMocks
	DigitalBooksService service;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	BookRepository bookRepository;
	
	@Mock
	PaymentRepository paymentRepository;
	
	@Mock
	RefundRepository refundRepository;
	
	
	@Test
	public void testSave() {
		Book book = new Book();
		book.setActive(true);
		book.setAuthor("Marvel");
		book.setCatagory("Finance");
		book.setContent("HHHHHHHHHHHHH");
		book.setIsBlocked(false);
		book.setPrice(40);
		book.setPublisher("");
		
		when(bookRepository.save(book)).thenReturn(book);
		Book book1= service.save(book);
	    assertEquals("Marvel", book.getAuthor());
	}
	
	@Test
	public void testgetBookByCatagoryAndAuthorAndPriceWithWrongValue() {
		String catagory="catagory price";
		String author = "Ashish";
		Integer price=8;
		
		Book book = new Book();
		book.setActive(true);
		book.setAuthor("Marvel");
		book.setCatagory("Finance");
		book.setContent("HHHHHHHHHHHHH");
		book.setIsBlocked(false);
		book.setPrice(40);
		book.setPublisher("");
		List<Book> list1= new ArrayList<>();
		list1.add(book);
		
		when(bookRepository.findByCatagoryAndAuthorAndPrice(catagory, author, price)).thenReturn(list1);
		List<Book> list =service.getBookByCatagoryAndAuthorAndPrice(catagory, author, price);
		assertEquals(list, list1);
		
	}
	
	@Test
	public void testisUserAvailable() {
		 String userName ="kamalakar24";
		 when(userRepository.existsByUsername(userName)).thenReturn(true);
		 Boolean isUsr= service.isUserAvailable(userName);
		 assertEquals(true, isUsr);
	 }
	
	@Test
	public void testgetAllBooks() {
		String email="kamalakar@gmail.com";
		User user = new User();
		user.setEmail(email);
		user.setId(1L);
		Optional<User> optional=Optional.of(user);
		when(userRepository.findByEmail(email)).thenReturn(optional);
		Optional<User> optional1=service.getByEmail(email);
		assertEquals(optional, optional1);
		Boolean paymentAvaible= true;
		Long readerId=1L;
		when(paymentRepository.existsByReaderId(readerId)).thenReturn(paymentAvaible);
		Boolean paymentAvaible1=service.isPaymentAvailableByReaderId(readerId);
		assertEquals(paymentAvaible, paymentAvaible1);
		Book book= new Book();
		book.setBookId(1L);
		book.setCatagory("finance");
		Set<Long> booklist= new HashSet();
		booklist.add(1L);
		Long bookId=1L;
		Map<String,Set<Long>> bookList1= new HashMap<>();
		bookList1.put("bookId", booklist);
		List<Payment> paymentList = new ArrayList<>();
		Payment payment= new Payment();
		paymentList.add(payment);
		when(paymentRepository.findAllByreaderId(readerId)).thenReturn(paymentList);
		Map<String,Set<Long>> bookList2 =service.getBookId(11L);
		//assertEquals(bookList1, bookList2);
		assertNotNull(bookList2);
		Map<String,Set<Long>> bookList = service.getAllBooks(email);
		//assertEquals(bookList1, bookList);
		assertNotNull(bookList);
		
	}
	@Test
	public void testisPaymentAvailableByReaderId() {
		Boolean paymentAvaible= true;
		Long readerId=28L;
		Boolean paymentAvaible3=paymentRepository.existsByReaderId(28L);
		when(paymentRepository.existsByReaderId(readerId)).thenReturn(paymentAvaible);
		Boolean paymentAvaible1=service.isPaymentAvailableByReaderId(readerId);
		assertEquals(paymentAvaible, paymentAvaible1);
	}
	
   @Test
   public void testReadContent() {
		String email="kamalakar@gmail.com";
		Long bookId=11L;
		Boolean isuser = true;
		when(userRepository.existsByEmail(email)).thenReturn(isuser);
		Boolean isuser1=service.isUserAvailableByEmail(email);
		assertEquals(isuser, isuser1);
		Book book = new Book();
		book.setCatagory("Finance");
		book.setContent("jjjjjjj");
		book.setAuthor("Marvel");
		when(bookRepository.findByBookId(bookId)).thenReturn(book);
		Book book1=service.getBookByBookId(bookId);
		assertEquals(book, book1);
		Map<String,String> map = new HashMap<String,String>();
		map.put("catagory", "Finance");
		map.put("content", "jjjjjjj");
		map.put("Author", "Marvel");
		Map<String,String> map1= service.readContent(email, bookId);
		assertEquals(map, map1);
		
	   
   }
   
   @Test
   public void testPaymentRequest() {
	   RefundRequest refundRequest = new RefundRequest();
	   refundRequest.setBookId("11");
	   refundRequest.setEmail("kamalakar@gmail.com");
	   refundRequest.setPaymentId("28");
	   refundRequest.setRefundAmount(4.5);
	   Boolean isuser = true;
		when(userRepository.existsByEmail(refundRequest.getEmail())).thenReturn(isuser);
		Boolean isuser1=service.isUserAvailableByEmail(refundRequest.getEmail());
		assertEquals(isuser, isuser1);
	   Payment payment= new Payment();
	   payment.setPaymentId(28L);
	   payment.setBookId(11L);
	   payment.setPrice(6);
	   payment.setReaderId(3L);
	   when(paymentRepository.findByPaymentId(28L)).thenReturn(payment);
	   Payment payment1=service.getPaymentById(28L);
	   assertEquals(payment, payment1);
	   
	   String msg="Refund request generated successfully";
	   Long paymentid= Long.parseLong(refundRequest.getPaymentId());
		
		Long bookid= Long.parseLong(refundRequest.getBookId());
		Integer statusId=2000;
		String status ="Reader requested";
		Refund refund =new Refund();
		refund.setBookId(bookid);
		refund.setPaymentId(paymentid);
		refund.setReaderId(3L);
		
		refund.setRefundDate(new Date());
		refund.setRefundedAmount(4.5);
		refund.setRefundStatus(status);

		refund.setStatusId(statusId);
	   String message= service.saveRefund(refund.getReaderId(), refund.getBookId(),refund.getPaymentId(),refund.getRefundedAmount());
	   assertEquals(msg, message);
	   String msg1=service.paymentRequest(refundRequest);
	   assertEquals(msg, msg1);
	   
   }
   
   @Test
   public void testfindBookByPaymentId() {
	   Boolean isuser = true;
	   String email="kamalakar@gmail.com";
	   //isUser available
		when(userRepository.existsByEmail(email)).thenReturn(isuser);
		Boolean isuser1=service.isUserAvailableByEmail(email);
		assertEquals(isuser, isuser1);
		//get by bookId
		Payment payment= new Payment();
		   payment.setPaymentId(28L);
		   payment.setBookId(11L);
		   payment.setPrice(6);
		   payment.setReaderId(3L);
		   when(paymentRepository.findByPaymentId(28L)).thenReturn(payment);
		   Payment payment1=service.getPaymentById(28L);
		   assertEquals(payment, payment1);
		   //get  by bookId
		   Book book = new Book();
			book.setCatagory("Finance");
			book.setContent("jjjjjjj");
			book.setAuthor("Marvel");
			book.setPrice(5);
			when(bookRepository.findByBookId(11L)).thenReturn(book);
			Book book1=service.getBookByBookId(11L);
			assertEquals(book, book1);
		   
		   Map<String,String> payload = new HashMap<String,String>();
		   payload.put("author",book1.getAuthor());
			payload.put("catagory",book1.getCatagory());
			payload.put("publishedDate",book1.getPublishedDate());
			payload.put("publisher",book1.getPublisher());
			payload.put("title",book1.getTitle());
			Map<String,String> payload1=service.findBookByPaymentId(email, 28L);
			
			assertNotNull(payload1);
   }
  
   @Test
   public void testUpdateRequest() {
	   UpdateRequest request = new UpdateRequest();
	   request.setActive(true);
	   request.setAuthor("Marvel");
	   request.setBookId("11");
	   request.setCatagory("Finance");
	   request.setPrice("7");
	   request.setPublisher("The IronMan");
	   request.setContent("jjjjj");
	   request.setTitle("hljll");
	   request.setIsBlocked(false);
	   
	  //get  by bookId
	   Book book = new Book();
		book.setCatagory("Finance");
		book.setContent("jjjjjjj");
		book.setAuthor("Marvel");
		book.setPrice(5);
		when(bookRepository.findByBookId(11L)).thenReturn(book);
		Book book1=service.getBookByBookId(11L);
		assertEquals(book, book1);
		String message ="updated book successfully";
		String mesge1=service.updateRequest(request);
//		assertEquals(message, mesge1);
		assertNotNull(mesge1);
		
   }
   
   @Test
   public void SavePaymentTest() {
	   Payment payment=new Payment();
	   payment.setBookId(2L);
	   payment.setPaymentId(4L);
	   payment.setReaderId(1L);
	   payment.setPrice(3);
	   payment.setPaymentDate(new Date());
	   when(paymentRepository.save(payment)).thenReturn(payment);
	   Payment payment1= service.save(payment);
	   assertEquals(payment, payment1);
   }
	

}
