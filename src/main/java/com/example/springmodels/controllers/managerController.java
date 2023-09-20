package com.example.springmodels.controllers;

import com.example.springmodels.models.*;
import com.example.springmodels.repos.*;
import com.example.springmodels.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/manager")
@PreAuthorize("hasAnyAuthority('MANAGER','ADMIN')")
public class managerController {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorDetailsRepository authorDetailsRepository;
    @Autowired
    private PublisherDetailsRepository publisherDetailsRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private com.example.springmodels.repos.userRepository userRepository;





    @GetMapping("/book")
    public String bookMain(Model model)
    {
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book-main";
    }

    @GetMapping("/authorDetails")
    public String authordetailsMain(Model model)
    {
        Iterable<AuthorDetails> authorDetails = authorDetailsRepository.findAll();
        model.addAttribute("authorDetails", authorDetails);
        return "authorDetails-main";
    }

    @GetMapping("/publisherDetails")
    public String publisherdetailsMain(Model model)
    {
        Iterable<PublisherDetails> publisherDetails = publisherDetailsRepository.findAll();
        model.addAttribute("publisherDetails", publisherDetails);
        return "publisherdetails-main";
    }

    @GetMapping("/genre")
    public String genreMain(Model model)
    {
        Iterable<Genre> genres = genreRepository.findAll();
        model.addAttribute("genres", genres);
        return "genre-main";
    }

    @GetMapping("/author")
    public String authorMain(Model model)
    {
        Iterable<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "author-main";
    }

    @GetMapping("/publisher")
    public String publisherMain(Model model)
    {
        Iterable<Publisher> publishers = publisherRepository.findAll();
        model.addAttribute("publishers", publishers);
        return "publisher-main";
    }
    //-----------------------------------------------------------------------------------------------------------------
    @GetMapping("/book/add")
    public String bookAdd(@ModelAttribute("books") Book book, Model authorr, Model publisherr)
    {
        Iterable<Author> author = authorRepository.findAll();
        authorr.addAttribute("author", author);
        Iterable<Publisher> publisher = publisherRepository.findAll();
        publisherr.addAttribute("publisher", publisher);
        return "book-add";
    }

    @PostMapping("/book/add")
    public String bookPostAdd(@ModelAttribute("books") @Valid Book book, BindingResult bindingResult,
                              @RequestParam String surname, @RequestParam String name, Model authorr, Model publisherr)
    {
        if(bindingResult.hasErrors()) {
            Iterable<Author> author = authorRepository.findAll();
            authorr.addAttribute("author", author);
            Iterable<Publisher> publisher = publisherRepository.findAll();
            publisherr.addAttribute("publisher", publisher);
            return "book-add";
        }
        book.setAuthor(authorRepository.findBySurname(surname));
        book.setPublisher(publisherRepository.findByName(name));
        bookRepository.save(book);
        return "/book-main";
    }



    @GetMapping("/authorDetails/add")
    public String authorDetailsAdd(Model model) {
        model.addAttribute("authorDetails", new AuthorDetails());
        return "authordetails-add";
    }

