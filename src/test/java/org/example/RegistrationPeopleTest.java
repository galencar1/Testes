package org.example;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class RegistrationPeopleTest {
/*************************************************************************************/
    RegistrationPeople registrationPeople;
/*************************************************************************************/
    Pessoa pessoa;
/*************************************************************************************/
    @Before
    public void setUp(){
        registrationPeople = new RegistrationPeople();
    /****************************************************/
        pessoa = new Pessoa();
    }

    @Test
    public void mustCreateRegistrationPeople(){
        //scenario
        //executor
        //verification
        Assertions.assertThat(registrationPeople.getPessoas()).isEmpty();

    }

    @Test
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

    @Test(expected = PessoaSemNomeException.class)
    public void mustNotAddPeopleWithEmptyName(){
        //scenario
        //executor
        registrationPeople.adicionar(pessoa);
    }

    @Test
    public void mustRemovePeople(){
        //scenario
        pessoa.setNome("Zaraki");
        registrationPeople.adicionar(pessoa);
        //executor
        registrationPeople.remover(pessoa); // remove o cadastro.
        //verification
        Assertions.assertThat(registrationPeople.getPessoas()).isEmpty(); // Após remover o cadastro, deve estar vazio.
    }

    @Test(expected = CadastroVazioException.class)
    public void shouldThrowErrorWhenTryingToRemoveNonExistentPerson(){
        //scenario
        //executor
        registrationPeople.remover(pessoa);
        //verification

    }
}
