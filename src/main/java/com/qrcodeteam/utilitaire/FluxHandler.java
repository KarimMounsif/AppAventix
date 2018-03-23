package com.qrcodeteam.utilitaire;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FluxHandler {
	
	 String rootPath = System.getProperty("catalina.home");
	 File dir=null;
     BufferedWriter bw = null;
     FileWriter fw = null;

	 
     public	FluxHandler(String nomDossier){
		 
		 dir = new File(rootPath + File.separator+ nomDossier);
		 if (!dir.exists())
				dir.mkdirs();
		 
	 }
	 
	 public void ecrireFichier(String nomFichier, String contenu) {
		 
		 File f =new File(dir.getAbsolutePath()+File.separator+nomFichier+".txt");
		 try {
			 
			fw = new FileWriter(f.getAbsolutePath(),true);
			bw = new BufferedWriter(fw);
			bw.write(contenu);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Impossible d'écrire dans le fichier");
		}finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		} 
	 }
	 
	 
	
}
