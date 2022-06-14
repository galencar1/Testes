package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationPeopleTest {
/*************************************************************************************/
    RegistrationPeople registrationPeople;
/*************************************************************************************/
    Pessoa pessoa;
/*************************************************************************************/
    @BeforeEach
    public void setUp(){
        registrationPeople = new RegistrationPeople();
        pessoa = new Pessoa();
    }

    @Test
    @DisplayName("Must Create Registration People")
    public void mustCreateRegistrationPeople(){
        //scenario
        //executor
        //verification
        Assertions.assertThat(registrationPeople.getPessoas()).isEmpty();

    }

    @Test
    @DisplayName("Must Add People")
    public void mustAddPeople(){
        //scenario
        pessoa.setNome("Zaraki");
        //executor
        registrationPeople.adicionar(pessoa);
        //verification
        Assertions
                .assertThat(registrationPeople.getPessoas())
                .isNotEmpty() // Não pode ser vazio
                .hasSize(1) // deve ter apenas uma pessoa
                .contains(pessoa); // contém a classe pessoa.
    }

    @Test//(expected = PessoaSemNomeException.class)
    @DisplayName("Must Not Add People With Empty Name")
    public void mustNotAddPeopleWithEmptyName(){
        //scenario
        //executor
        org.junit.jupiter.api.Assertions
                        .assertThrows(PessoaSemNomeException.class, () -> registrationPeople.adicionar(pessoa));
    }

    @Test
    @DisplayName("Must Remove People")
    public void mustRemovePeople(){
        //scenario
        pessoa.setNome("Zaraki");
        registrationPeople.adicionar(pessoa);
        //executor
        registrationPeople.remover(pessoa); // remove o cadastro.
        //verification
        Assertions.assertThat(registrationPeople.getPessoas()).isEmpty(); // Após remover o cadastro, deve estar vazio.
    }

    @Test//(expected = CadastroVazioException.class)
    @DisplayName("Should throw error when trying remove Non existent person")
    public void shouldThrowErrorWhenTryingToRemoveNonExistentPerson(){
        //scenario
        //executor
        org.junit.jupiter.api.Assertions
                .assertThrows(CadastroVazioException.class, () -> registrationPeople.remover(pessoa) );
        //verification

    }
}
