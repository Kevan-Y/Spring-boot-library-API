package com.kyang47.as2.library;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kyang47.as2.book.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Library {
    @Id
    @SequenceGenerator(
            name = "library_sequence",
            sequenceName = "library_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "library_sequence"
    )
    private Long id;

    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "library", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public Library() {
    }

    public Library(String address, List<Book> books) {
        this.address = address;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", books=" + books +
                '}';
    }
}
