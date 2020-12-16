package com.kp.ms.beerfactory.web.mapper;

import org.mapstruct.Mapper;

import com.kp.ms.beerfactory.domain.Beer;
import com.kp.ms.beerfactory.web.models.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

	BeerDto BeerToBeerDto(Beer beer);
	
	Beer BeerDtoToBeer(BeerDto dto);
}