    @PostMapping("/authorDetails/add")
    public String authorDetailsPostAdd(@ModelAttribute("authorDetails") @Valid AuthorDetails authorDetails,
                                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "authordetails-add";
        }
        authorDetailsRepository.save(authorDetails);
        return "/authordetails-main"; // Redirect to the author details list page
    }



    @GetMapping("/publisherDetails/add")
    public String publisherDetailsAdd(Model model) {
        model.addAttribute("publisherDetails", new PublisherDetails());
        return "publisherdetails-add";
    }

    @PostMapping("/publisherDetails/add")
    public String publisherDetailsPostAdd(@ModelAttribute("publisherDetails") @Valid PublisherDetails publisherDetails,
                                       BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "publisherdetails-add";
        }
        publisherDetailsRepository.save(publisherDetails);
        return "/publisherdetails-main"; // Redirect to the author details list page
    }



    @GetMapping("/genre/add")
    public String genreAdd(Model model) {
        model.addAttribute("genre", new Genre());
        return "genre-add";
    }

    @PostMapping("/genre/add")
    public String genrePostAdd(@ModelAttribute("genre") @Valid Genre genre,
                                       BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "genre-add";
        }
        genreRepository.save(genre);
        return "/genre-main"; // Redirect to the author details list page
    }



    @GetMapping("/publisher/add")
    public String publisherAdd(@ModelAttribute("publishers") Publisher publisher, Model publisherr)
    {
        Iterable<PublisherDetails> publisherDetails = publisherDetailsRepository.findAll();
        publisherr.addAttribute("publisherDetails", publisherDetails);
        return "publisher-add";
    }

    @PostMapping("/publisher/add")
    public String publisherPostAdd(@ModelAttribute("publishers") @Valid Publisher publisher, BindingResult bindingResult,
                              @RequestParam String information, Model publisherr)
    {
        if(bindingResult.hasErrors()) {
            Iterable<PublisherDetails> publisherDetails = publisherDetailsRepository.findAll();
            publisherr.addAttribute("publisherDetails", publisherDetails);
            return "publisher-add";
        }
        publisher.setPublisherDetails(publisherDetailsRepository.findByInformation(information));
        publisherRepository.save(publisher);
        return "/publisher-main";
    }



    @GetMapping("/author/add")
    public String authorAdd(@ModelAttribute("authors") Author author, Model authorr)
    {
        Iterable<AuthorDetails> authorDetails = authorDetailsRepository.findAll();
        authorr.addAttribute("authorDetails", authorDetails);
        return "author-add";
    }

    @PostMapping("/author/add")
    public String authorPostAdd(@ModelAttribute("authors") @Valid Author author, BindingResult bindingResult,
                                   @RequestParam String biography, Model authorr)
    {
        if(bindingResult.hasErrors()) {
            Iterable<AuthorDetails> authorDetails = authorDetailsRepository.findAll();
            authorr.addAttribute("authorDetails", authorDetails);
            return "author-add";
        }
        author.setAuthorDetails(authorDetailsRepository.findByBiography(biography));
        authorRepository.save(author);
        return "/author-main";
    }
//------------------------------------------------------------------------------------------------------------------


    @GetMapping("/book/{id}/edit")
    public String showUpdate(@PathVariable(value = "id") long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        model.addAttribute("book", book);
        Iterable<Author> author = authorRepository.findAll();
        model.addAttribute("author", author);
        Iterable<Publisher> publisher = publisherRepository.findAll();
        model.addAttribute("publisher", publisher);
        return "book-edit";
    }

    @PostMapping("/book/{id}/edit")
    public String updateBook(@ModelAttribute("book")@Valid Book book,@RequestParam String surname, @RequestParam String name, Model model, BindingResult result,@PathVariable(value = "id") long id) {
        if(result.hasErrors()) {
            Iterable<Author> author = authorRepository.findAll();
            model.addAttribute("author", author);
            Iterable<Publisher> publisher = publisherRepository.findAll();
            model.addAttribute("publisher", publisher);
            return "book-edit";
        }
        book.setAuthor(authorRepository.findBySurname(surname));
        book.setPublisher(publisherRepository.findByName(name));
        bookRepository.save(book);
        return "redirect:/book";
    }

