package br.com.uploadservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.uploadservice.model.NotaFiscal;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Integer> {

	@Query("select n from NotaFiscal n left join fetch n.duplicatas")
	List<NotaFiscal> listar();
}
