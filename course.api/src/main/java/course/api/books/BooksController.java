package course.api.books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@RequestMapping("books/{id}")
	public Book getBook(@PathVariable Integer id) {
		return bookService.getBook(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/books")
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}
}
