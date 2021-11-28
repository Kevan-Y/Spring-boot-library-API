package com.kyang47.as2.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> getLibraries() {
        return libraryRepository.findAll();
    }

    public void addNewLibrary(Library library) {
        libraryRepository.save(library);
    }

    public void deleteLibrary(Long id) {
        boolean exists = libraryRepository.existsById(id);

        if (!exists)
            throw new IllegalStateException("Library with id " + id + " does not exists");

        libraryRepository.deleteById(id);
    }

    @Transactional
    public void updateLibrary(Long id, String address) {
        Library library = libraryRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Library with id " + id + " does not exists"));

        if (address != null && address.length() > 0 && !Objects.equals(library.getAddress(), address))
            library.setAddress(address);
    }

    public Library getLibraryById(Long id) {
        return libraryRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Library with id " + id + " does not exists"));
    }
}
