package empresa;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private List<Funcionario> funcionarios = new ArrayList<>();

    public void contratar(String nomeFuncionario, String nomeCargo, String departamento) {
        Cargo cargo = CargoFactory.getCargo(nomeCargo, departamento);
        Funcionario funcionario = new Funcionario(nomeFuncionario, cargo);
        funcionarios.add(funcionario);
    }

    public List<String> obterFuncionarios() {
        List<String> saida = new ArrayList<String>();
        for (Funcionario funcionario : this.funcionarios) {
            saida.add(funcionario.obterFuncionario());
        }
        return saida;
    }


}
