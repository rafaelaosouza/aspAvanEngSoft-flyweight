package empresa;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaTest {

    @Test
    void deveRetornarFuncionarios() {
        Empresa empresa = new Empresa();
        empresa.contratar("Jose", "Analista de Sistemas", "Tecnologia");
        empresa.contratar("Maria", "Analista de Sistemas", "Tecnologia");
        empresa.contratar("Ana", "Analista de Sistemas", "Tecnologia");
        empresa.contratar("Joao", "Contador", "Financeiro");

        List<String> saida = Arrays.asList(
                "Funcionario{nome='Jose', cargo='Analista de Sistemas', departamento='Tecnologia'}",
                "Funcionario{nome='Maria', cargo='Analista de Sistemas', departamento='Tecnologia'}",
                "Funcionario{nome='Ana', cargo='Analista de Sistemas', departamento='Tecnologia'}",
                "Funcionario{nome='Joao', cargo='Contador', departamento='Financeiro'}");

        assertEquals(saida, empresa.obterFuncionarios());
    }

    @Test
    void deveRetornarTotalCargos() {
        Empresa empresa = new Empresa();
        empresa.contratar("Jose", "Analista de Sistemas", "Tecnologia");
        empresa.contratar("Maria", "Analista de Sistemas", "Tecnologia");
        empresa.contratar("Ana", "Analista de Sistemas", "Tecnologia");
        empresa.contratar("Joao", "Contador", "Financeiro");

        assertEquals(2, CargoFactory.getTotalCargos());
    }

    @Test
    void deveRetornarMesmoCargoParaMesmoNome() {
        Cargo cargo1 = CargoFactory.getCargo("Analista de Sistemas", "Tecnologia");
        Cargo cargo2 = CargoFactory.getCargo("Analista de Sistemas", "Tecnologia");

        assertSame(cargo1, cargo2);
    }

    @Test
    void deveRetornarCargosDiferentesParaNomesDiferentes() {
        Cargo cargo1 = CargoFactory.getCargo("Analista de Sistemas", "Tecnologia");
        Cargo cargo2 = CargoFactory.getCargo("Contador", "Financeiro");

        assertNotSame(cargo1, cargo2);
    }

    @Test
    void deveRetornarListaVaziaSemContratacoes() {
        Empresa empresa = new Empresa();

        assertTrue(empresa.obterFuncionarios().isEmpty());
    }

}
