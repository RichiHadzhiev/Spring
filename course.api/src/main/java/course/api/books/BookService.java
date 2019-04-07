package course.api.books;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	private List<Book> books = new ArrayList<>(Arrays.asList(
				new Book(1, "Harry Potter", "J. K. Rowling"),
				new Book(2, "The DaVinci Code", "Dan Brown"),
				new Book(3, "To Kill a Mockingbird", "Harper Lee")
			)); 
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<Book>();
		bookRepository.findAll().forEach(books::add);
		return books;
	}
	
	public Book getBook(Integer id) {
		return books.stream().filter(b -> b.getId().equals(id)).findFirst().get();
	}

	public void addBook(Book book) {
		bookRepository.save(book);
	}
}
