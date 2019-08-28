package com.samyak.forex.service;

import com.samyak.forex.Model.ExchangeModel;

public interface CurrencyExchangeService {
	public ExchangeModel retrieveExchangeValue(String from, String to);

}
