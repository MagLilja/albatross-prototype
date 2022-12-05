package se.yrgo.SPGroup2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.enums.ProductSize;
import se.yrgo.SPGroup2.enums.ProductType;

@SpringBootApplication
public class SpGroup2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpGroup2Application.class, args);
		//Product product1 = new Product("007", ProductType.PANTS, "Jokkmokk Damen", ProductSize.S, "Black");
	}

}
