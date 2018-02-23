package com.example.h2springboot;

import com.example.h2springboot.domain.Book;
import com.example.h2springboot.domain.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class H2SpringbootApplication {

    //Logger object
    private static final Logger log = LoggerFactory.getLogger(H2SpringbootApplication.class);

	public static void main(String[] args) {

//		 Open Hibernate Session
//		Session session = HibernateUtil.getSessionFactory().openSession();


		// Start Spring Boot application
		SpringApplication.run(H2SpringbootApplication.class, args);
	}


	@Bean
	CommandLineRunner runer(BookRepository repository){


		return args -> {
			// Create a few objects to DataBase
            log.info("save a couple of book");
            repository.save(new Book("Tuloksellinen JAVA ohjelmointi","Jukka Harju & Jukka Juslin", "951-826-798-7", 41 ));
            repository.save(new Book("KDE","Tapio Kautto", "951-846-090-6", 39 ));
            repository.save(new Book("ASP.NET","Ville Inkinen", "951-846-145-7", 48 ));

            log.info("fetch all books");
            for (Book book : repository.findAll()) {
                log.info(book.toString());
            }

//			repository.save(new Subscriber("Aleksandr", "Pantsesnyi", "aleksandr@email.com"));
//            repository.save(new Subscriber("Alex", "Pant", "panalex@email.com"));
//            repository.save(new Subscriber("Xander", "Wilson", "xander@email.com"));
//            repository.save(new Subscriber("Al", "Pacino", "pacino@email.com"));
//
//            log.info("fetch all students");
//            for (Subscriber subscriber : repository.findAll()) {
//                log.info(subscriber.toString());
//            }

		};
	}


}
