package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String isbn;
    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    @ManyToOne
    private Publisher publishers;

    public Book(String name, String isbn) {
        this.name = name;
        this.isbn = isbn;
        this.authors = new HashSet<>();
    }

    public Book() {
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publishers;
    }

    public void setPublisher(Publisher publishers) {
        this.publishers = publishers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String lastName) {
        this.isbn = lastName;
    }

    public Set<Author> getAuthorSet() {
        return authors;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authors = authorSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                ", lastName='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }
}
