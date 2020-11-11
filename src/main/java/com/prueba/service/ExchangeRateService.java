package com.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.model.ListaTipoCambio;
import com.prueba.model.TipoCambioEnt;
import com.prueba.model.TipoCambioRqt;
import com.prueba.model.TipoCambioRsp;
import com.prueba.repository.IExchangeRateRepository;

import io.reactivex.Observable;
import io.reactivex.Single;


@Service
public class ExchangeRateService {

	@Autowired
	private IExchangeRateRepository repositorio;

	public Single<?> RegistrarTiposCambio(ListaTipoCambio listaTipoCambio) {

		TipoCambioEnt registrado;
		
		for (int i = 0; i < listaTipoCambio.getListaTipoCambio().size(); i++)
		{
			registrado = repositorio.save(listaTipoCambio.getListaTipoCambio().get(i));
		}
		
		return Single.just("Registro Exitoso");
	}

	public Observable<TipoCambioEnt> ObtenerTiposCambio() {
		return Observable.fromIterable(repositorio.findAll());
	}

	public Single<?> CalcularTipoCambio(TipoCambioRqt peticion) {

		TipoCambioEnt resultado = ObtenerTipoCambio(peticion.getMonedaOrigen(),peticion.getMonedaDestino());
		
		if(resultado.getId() == 0)
			return Single.just("No existe tipo de cambio registrado");

		try {
			return	Single.zip(
					Single.just(resultado),
					Single.just(peticion),
					(a, b)->{
						return new TipoCambioRsp(b.getMonto(), a.getMonedaOrigen(), Double.valueOf(Math.round((b.getMonto() * a.getTipoCambio() * 100.0)) / 100.0), a.getMonedaDestino(), a.getTipoCambio());
					});
		} catch (Exception ex) {
			return Single.just(ex.getMessage());
		}
	}

	private TipoCambioEnt ObtenerTipoCambio(String MonedaOrigen, String MonedaDestino) {

		return repositorio.findAll()
				.stream()
				.filter(x -> x.getMonedaOrigen().equals(MonedaOrigen) && x.getMonedaDestino().equals(MonedaDestino)).findFirst().orElse(new TipoCambioEnt());

	}
}
