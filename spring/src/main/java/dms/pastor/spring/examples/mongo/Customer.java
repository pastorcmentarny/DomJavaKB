package dms.pastor.spring.examples.mongo;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Customer {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private BigDecimal value;

    public Customer(String firstName, String lastName, BigDecimal value) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return format("Customer{id='%s', firstName='%s', lastName='%s', value=%s}", id, firstName, lastName, value);
    }
}
