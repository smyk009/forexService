package com.samyak.forex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.samyak.forex.Model.ExchangeModel;
import com.samyak.forex.data.entity.ExchangeEntity;
import com.samyak.forex.data.repository.ExchangeRepository;
import com.samyak.forex.service.CurrencyExchangeService;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	@Autowired
	ExchangeRepository exchangeRepository;

	@Autowired
	Environment environment;

	public ExchangeModel retrieveExchangeValue(String from, String to) {
		ExchangeEntity exchangeEntity = exchangeRepository.findByFromAndTo(from, to);
		return mapToModel(exchangeEntity);
	}

	ExchangeModel mapToModel(ExchangeEntity exchangeEntity) {
		ExchangeModel exchangeModel = new ExchangeModel();
		exchangeModel.setId(exchangeEntity.getId());
		exchangeModel.setTo(exchangeEntity.getTo());
		exchangeModel.setFrom(exchangeEntity.getFrom());
		exchangeModel.setConversionMultiple(exchangeEntity.getConversionMultiple());
		exchangeModel.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeModel;

	}

}
