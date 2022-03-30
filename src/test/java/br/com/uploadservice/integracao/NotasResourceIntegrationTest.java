package br.com.uploadservice.integracao;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.uploadservice.UploadServiceApplication;
import br.com.uploadservice.repository.NotaFiscalRepository;

/**
 * @author pedro WebEnvironment.MOCK -> para que contêiner opere em um ambiente
 *         de servlet simulado
 * @SpringBootTest configura ambiente de execução
 * @TestPropertySource auxilia no uso das properties
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UploadServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class NotasResourceIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private NotaFiscalRepository repository;
	
	@Test
	public void deveListarNotas() throws Exception {
		   mvc.perform(get("/notas-fiscais")
				      .contentType(MediaType.APPLICATION_JSON))
				      .andExpect(status().isOk())
				      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				      .andExpect(jsonPath("$[0].numero", is("35180706225746000422550010000106141999893856")));
	}
	
}
