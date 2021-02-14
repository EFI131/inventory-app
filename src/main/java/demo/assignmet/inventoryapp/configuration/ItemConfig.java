package demo.assignmet.inventoryapp.configuration;

import demo.assignmet.inventoryapp.model.Item;
import demo.assignmet.inventoryapp.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ItemConfig {

    @Bean
    CommandLineRunner commandLineRunner (ItemRepository repository) {
        return args -> {
            Item blackTrousers = new Item("Black Trousers",
                    "Black Pants - Suitable for day to day use",
                    "APPPBLCKSZM");

            Item microwavwe = new Item("Microwave",
                    "Delonghi microwave",
                    "KTCHNMWDGI");

            Item redDress = new Item("Abito Rosso",
                    "Evening Dress",
                    "APPEDRSRD");

            repository.saveAll(Arrays.asList(blackTrousers, microwavwe, redDress));

        };
    }
}
