import ExerciseFive.Cocker;
import ExerciseFour.Data;
import ExerciseOne.Faturar;
import ExerciseThree.Calculadora;
import ExerciseTwo.Empregado;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String...args){
        //exercicio1();

        //exercicio2();

        //exercicio3();

        //exercicio4(4, new Data());

        //exercicio5();

        exercicio6();
    }

    private static void exercicio1(){

        int produto = Integer.parseInt(JOptionPane.showInputDialog("""
                Digite o código do produto\s
                 1312 - Chocolate\s
                 3422 - Suspiro
                 4211 - Bolo\s
                 4345 - Torta de Limão"""));


        while (produto == 1312 || produto == 3422 || produto == 4211 || produto == 4335){
            String descricao = "";
            double valor = 0;

            switch (produto) {
                case 1312 -> {
                    descricao = "Chocolate";
                    valor = 6.99;
                }
                case 3422 -> {
                    descricao = "Suspiro";
                    valor = 2.99;
                }
                case 4211 -> {
                    descricao = "Bolo";
                    valor = 23.99;
                }
            }


            int qtdItem = Integer.parseInt(JOptionPane.showInputDialog("Você está comprando "+ descricao
                    +"\nDigite a quantidade de itens que deseja comprar"));


            Faturar faturar = new Faturar(Integer.toUnsignedLong(produto), descricao, qtdItem, valor);

            JOptionPane.showMessageDialog(null, "Número do produto: "+ faturar.getNumero() +
                    "\n Descrição: "+ faturar.getDescricao() +" \n Quantidade: "+faturar.getQtd()+"\nTotal: R$"+faturar.getFaturaTotal());

            exercicio1();
        }

        JOptionPane.showMessageDialog(null, "Produto não encontrado!!");
        System.exit(0);
    }

    public static void exercicio2(){

        String nome;
        String sobrenome;
        double salario;
        List<Empregado> empregadoList = new ArrayList<>();
        StringBuilder salarioEmpregados = new StringBuilder();

        for(int i = 0; i < 2; i++){
            nome = JOptionPane.showInputDialog("Digite o nome do empregado");
            sobrenome = JOptionPane.showInputDialog("Digite o sobrenome do empregado");
            salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salario do empregado"));
            empregadoList.add(new Empregado(nome, sobrenome, salario));
        }


        for (Empregado empregado : empregadoList){
        salarioEmpregados.append("\nEmpregado: ").append(empregado.getNome()).append(" ").append(empregado.getSobrenome()).append("\n").append("Salário: R$ ").append(empregado.getSalario()).append("\n");
        }

        JOptionPane.showMessageDialog(null, salarioEmpregados.toString());

        int confirm = JOptionPane.showConfirmDialog(null, "Aplicar aumento de 10%?");

        salarioEmpregados = new StringBuilder();
        if (confirm == 0){
            for (Empregado empregado : empregadoList){
                double salarioAtual = empregado.getSalario();
                empregado.setSalario((empregado.getSalario() * 10/100) + salarioAtual);
                salarioEmpregados.append("\nEmpregado: ").append(empregado.getNome()).append(" ").append(empregado.getSobrenome()).append("\n").append("Salário: R$ ").append(empregado.getSalario()).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, salarioEmpregados.toString());
    }

    public static void exercicio3(){
        double valor1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro valor"));
        double valor2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo valor"));
        String  operacao = JOptionPane.showInputDialog("Digite a operação desejada");

        if (valor1 == 0 || valor2 == 0 && operacao.equals("/")){
            JOptionPane.showMessageDialog(null, "Não é possível dividir por zero!!");
        }

        Calculadora calculadora = new Calculadora(valor1, valor2, operacao);

        int calc = JOptionPane.showConfirmDialog(null, "Deseja calcular?");
        if (calc == 0){
            calculadora.calculaValor();
        }

        JOptionPane.showMessageDialog(null, calculadora.getMessage());
    }

    public static void exercicio4(int confirm, Data date){

        if (confirm == 4){
            String data = JOptionPane.showInputDialog("Digite a data");
            String[] dataSplit = data.split("/");
            int dia = Integer.parseInt(dataSplit[0]);
            int mes = Integer.parseInt(dataSplit[1]);
            int ano = Integer.parseInt(dataSplit[2]);
            date = new Data(dia, mes, ano);
        }

        int operacao = Integer.parseInt(JOptionPane.showInputDialog("1 - Ver dia \n 2 - Ver mês \n 3 - Ver ano \n 4 - Data Completa"));

        if (operacao == 1)
            JOptionPane.showMessageDialog(null, "" + date.getDia());
        if (operacao == 2)
            JOptionPane.showMessageDialog(null, "" + date.getMes());
        if (operacao == 3)
            JOptionPane.showMessageDialog(null, "" + date.getAno());
        if (operacao == 4)
            JOptionPane.showMessageDialog(null, "" + date.displayData());

        int con = JOptionPane.showConfirmDialog(null, "Deseja continuar testando?");
        if (con == 0){
            exercicio4(0,  date);
        }
    }

    public static void exercicio5(){

        String tipo = JOptionPane.showInputDialog("Digite o tipo do animal");
        String cor = JOptionPane.showInputDialog("Digite a cor do animal");
        String nome = JOptionPane.showInputDialog("Digite o nome do animal");
        String raca = JOptionPane.showInputDialog("Digite a raça do animal");
        boolean tosa = JOptionPane.showInputDialog("Precisa de tosa?").equalsIgnoreCase("sim");

        Cocker cocker = new Cocker();

        cocker.setTipo(tipo);
        cocker.setTosa(tosa);
        cocker.setCor(cor);
        cocker.setRaca(raca);
        cocker.setNome(nome);

        JOptionPane.showMessageDialog(null, "INFO PET \n\n" +
                "\n Nome: " + cocker.getNome() + "\n Raça: " + cocker.getRaca() +
                "\n Cor: " + cocker.getCor() + "\n Tipo: " + cocker.getTipo() +
                "\n Tosa: " + cocker.getTosa());
    }

    public static void exercicio6(){

        String nome = JOptionPane.showInputDialog("Digite o nome do funcionário");
        String sexo = JOptionPane.showInputDialog("Digite o sexo do funcionário");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do funcionário"));
        double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura do funcionário"));
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salario do funcionário"));

        ExerciseSix.Empregado empregado = new ExerciseSix.Empregado();
        empregado.setSalario(salario);
        empregado.setNome(nome);
        empregado.setAltura(altura);
        empregado.setIdade(idade);
        empregado.setSexo(sexo);

        JOptionPane.showMessageDialog(null, empregado + "\n Lucros: R$" + String.format( "%.2f", empregado.obterLucros() ));
    }
}
