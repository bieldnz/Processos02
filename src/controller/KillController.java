package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	private String os() {
		if(System.getProperty("os.name").contains("Windows")) {
			return "Windows";
		}else {
			return "Linux";
		}
	}
	public void listaProcessos() {
		String proc;
		if(os().contains("Windows")) {
			proc = "TASKLIST /FO TABLE";
			System.out.println("JKD");
		}else {
			proc = "ps -ef";
		}
		String[] arrProc = proc.split(" ");
		
		try {
			Process p = Runtime.getRuntime().exec(arrProc);
			InputStream fluxo = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(reader);
			String linha = buffer.readLine();
			System.out.println(linha);
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			fluxo.close();
			reader.close();
			buffer.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void mataPID(int pid) {
		String proc;
		if(os().contains("Windows")) {
			proc = "TASKKILL /PID "+pid;
		}else {
			proc = "kill -9 "+pid;
		}
		
		String[] arrProc = proc.split(" ");
		
		try {
			Runtime.getRuntime().exec(arrProc);
		}catch(Exception e1) {
			System.err.println(e1.getMessage());
		}
	}
	
	public void mataNome(String nome) {
		String proc;
		if(os().contains("Windows")) {
			proc = "TASKKILL /IM "+nome;
		}else {
			proc = "pkill -f "+nome;
		}
		String[] arrProc = proc.split(" ");
		
		try {
			Runtime.getRuntime().exec(arrProc);
		}catch(Exception e2) {
			System.out.println(e2.getMessage());
		}
	}
	
}
