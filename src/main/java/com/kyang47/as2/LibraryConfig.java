package com.kyang47.as2;

import com.kyang47.as2.book.Book;
import com.kyang47.as2.book.BookRepository;
import com.kyang47.as2.library.Library;
import com.kyang47.as2.library.LibraryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

@Configuration
public class LibraryConfig {

    @Bean
    CommandLineRunner commandLineRunner(LibraryRepository libraryRepository, BookRepository bookRepository) {
        return args -> {

            // Loading data with CSV file
            ArrayList<Library> libraryList = new ArrayList<>();
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(ResourceUtils.getFile("classpath:library.csv")));
                String line = "";

                while ((line = br.readLine()) != null)   //returns a Boolean value
                {
                    String[] libraries = line.split(",");
                    libraryList.add(new Library(libraries[0], null));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                        libraryRepository.saveAll(libraryList);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                br = new BufferedReader(new FileReader(ResourceUtils.getFile("classpath:book.csv")));
                String line = "";

                while ((line = br.readLine()) != null) {
                    String[] books = line.split(",");
                    bookRepository.save(new Book(books[0], books[1], libraryList.get(new Random().nextInt(libraryList.size()))));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
}
