package view;
import javax.swing.JOptionPane;
import controller.ModController;

public class Menu {

	public static void main(String[] args) {
		ModController m= new ModController();
		String sys= m.So();
		int opcao=0;
		while (opcao==0) {
			opcao= Integer.parseInt(JOptionPane.showInputDialog("escolha uma opcao: \n 1- processos \n 2-PID \n 3-nome "));
		}
		if (opcao==1) {
			m.Ler(sys);
		}
		else if (opcao==2) {
			int PID= Integer.parseInt(JOptionPane.showInputDialog("PID: "));
			m.FinalizarPorPID(PID, sys);
		}
		else if(opcao==3) {
			String nome= JOptionPane.showInputDialog("nome: ");
			m.FinalizarPorNome(nome, sys);
		}
	}

}
