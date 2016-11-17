package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.algaworks.brewer.model.Estilo;

import repository.Estilos;
import service.exception.NomeEstiloJaCadastradoException;
@Service
public class CadastroEstiloService {
	
	@Autowired
	private Estilos estilos;
	
	@Transactional
	public void salvar(Estilo estilo){
		
		Optional <Estilo> estiloOptional = estilos.findByNomeIgnoreCase(estilo.getNome());
		if (estiloOptional.isPresent()){
			
			throw new NomeEstiloJaCadastradoException("Nome do estilo já cadastrado"); 
		}
		estilos.save(estilo);
	}

}
