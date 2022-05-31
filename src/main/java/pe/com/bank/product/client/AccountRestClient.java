package pe.com.bank.product.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import pe.com.bank.product.client.entity.AccountEntity;
import reactor.core.publisher.Flux;

@Component
public class AccountRestClient {
	
	private WebClient webClient;		
	  
	  public AccountRestClient(WebClient webClient) {
	        this.webClient = webClient;
	    }
	  
	  
	  @Value("${restClient.accountUrl}")
	  private String accountUrl;
	  
	  
	  public Flux<AccountEntity> getAccountByProductId(String productId){
		  var url = accountUrl.concat("/productId/{id}");
		  
		  return  webClient
	                .get()
	                .uri(url,productId)
	                .retrieve()
	                .bodyToFlux(AccountEntity.class)
	                .log();

	  }  
	  
	  public Flux<AccountEntity> getAccountByCustomerId(String customerId){
		  var url = accountUrl.concat("/customer/{id}");
		  
		  return  webClient
	                .get()
	                .uri(url,customerId)
	                .retrieve()
	                .bodyToFlux(AccountEntity.class)
	                .log();

	  }

}
