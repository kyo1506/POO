import javax.swing.*;

public class ExerciseSix {

    public static void main(String[] args){
        int trimestre = Integer.parseInt(JOptionPane.showInputDialog("Digite o trimestre"));
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês"));

        mostrarMesDoTrimestre(trimestre, mes);
    }

    private static void mostrarMesDoTrimestre(int trimestre, int mes){
        if (trimestre < 1 || trimestre > 4){
            JOptionPane.showMessageDialog(null, "O trimestre informado deve ser 1, 2, 3 ou 4");
            gerenciarMenu();
        }

        if (mes < 1 || mes > 12){
            JOptionPane.showMessageDialog(null, "O mes informado deve ser maior ou igual a 1 e menor" +
                    "ou igual a 12");
            gerenciarMenu();
        }

        if (trimestre == 1 && mes > 3){
            JOptionPane.showMessageDialog(null, "O mês informado não corresponde ao trimestre informado");
            gerenciarMenu();
        }

        if (trimestre == 2 && (mes < 4 || mes > 7)){
            JOptionPane.showMessageDialog(null, "O mês informado não corresponde ao trimestre informado");
            gerenciarMenu();
        }

        if (trimestre == 3 && (mes < 7 || mes > 9)){
            JOptionPane.showMessageDialog(null, "O mês informado não corresponde ao trimestre informado");
            gerenciarMenu();
        }

        if (trimestre == 4 && (mes < 10)){
            JOptionPane.showMessageDialog(null, "O mês informado não corresponde ao trimestre informado");
            gerenciarMenu();
        }

        switch (mes){
            case 1:
                JOptionPane.showMessageDialog(null, "JANEIRO");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "FEVEREIRO");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "MARÇO");
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "ABRIL");
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "MAIO");
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "JUNHO");
                break;
            case 7:
                JOptionPane.showMessageDialog(null, "JULHO");
                break;
            case 8:
                JOptionPane.showMessageDialog(null, "AGOSTO");
                break;
            case 9:
                JOptionPane.showMessageDialog(null, "SETEMBRO");
                break;
            case 10:
                JOptionPane.showMessageDialog(null, "OUTUBRO");
                break;
            case 11:
                JOptionPane.showMessageDialog(null, "NOVEMBRO");
                break;
            case 12:
                JOptionPane.showMessageDialog(null, "DEZEMBRO");
                break;
            default:
                break;
        }

        gerenciarMenu();
    }

    private static void gerenciarMenu(){
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja testar novamente?");

        if (confirm != 0){
            System.exit(0);
        } else {
            main(null);
        }
    }
}

