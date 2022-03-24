package ru.learnup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.learnup.annotations.LogMethod;
import ru.learnup.annotations.WorkTime;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactsBook {

    private static final Logger log = LoggerFactory.getLogger(ContactsBook.class);

    private List<Contact> contacts = new ArrayList<>();


    public void add(Contact contact) {
        contacts.add(contact);
    }

    @LogMethod
    public void getByPhone(String phone) {
        Contact findContact = null;
        for (Contact contact : contacts) {
            if (contact.getPhone().equals(phone)) {
                findContact = contact;
            }
        }
        if (findContact != null) {
            log.info("getByPhone: Номер " + findContact.getPhone() + " у контакта " + findContact);
        } else {
            log.info("getByPhone: Нет контактов с номером телефона " + findContact.getPhone() + "!");
        }
    }

    @WorkTime
    public void removeByPhone(String phone) {
        Contact deletedContact = null;
        for (Contact contact : contacts) {
            if (contact.getPhone().equals(phone)) {
                deletedContact = contact;
            }
        }
        if (deletedContact != null) {
            contacts.remove(deletedContact);
            log.info("removeByPhone: Книга после удаления контакта с номером "
                    + phone + " : " + contacts);
        } else {
            log.info("removeByPhone: Нет контактов с номером телефона " + deletedContact + "!");
        }
    }

    @Override
    public String toString() {
        return "" + contacts;
    }
}
