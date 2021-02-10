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
public class CidadeControllerTest {
	@Autowired
	public MockMvc mockMvc;

    private static final String BASE_URI = "/api/cidades/";

    @Test
    public void test_Buscar_Todas_Cidades_Com_Sucesso() throws Exception {
        mockMvc.perform(get(BASE_URI))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_Buscar_Cidade_Por_Estado_Com_Sucesso() throws Exception {
        mockMvc.perform(get(BASE_URI + "{id}", "rs"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_Buscar_Cidade_Por_Nome_Com_Sucesso() throws Exception {
        mockMvc.perform(get(BASE_URI + "{nome}", "Por"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_Cadastrar_Cidade_Com_Sucesso() throws Exception {

        String cidade = "{\"nome\": \"Criciúma\", \"estado\": \"SC\"}}";

        mockMvc.perform(post(BASE_URI).content((cidade))
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isCreated())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_Editar_Cidade_Com_Sucesso() throws Exception {

        String cidade = "{\"nome\": \"Fortaleza\", \"estado\": \"CE\"}}";

        mockMvc.perform(put(BASE_URI + "{id}", "6").content((cidade))
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_Excluir_Cidade_Com_Sucesso() throws Exception {
        mockMvc.perform(delete(BASE_URI + "{id}", "7"))
               .andExpect(status().isOk());
    }

    @Test
    public void test_Buscar_Cidade_Por_Estado_Inexistente() throws Exception {
        mockMvc.perform(get(BASE_URI + "{estado}", "21"))
               .andExpect(status().isNotFound())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_Buscar_Cidade_Por_Nome_Inexistente() throws Exception {
        mockMvc.perform(get(BASE_URI + "{nome}", "Alegrete"))
               .andExpect(status().isNotFound())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_Buscar_Cidade_Por_Estado_Invalido() throws Exception {
        mockMvc.perform(get(BASE_URI + "{estado}", "+++++%¨¨&&***(098)"))
               .andExpect(status().isNotFound())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_Buscar_Cidade_Por_Nome_Invalido() throws Exception {
        mockMvc.perform(get(BASE_URI + "{nome}", "_k__io###!!****"))
               .andExpect(status().isNotFound())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_Cadastrar_Cidade_Com_Entrada_De_Dados_Invalidos() throws Exception {

        String cidade = "{\"nome\": \"Criciúma\", \"estado\": \"!@@@@@@@###### 1561600894890v**** 8498\"}}";

        mockMvc.perform(post(BASE_URI).content((cidade))
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isBadRequest())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_Editar_Cidade_Com_Entrada_De_Dados_Invalidos() throws Exception {

        String cidade = "{\"nome\": \"\", \"estado\": \"SC\"}}";

        mockMvc.perform(put(BASE_URI + "{id}", "2").content((cidade))
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isBadRequest())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_Excluir_Cidade_Inexistente_Ou_Ja_Excluida() throws Exception {
        mockMvc.perform(delete(BASE_URI + "{id}", "148"))
               .andExpect(status().isBadRequest());
    }
    
    @Test
    public void test_Excluir_Cidade_Com_Relacionamento_FK_Ativo_Com_Um_Cliente() throws Exception {
        mockMvc.perform(delete(BASE_URI + "{id}", "8"))
               .andExpect(status().isBadRequest());
    }
    

}
