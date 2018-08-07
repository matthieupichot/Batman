package fr.afcepf.ai103.dao;

import java.util.List;

import fr.afcepf.ai103.data.Stock;


public interface IDaoStock {
		
	Stock AjouterProduit(Stock s) throws Exception;

	List<Stock> getAllStock();
	
}
