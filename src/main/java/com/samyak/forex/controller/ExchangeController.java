package com.samyak.forex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samyak.forex.Model.ExchangeModel;
import com.samyak.forex.service.CurrencyExchangeService;

@RestController
@RequestMapping("/currency-exchange/")
public class ExchangeController {
	@Autowired
	CurrencyExchangeService currencyExchangeService;

	@RequestMapping("from/{from}/to/{to}")
	public ExchangeModel retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {
		return currencyExchangeService.retrieveExchangeValue(from, to);
	}

}
