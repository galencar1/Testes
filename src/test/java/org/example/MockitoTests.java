package org.example;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTests {
    @Mock // Instanciando com Mockito - Lembre-se de anotar @RunWith(MockitoJUnitRunner) acima da classe.
    List<String> lista;
    @Test
    public void primeiroTesteMockito(){
        //List<String> lista = new ArrayList<>(); // Sem mockito instanciamos assim.

        // Utilizando mockito podemos manipular o comportamente da lista instanciada acima.

        Mockito.when( lista.size()) .thenReturn(20); // Nesse caso dizemos, através do mockito que a lista já
        //possui 20 elementos.

        int size = lista.size();
        Assertions.assertThat(size).isEqualTo(20);
    }

    //Mockito.verify -> verifica chamada de métodos. Ótimo para verificar se métodos
    //foram realmente chamados no código.
    @Test
    public void mockitoVerify(){
        Mockito.when(lista.size() ).thenReturn(2);
        int size = 0;
        if(1 == 1){
            size = lista.size();
            size  = lista.size();
        }
        //Mockito times - verifica quantas vezes o método foi invocado
        Mockito.verify(lista, Mockito.times(2)).size();
    }

    // Mockito never - Verifica se um método nunca foi invocado
    @Test
    public void mockitoNever(){
        int size = 0;
        if(1 == 2){
            size = lista.size();
        }
        Mockito.verify(lista, Mockito.never()).size();
    }

    //Mockito In Order - Verifica se um método foi invocado na exata ordem especificada
    @Test
    public void mockitoInOrder(){
        lista.size();
        lista.add("");

        InOrder inOrder = Mockito.inOrder(lista);//Instanciado objeto InOrder
        inOrder.verify(lista).size(); // Verifica se chamará o método size primeiro
        inOrder.verify(lista).add("");// Verifica se chamará o método add segundo
    }

}