//    @PostMapping ("/book/{id}/edit")
//    public  String bookUpdate(@ModelAttribute("book") @Valid Book book,
//                               BindingResult bindingResult,
//                               @PathVariable(value = "id") long id)
//    {
//        if(bindingResult.hasErrors())
//            return "book-edit";
//        bookRepository.save(book);
//        return "redirect:/book";
//    }



    @GetMapping("/authorDetails/{id}/edit")
    public  String authorDetailsDetails(@PathVariable(value = "id") long id, Model model)
    {
        AuthorDetails res1 = authorDetailsRepository.findById(id).orElseThrow();
        model.addAttribute("authorDetails",res1);
        return "authordetails-edit";
    }


    @PostMapping ("/authorDetails/{id}/edit")
    public  String authorDetailsUpdate(@ModelAttribute("authorDetails") @Valid AuthorDetails authorDetails,
                              BindingResult bindingResult,
                              @PathVariable(value = "id") long id)
    {
        if(bindingResult.hasErrors())
            return "authordetails-edit";
        authorDetailsRepository.save(authorDetails);
        return "/authordetails-main";
    }



    @GetMapping("/publisherDetails/{id}/edit")
    public  String publisherDetailsDetails(@PathVariable(value = "id") long id, Model model)
    {
        PublisherDetails res1 = publisherDetailsRepository.findById(id).orElseThrow();
        model.addAttribute("publisherDetails",res1);
        return "publisherdetails-edit";
    }


    @PostMapping ("/publisherDetails/{id}/edit")
    public  String publisherDetailsUpdate(@ModelAttribute("publisherDetails") @Valid PublisherDetails publisherDetails,
                                       BindingResult bindingResult,
                                       @PathVariable(value = "id") long id)
    {
        if(bindingResult.hasErrors())
            return "publisherdetails-edit";
        publisherDetailsRepository.save(publisherDetails);
        return "/publisherdetails-main";
    }



    @GetMapping("/genre/{id}/edit")
    public  String genreDetails(@PathVariable(value = "id") long id, Model model)
    {
        Genre res1 = genreRepository.findById(id).orElseThrow();
        model.addAttribute("genre",res1);
        return "genre-edit";
    }


    @PostMapping ("/genre/{id}/edit")
    public  String genreUpdate(@ModelAttribute("genre") @Valid Genre genre,
                                          BindingResult bindingResult,
                                          @PathVariable(value = "id") long id)
    {
        if(bindingResult.hasErrors())
            return "genre-edit";
        genreRepository.save(genre);
        return "/genre-main";
    }



    @GetMapping("/publisher/{id}/edit")
    public  String publisherDetails(@PathVariable(value = "id") long id, Model model, Model publisherr)
    {
        Iterable<PublisherDetails> publisherDetails = publisherDetailsRepository.findAll();
        publisherr.addAttribute("publisherDetails", publisherDetails);
        Publisher res1 = publisherRepository.findById(id).orElseThrow();
        model.addAttribute("publisher",res1);
        return "publisher-edit";
    }

    @PostMapping ("/publisher/{id}/edit")
    public  String publisherUpdate(@ModelAttribute("publisher") @Valid Publisher publisher,
                              BindingResult bindingResult,
                              @PathVariable(value = "id") long id)
    {
        if(bindingResult.hasErrors())
            return "publisher-edit";
        publisherRepository.save(publisher);
        return "/publisher-main";
    }



    @GetMapping("/author/{id}/edit")
    public  String authorDetails(@PathVariable(value = "id") long id, Model model, Model authorr)
    {
        Iterable<AuthorDetails> authorDetails = authorDetailsRepository.findAll();
        authorr.addAttribute("authorDetails", authorDetails);
        Author res1 = authorRepository.findById(id).orElseThrow();
        model.addAttribute("author",res1);
        return "author-edit";
    }

    @PostMapping ("/author/{id}/edit")
    public  String authorUpdate(@ModelAttribute("author") @Valid Author author,
                                   BindingResult bindingResult,
                                   @PathVariable(value = "id") long id)
    {
        if(bindingResult.hasErrors())
            return "author-edit";
        authorRepository.save(author);
        return "/author-main";
    }
//----------------------------------------------------------------------------------------------------------------
    @GetMapping("/book/{id}/remove")
    public  String bookDelete(@PathVariable(value = "id") long id, Model model)
    {
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
        return "redirect:/book";
    }

    @GetMapping("/authorDetails/{id}/remove")
    public  String authorDetailsDelete(@PathVariable(value = "id") long id, Model model)
    {
        AuthorDetails authorDetails = authorDetailsRepository.findById(id).orElseThrow();
        authorDetailsRepository.delete(authorDetails);
        return "/authordetails-main";
    }

    @GetMapping("/publisherDetails/{id}/remove")
    public  String publisherDetailsDelete(@PathVariable(value = "id") long id, Model model)
    {
        PublisherDetails publisherDetails = publisherDetailsRepository.findById(id).orElseThrow();
        publisherDetailsRepository.delete(publisherDetails);
        return "/publisherdetails-main";
    }

    @GetMapping("/genre/{id}/remove")
    public  String genreDelete(@PathVariable(value = "id") long id, Model model)
    {
        Genre genre = genreRepository.findById(id).orElseThrow();
        genreRepository.delete(genre);
        return "/genre-main";
    }

    @GetMapping("/publisher/{id}/remove")
    public  String publisherDelete(@PathVariable(value = "id") long id, Model model)
    {
        Publisher publisher = publisherRepository.findById(id).orElseThrow();
        publisherRepository.delete(publisher);
        return "/publisher-main";
    }

    @GetMapping("/author/{id}/remove")
    public  String authorDelete(@PathVariable(value = "id") long id, Model model)
    {
        Author author = authorRepository.findById(id).orElseThrow();
        authorRepository.delete(author);
        return "/author-main";
    }
}