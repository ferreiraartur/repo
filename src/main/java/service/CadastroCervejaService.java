package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.algaworks.brewer.model.Cerveja;
import repository.Cervejas;
import com.algaworks.brewer.service.event.cerveja.CervejaSalvaEvent;



@Service
public class CadastroCervejaService {
	
	@Autowired
	private Cervejas cervejas;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Transactional
	public void salvar(Cerveja cerveja){
		
		
		cervejas.save(cerveja);
		System.out.println("Testando Teste");
		
		publisher.publishEvent(new CervejaSalvaEvent(cerveja));
		                           
	}

}
