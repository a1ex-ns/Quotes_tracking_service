package quotes.tracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * 
 * @author Alexey Savchenko
 */
@SpringBootApplication
//@EnableJpaRepositories
//@EnableJpaRepositories(basePackages = "quotes.tracking.repository")
public class QuotesTrackingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuotesTrackingServiceApplication.class, args);
	}

	//Bid (предлагаемая цена) – самая высокая цена покупателя. Если вы продавец акций, то для вас это самая лучшая цена, по которой у вас их могут купить.
	//Ask (запрашиваемая цена) – это самая низкая цена продавца. Если вы покупатель акций, то для вас это самая лучшая цена, по которой вы можете их купить.

//	<properties>
//		<java.version>11</java.version>
//	</properties>
	
	//fetch( '/message', { method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify({ text: 'Fourth message'})}).then(result => console.log(result))
	//fetch( '/message/4', { method: 'PUT', headers: {'Content-Type': 'application/json'}, body: JSON.stringify({ text: '4 BLA'})}).then(result => console.log(result))
	//fetch( '/message/4', { method: 'DELETE'}).then(result => console.log(result))
	
	//fetch( '/quotes', { method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify({ id: 5, isin: "isinName", bid: 10, ask: 20})}).then(result => console.log(result))
}
