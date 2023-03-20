package jovan.springframework.spring5webapp.bootstrap;

import jovan.springframework.spring5webapp.domain.Author;
import jovan.springframework.spring5webapp.domain.Book;
import jovan.springframework.spring5webapp.repositories.AuthorRepository;
import jovan.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author jovan = new Author("Jovan","Vitosevic");
        Book book1 = new Book("Spring", "123");

        jovan.getBooks().add(book1);
        book1.getAuthors().add(jovan);

        authorRepository.save(jovan);
        bookRepository.save(book1);

        Author milos = new Author("Milos", "Markovic");
        Book book2 = new Book("React", "232");

        milos.getBooks().add(book2);
        book2.getAuthors().add(milos);

        authorRepository.save(milos);
        bookRepository.save(book2);

        System.out.println("Started in BootStrap");
        System.out.println("Number of books: "+bookRepository.count());
    }
}
