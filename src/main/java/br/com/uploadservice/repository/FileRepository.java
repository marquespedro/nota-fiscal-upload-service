package br.com.uploadservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uploadservice.model.NotaFiscal;

@Repository
public interface FileRepository extends JpaRepository<NotaFiscal, Integer>{

}
