package app.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.CalculoService;

@SpringBootTest
public class CalculoServiceTest {
	
	@Autowired
	CalculoService calculoService;
	
	@BeforeEach
    void setUp() {
        calculoService = new CalculoService();
    }


	@Test
	@DisplayName("Cena 01 - Testando o método somar com valores válidos")
	void cenario01() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(5);
		lista.add(2);
		
		int resultadoEsperado = 10;
		int resultadoObtido = this.calculoService.soma(lista);
		
		assertEquals(resultadoEsperado, resultadoObtido);
	}
	

	@Test
	@DisplayName("Cena 02 - Testando o método somar com valores inválidos")
	void cenario02() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(null);
		lista.add(2);
				
		assertThrows(Exception.class,() -> {
			this.calculoService.soma(lista);
		});
		
		
	}
	
	
	
	
	@Test
	@DisplayName("Cena 03 - Testar mediana com número par de elementos")
	void cenario03() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		assertEquals(3, this.calculoService.mediana(lista));
	}
	
	@Test
	@DisplayName("Cena 04 - Testar mediana com número ímpar de elementos")
	void cenario04() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(1);
		lista.add(9);
		lista.add(4);
		
		assertEquals(3, this.calculoService.mediana(lista));
	}
	
	
	@Test
	@DisplayName("Cena 05 - Testar mediana com número ímpar de elementos")
	void cenario05() {
		List<Integer> lista = new ArrayList<>();
		lista.add(8);
		lista.add(2);
		lista.add(1);
		lista.add(9);
		lista.add(39);
		lista.add(339);
		lista.add(4);
		
		assertEquals(8, this.calculoService.mediana(lista));
	}
	
	
    @Test
    @DisplayName("Cena 06 - Lista normal")
    void testSoma_ListaNormal() {
        List<Integer> lista = Arrays.asList(1, 2, 3, 4);
        assertEquals(10, calculoService.soma(lista));
    }

    @Test
    @DisplayName("Cena 07 - Lista com zeros")
    void testSoma_ListaComZeros() {
        List<Integer> lista = Arrays.asList(0, 0, 0);
        assertEquals(0, calculoService.soma(lista));
    }

    @Test
    @DisplayName("Cena 08 - Lista com Negativos")
    void testSoma_ListaComNegativos() {
        List<Integer> lista = Arrays.asList(-1, -2, -3, -4);
        assertEquals(-10, calculoService.soma(lista));
    }

    @Test
    @DisplayName("Cena 09 - Lista com Null")
    void testSoma_ListaComNull() {
        List<Integer> lista = Arrays.asList(1, null, 3);
        assertThrows(RuntimeException.class, () -> calculoService.soma(lista));
    }

    @Test
    @DisplayName("Cena 10 - Lista Normal")
    void testMedia_ListaNormal() {
        List<Integer> lista = Arrays.asList(1, 2, 3, 4);
        assertEquals(2.5, calculoService.media(lista));
    }

    @Test
    @DisplayName("Cena 11 - Lista com Zeros")
    void testMedia_ListaComZeros() {
        List<Integer> lista = Arrays.asList(0, 0, 0);
        assertEquals(0, calculoService.media(lista));
    }

    @Test
    @DisplayName("Cena 12 - Lista com Negativos")
    void testMedia_ListaComNegativos() {
        List<Integer> lista = Arrays.asList(-1, -2, -3, -4);
        assertEquals(-2.5, calculoService.media(lista));
    }

    @Test
    @DisplayName("Cena 13 - Lista Vazia")
    void testMedia_ListaVazia() {
        assertThrows(ArithmeticException.class, () -> calculoService.media(Arrays.asList()));
    }

    @Test
    @DisplayName("Cena 14 - Lista Com Elementos Impares")
    void testMediana_ListaComElementosÍmpares() {
        List<Integer> lista = Arrays.asList(1, 3, 7, 9, 11);
        assertEquals(7, calculoService.mediana(lista));
    }

    @Test
    @DisplayName("Cena 15 - Lista Com Elementos Pares")
    void testMediana_ListaComElementosPares() {
        List<Integer> lista = Arrays.asList(1, 3, 7, 9);
        assertEquals(5, calculoService.mediana(lista));
    }

    @Test
    @DisplayName("Cena 16 - Lista Ordenada")
    void testMediana_ListaOrdenada() {
        List<Integer> lista = Arrays.asList(10, 20, 30, 40);
        assertEquals(25, calculoService.mediana(lista));
    }

    @Test
    @DisplayName("Cena 17 - Lista Desordenada")
    void testMediana_ListaDesordenada() {
        List<Integer> lista = Arrays.asList(40, 10, 30, 20);
        assertEquals(25, calculoService.mediana(lista));
    }

    @Test
    @DisplayName("Cena 18 - Lista Vazia")
    void testMediana_ListaVazia() {
        assertThrows(IllegalArgumentException.class, () -> calculoService.mediana(Arrays.asList()));
    }

    @Test
    @DisplayName("Cena 19 - Lista com Null")
    void testMediana_ListaNula() {
        assertThrows(IllegalArgumentException.class, () -> calculoService.mediana(null));
    }
}


