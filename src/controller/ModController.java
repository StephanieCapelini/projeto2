package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ModController {
	public String So() {
		String X= System.getProperty("os.name");
		return X;
		
	}
	public void Ler(String So) {
		if (So.contains("Windows")) {
			try {
				Process p=Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream fluxo= p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer= new BufferedReader(leitor);
				String linha= buffer.readLine();
				while (linha!=null) {
					System.out.println(linha);
					linha= buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			}
			catch(IOException E) {
				E.printStackTrace();
			}
		}
		else if (So.contains("Linux")) {
			try {
				Process p=Runtime.getRuntime().exec("ps -ef");
				InputStream fluxo= p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer= new BufferedReader(leitor);
				String linha= buffer.readLine();
				while (linha!=null) {
					System.out.println(linha);
					linha= buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			}
			catch(IOException E) {
				E.printStackTrace();
			}
		}
	}
	public void FinalizarPorPID(int id, String So) {
		if(So.contains("Windows")) {
			String comand= "TASKKILL /PID";
			StringBuffer buffer= new StringBuffer();
			try {
				buffer.append(comand);
				buffer.append(" ");
				buffer.append(id);
				buffer.append(" /F");
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			Leitura(buffer.toString());
			
		}
		else if(So.contains("Linux")) {
			String comand= "kill -9";
			StringBuffer buffer= new StringBuffer();
			try {
				buffer.append(comand);
				buffer.append(" ");
				buffer.append(id);
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			Leitura(buffer.toString());
			
		}
		
	}
	public void FinalizarPorNome(String nome,String So) {
		if(So.contains("Windows")) {
			String comand= "TASKKILL /IM";
			StringBuffer buffer= new StringBuffer();
			try {
				buffer.append(comand);
				buffer.append(" ");
				buffer.append(nome); 
				buffer.append(" /F");
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			Leitura(buffer.toString());
			
		}
		else if(So.contains("Linux")) {
			String comand= "pkill -f";
			StringBuffer buffer= new StringBuffer();
			try {
				buffer.append(comand);
				buffer.append(" ");
				buffer.append(nome);
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			Leitura(buffer.toString());
			
		}
	}
	public void Leitura(String id) {
		try {
			Runtime.getRuntime().exec(id);
			
		}
		catch (Exception e) {
			String error= e.getMessage();
			if (error.contains("740")) {
				StringBuffer buffer= new StringBuffer();
				buffer.append("cmd /c ");
				buffer.append(id);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				}
				catch (IOException y) {
					y.printStackTrace();
				}
			}
		}
	}
	
}
