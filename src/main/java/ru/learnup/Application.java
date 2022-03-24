package ru.learnup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class, args);

        //создаем контакты
        Contact john = context.getBean("contact", Contact.class).setNamePhone("John", "89953453467");
        Contact jane = context.getBean("contact", Contact.class).setNamePhone("Jane", "89101201200");
        Contact mark = context.getBean("contact", Contact.class).setNamePhone("Mark", "89992345678");

        //создаем записную книгу и добавляем контакты
        ContactsBook book = context.getBean("contactsBook", ContactsBook.class);
        book.add(john);
        book.add(jane);
        book.add(mark);

        log.info("add: Книга контактов после добавления : " + book.toString());

        //номер для поиска контакта
        String getPhone = "89992345678";
        book.getByPhone(getPhone);

        //номер для удаления контакта
        String removePhone = "89101201200";
        //удаляем контакт из списка
        book.removeByPhone(removePhone);


    }

}
