package org.example;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MockitoTests {
    @Test
    public void primeiroTesteMockito(){
        //List<String> lista = new ArrayList<>(); // Sem mockito instanciamos assim.
        List<String> lista = Mockito.mock(ArrayList.class); // Instanciando com Mockito
        // Utilizando mockito podemos manipular o comportamente da lista instanciada acima.

        Mockito.when( lista.size()) .thenReturn(20); // Nesse caso dizemos, através do mockito que a lista já
        //possui 20 elementos.

        int size = lista.size();
        Assertions.assertThat(size).isEqualTo(20);
    }
}
