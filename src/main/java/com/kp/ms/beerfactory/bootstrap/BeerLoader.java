package com.kp.ms.beerfactory.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kp.ms.beerfactory.domain.Beer;
import com.kp.ms.beerfactory.repository.BeerRepository;

@Component
public class BeerLoader implements CommandLineRunner{

	private final BeerRepository br;
	
	public BeerLoader(BeerRepository br) {
		super();
		this.br = br;
	}

	@Override
	public void run(String... args) throws Exception {
		loadBeerObjects();
	}

	private void loadBeerObjects() {
		if (br.count() == 0) {
			
			br.save(Beer.builder()
					.beerName("Mango Bobs")
					.beerStyle("IPA")
					.quantityToBrew(200)
					.minOnHand(10)
					.upc(43212341234L)
					.price(new BigDecimal("12.32"))
					.build());
			
			br.save(Beer.builder()
					.beerName("Galaxy Cat")
					.beerStyle("PALE_ALE")
					.quantityToBrew(100)
					.minOnHand(30)
					.upc(523452323L)
					.price(new BigDecimal("11.2"))
					.build());
		}
		System.out.println("Total beers: "+br.count());
	}
}
