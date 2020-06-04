package guru.springframework.spring5webapp.Bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("rashmi");
        //publisher.setAddressline1("Nigahi");
        publisher.setCity("singrauli");
        publisher.setState("MP");
        //publisher.setZip("123446");

        publisherRepository.save(publisher);
        System.out.println("Publisher count: " + publisherRepository.count() );


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Drien Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
         publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book notJb = new Book("J2EE Development ", "123456");

        rod.getBooks().add(notJb);
        notJb.getAuthors().add(rod);
        notJb.setPublisher(publisher);
        publisher.getBooks().add(notJb);

        authorRepository.save(rod);
        bookRepository.save(notJb);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books " + bookRepository.count());
        //System.out.println("Number of authors" + authorRepository.count());
        System.out.println("Publisher number of books : " + publisher.getBooks().size());



    }
}
