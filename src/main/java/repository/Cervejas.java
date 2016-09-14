package repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.algaworks.brewer.model.Cerveja;

@Repository
@EnableJpaRepositories(basePackageClasses = Cervejas.class)
@ComponentScan(basePackageClasses = Cervejas.class)
public interface Cervejas extends JpaRepository<Cerveja, Long>{

	
	
}
