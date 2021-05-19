package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book book_eric = new Book("Book1","13322312312");
        Publisher publisher = new Publisher();

        publisher.setName("Publisher A");
        publisher.setCity("Moscow");
        publisher.setAddressLine1("Gorky Park");

        publisherRepository.save(publisher);

        eric.getBookSet().add(book_eric);

        book_eric.getAuthorSet().add(eric);
        book_eric.setPublisher(publisher);

        publisher.getBooks().add(book_eric);

        authorRepository.save(eric);
        bookRepository.save(book_eric);

        Author rod = new Author("Rod","Johnson");
        Book book_rod = new Book("Book2","133223366312");

        rod.getBookSet().add(book_rod);

        book_rod.getAuthorSet().add(rod);
        book_rod.setPublisher(publisher);

        publisher.getBooks().add(book_rod);

        authorRepository.save(rod);
        bookRepository.save(book_rod);

        System.out.println("Started bootstrap");
        System.out.println("Num. of books = " + bookRepository.count());
        System.out.println("Num. of authors = " + authorRepository.count());
        System.out.println("Num. of publishers = " + publisherRepository.count());
        System.out.println("Num. of " + publisher.getName() + " books = " +
                publisher.getBooks().size());

    }
}
