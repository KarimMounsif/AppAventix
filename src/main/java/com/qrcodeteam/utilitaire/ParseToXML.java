package com.qrcodeteam.utilitaire;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.qrcodeteam.beans.Facture;

public class ParseToXML {
	
	
	
	public static void parseClassToXml(Facture f) {
		
	      try {
	          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	          
	          // Doc element
	          Document doc = dBuilder.newDocument();
	          
	          // root element
	          Element rootElement = doc.createElement("Facture");
	          doc.appendChild(rootElement);

	          //commande element
	          Element commande = doc.createElement("Commande");
	          rootElement.appendChild(commande);
	          
	          //Entreprise element
	          Element entreprise = doc.createElement("entreprise");
	          rootElement.appendChild(entreprise);
	          
	          
	          // setting id attribute to element commande
	          Attr attr = doc.createAttribute("idCommande");
	          attr.setValue(f.getC().getIdCommande());
	          commande.setAttributeNode(attr);
	          
	          //quantite element
	          Element quantite = doc.createElement("quantite");
	          quantite.appendChild(doc.createTextNode(String.valueOf(f.getC().getQuantiteCommande())));
	          commande.appendChild(quantite );

	          //dateCommande element
	          Element dateCommande = doc.createElement("dateCommande");
	          dateCommande.appendChild(doc.createTextNode(String.valueOf(f.getC().getDateCommande())));
	          commande.appendChild(dateCommande);
	          
	          //dateLivraison element
	          Element dateLivraison = doc.createElement("dateLivraison");
	          dateLivraison.appendChild(doc.createTextNode(String.valueOf(f.getC().getDateLivraisonCommande())));
	          commande.appendChild(dateLivraison);
	          
	         //prixCommande element
	          Element prixCommande = doc.createElement("prixCommande");
	          prixCommande.appendChild(doc.createTextNode(String.valueOf(f.getC().getPrixCommande())));
	          commande.appendChild(prixCommande);
	          
	        // reduction element
	          Element reduction = doc.createElement("reduction");
	          reduction.appendChild(doc.createTextNode(String.valueOf(f.getReduction())));
	          commande.appendChild(reduction);
	          
	          
	        //nomEntreprise element
	          Element nomEntreprise = doc.createElement("nomEntreprise");
	          nomEntreprise.appendChild(doc.createTextNode(String.valueOf(f.getE().getNomEntreprise())));
	          entreprise.appendChild(nomEntreprise);
	          
	          
		     //nomService element
	          Element nomService = doc.createElement("nomService");
	          nomService.appendChild(doc.createTextNode(String.valueOf(f.getE().getNomService())));
	          entreprise.appendChild(nomService); 
	          
	          //adresse element
	          Element adresseEntreprise = doc.createElement("adresseEntreprise");
	          adresseEntreprise.appendChild(doc.createTextNode(String.valueOf(f.getE().getAdresseEntreprise())));
	          entreprise.appendChild(adresseEntreprise); 
	          
	          //ville element
	          Element villeEntreprise = doc.createElement("villeEntreprise");
	          villeEntreprise.appendChild(doc.createTextNode(String.valueOf(f.getE().getVilleEntreprise())));
	          entreprise.appendChild(villeEntreprise); 
	          
	          
	          // code Postal element
	          Element codePostalEntreprise = doc.createElement("codePostalEntreprise");
	          codePostalEntreprise.appendChild(doc.createTextNode(String.valueOf(f.getE().getCodePostalEntreprise())));
	          entreprise.appendChild(codePostalEntreprise); 

	          
	          // mail Entreprise element
	          Element mailEntreprise = doc.createElement("mailEntreprise");
	          mailEntreprise.appendChild(doc.createTextNode(String.valueOf(f.getE().getMailEntreprise())));
	          entreprise.appendChild(mailEntreprise); 
	          
	          // tel Entreprise element
	          Element telEntreprise = doc.createElement("telEntreprise");
	          telEntreprise.appendChild(doc.createTextNode(String.valueOf(f.getE().getTelEntreprise())));
	          entreprise.appendChild(telEntreprise);

	          // write the content into xml file
	          
	          String rootPath = System.getProperty("catalina.home");
	          File dir = new File(rootPath + File.separator+ "Facture");
	          
	          if (!dir.exists())
					dir.mkdirs();
	          
	          TransformerFactory transformerFactory = TransformerFactory.newInstance();
	          Transformer transformer = transformerFactory.newTransformer();
	          DOMSource source = new DOMSource(doc);
	          StreamResult result = new StreamResult(new File(dir.getAbsolutePath() + File.separator+f.getC().getIdCommande()+".xml"));
	          transformer.transform(source, result);
	          
	          // Output to console for testing
	          StreamResult consoleResult = new StreamResult(System.out);
	          transformer.transform(source, consoleResult);
	          
	       } catch (Exception e) {
	         System.out.println(e.getMessage());
	         System.out.println("Il y a une tar dans ton code de parsing ...");
	       }
	    }
	


}


