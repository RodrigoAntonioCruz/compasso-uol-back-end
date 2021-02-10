package com.compasso.api.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ClienteControllerTest {
    @Autowired
    public MockMvc mockMvc;

    private static final String BASE_URI = "/api/clientes/";

    
    @Test
    public void test_Buscar_Todos_Clientes_Com_Sucesso() throws Exception {
        mockMvc.perform(get(BASE_URI))
			   .andExpect(status().isOk())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    
    @Test
	public void test_Buscar_Cliente_Por_Id_Com_Sucesso() throws Exception {
		mockMvc.perform(get(BASE_URI + "{id}", "1"))
			   .andExpect(status().isOk())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    
    @Test
    public void test_Buscar_Cliente_Por_Nome_Com_Sucesso() throws Exception {
        mockMvc.perform(get(BASE_URI + "{nome}", "rodrigo"))
			   .andExpect(status().isOk())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    
    @Test
    public void test_Cadastrar_Cliente_Com_Sucesso() throws Exception {
    	        
        String cliente = "{\"nome\": \"Karin Costa\", \"idade\": 37, \"data_nascimento\": \"1984-09-10\", \"sexo\": \"F\", \"cidade\": { \"id\": 3 }}";
        
        mockMvc.perform(post(BASE_URI)
               .content((cliente))
               .contentType(MediaType.APPLICATION_JSON))
			   .andExpect(status().isCreated())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    

    @Test
    public void test_Editar_Cliente_Com_Sucesso() throws Exception {

    	String cliente = "{\"nome\": \"Carla da Silva\", \"idade\": 41, \"data_nascimento\": \"1980-04-29\", \"sexo\": \"F\", \"cidade\": { \"id\": 4 }}";
    	
        mockMvc.perform(put(BASE_URI + "{id}", "9")
        	   .content((cliente))
               .contentType(MediaType.APPLICATION_JSON))
			   .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    
    @Test
    public void test_Excluir_Cliente_Com_Sucesso() throws Exception {
        mockMvc.perform(delete(BASE_URI + "{id}", "11"))
			   .andExpect(status().isOk());
    }
    
    
    @Test
	public void test_Buscar_Cliente_Por_Id_Inexistente() throws Exception {
		mockMvc.perform(get(BASE_URI + "{id}", "18"))
			   .andExpect(status().isNotFound())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    
    @Test
    public void test_Buscar_Cliente_Por_Nome_Inexistente() throws Exception {
        mockMvc.perform(get(BASE_URI + "{nome}", "rogerio"))
			   .andExpect(status().isNotFound())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
	public void test_Buscar_Cliente_Por_Id_Invalido() throws Exception {
		mockMvc.perform(get(BASE_URI + "{id}", "$$#@13rd1xw2 wz!!O0I"))
			   .andExpect(status().isBadRequest())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    
    @Test
    public void test_Buscar_Cliente_Por_Nome_Invalido() throws Exception {
        mockMvc.perform(get(BASE_URI + "{nome}", "@@#1z23rfqcex32!!90"))
			   .andExpect(status().isBadRequest())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_Cadastrar_Cliente_Com_Entrada_De_Dados_Invalidos() throws Exception {
    	
    	String cliente = "{\"nome\": \"Rodrigo da Cruz\", \"idade\": -35, \"data_nascimento\": \"11985-06-28\", \"sexo\": \"M\", \"cidade\": { \"id\": 1 }}";
  	
        mockMvc.perform(post(BASE_URI)
                .content((cliente))
                .contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    
    @Test
    public void test_Editar_Cliente_Com_Entrada_De_Dados_Invalidos() throws Exception {
    	
    	String cliente = "{\"nome\": \"\", \"idade\": 41, \"data_nascimento\": \"1980-04-29\", \"sexo\": \"F\", \"cidade\": { \"id\": 4 }}";
    	
        mockMvc.perform(put(BASE_URI + "{id}", "1")
        	   .content((cliente))
               .contentType(MediaType.APPLICATION_JSON))
			   .andExpect(status().isBadRequest())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    
    @Test
    public void test_Excluir_Cliente_Inexistente_Ou_Ja_Excluido() throws Exception {
        mockMvc.perform(delete(BASE_URI + "{id}", "350"))
			   .andExpect(status().isBadRequest());
    }
  
}
