package com.example.h2springboot.web;

import com.example.h2springboot.domain.Book;
import com.example.h2springboot.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private BookRepository repository;

    // Methods

    @RequestMapping("/")
    public String hello() {
        return "Hello Spring";
    }


    @RequestMapping(value="/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book){
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.delete(bookId);
        return "redirect:/booklist";

    }

    // TEST Method
    @RequestMapping(value="/sub")
    public String sub(Model model) {
        model.addAttribute("books", repository.findAll());
        return "subscriber";
    }

//
//    @RequestMapping(value="/list")
//    public String list(Model model) {
//        model.addAttribute("book", repository.findAll());
//        return "list";
//    }
//
//    @RequestMapping(value = "/add")
//    public String add(Model model){
//        model.addAttribute("book", new Book());
//        return "add";
//    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String save(Subscriber subscriber){
//        repository.save(subscriber);
//        return "redirect:list";
//    }
//
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public String deleteSubscriber(@PathVariable("id") Long subscriberId, Model model) {
//        repository.delete(subscriberId);
//        return "redirect:../list";
//    }

}
