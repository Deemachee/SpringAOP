package ru.learnup;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Contact {

    private String name;
    private String phone;

    public Contact setNamePhone(String name, String phone) {
        this.name = name;
        this.phone = phone;
        return this;
    }

    public void Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + phone + "]";
    }
}
