package com.kp.ms.beerfactory.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.kp.ms.beerfactory.domain.Beer;

public interface BeerRepository 
	extends PagingAndSortingRepository<Beer, UUID>{
	
}
