package dms.pastor.spring.examples.mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static java.math.BigDecimal.TEN;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@RestController
public class MongoAutoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoAutoController.class);

    private final CustomerRepository customerRepository;

    @Autowired
    public MongoAutoController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("/mongo-example")
    public List<Customer> returnMongoData() {
        setupData();


        LOGGER.info("fetch all people");
        final List<Customer> allCustomers = customerRepository.findAll();
        allCustomers.forEach(x -> LOGGER.warn(x.toString()));

        final List<Boolean> valuableCustomer = allCustomers.stream().map(c -> c.getValue().compareTo(TEN) > 0).collect(Collectors.toList());

        final String surname = "Dark";
        LOGGER.info("fetch all people that has surname {}", surname);

        customerRepository.findByLastName(surname).forEach(x -> LOGGER.warn(x.toString()));
        LOGGER.info(customerRepository.findByFirstName("Lord").getValue().toPlainString());
        LOGGER.info(customerRepository.findByFirstName("Lady").getValue().toPlainString());

        return allCustomers;


    }

    private void setupData() {
        customerRepository.deleteAll();

        customerRepository.save(new Customer("Lord", "Dark", new BigDecimal("10.5")));
        customerRepository.save(new Customer("Lady", "Dark", new BigDecimal("10.52441234156234")));
        customerRepository.save(new Customer("Bright", "Light", new BigDecimal("0.1111111111111111111111111")));
    }

}
