package com.kyang47.as2.book;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kyang47.as2.library.Library;

import javax.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "library_id")
    private Library library;

    public Book() {
    }

    public Book(String title, String summary, Library library) {
        this.title = title;
        this.summary = summary;
        this.library = library;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", library=" + library +
                '}';
    }
}
