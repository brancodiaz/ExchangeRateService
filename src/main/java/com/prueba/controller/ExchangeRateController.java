package com.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.model.ListaTipoCambio;
import com.prueba.model.TipoCambioRqt;
import com.prueba.service.ExchangeRateService;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@RestController
@RequestMapping(value = "/api/v1/exchangeRate")
public class ExchangeRateController {

	@Autowired
	private ExchangeRateService ExchangeRateService;
	
	@PostMapping
	@RequestMapping("RegistrarTiposCambio")
	public Single<ResponseEntity<Single<?>>> RegistrarTiposCambio(@RequestBody ListaTipoCambio request) {

		return Single.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON) 
				.body(
						ExchangeRateService.RegistrarTiposCambio(request)
						.subscribeOn(Schedulers.io())
						)
				);

	}
	
	@GetMapping	
	@RequestMapping("ObtenerTiposCambio")
	public Single<ResponseEntity<Observable<?>>> ObtenerTiposCambio() {

		return Single.just(ResponseEntity.ok() 
				.contentType(MediaType.APPLICATION_JSON) 
				.body(
						ExchangeRateService.ObtenerTiposCambio()
						.subscribeOn(Schedulers.io())
						)
				);
	}

	@PostMapping
	@RequestMapping("CalcularTipoCambio")
	public Single<ResponseEntity<Single<?>>> CalcularTipoCambio(@RequestBody TipoCambioRqt request) {

		return Single.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON) 
				.body(
						ExchangeRateService.CalcularTipoCambio(request)
						.subscribeOn(Schedulers.io())
						)
				);

	}	
}
