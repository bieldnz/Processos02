package view;

import javax.swing.JOptionPane;
import controller.KillController;
public class Principal {
	public static void main(String[] args) {
		int opc;
		KillController kill = new KillController();
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Listar processos \n"
															  +"2 - Matar PID \n"
															  +"3 - Matar nome \n"
															  +"9 - FIM"));
			switch(opc) {
			case 1:
				kill.listaProcessos();
				break;
			case 2:
				int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID: "));
				kill.mataPID(pid);
				break;
			case 3:
				String nome = JOptionPane.showInputDialog("Digite o nome do processo: ");
				kill.mataNome(nome);
				break;
			case 9:
				break;
			default:
				System.out.println("Digite uma opção válida");
				break;
			}
		}while(opc != 9);
		
	}
}
