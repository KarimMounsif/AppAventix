package com.qrcodeteam.bom;

public class EntrepriseEmploye {


    private Entreprise entreprise;
    private Employe employe;


    public EntrepriseEmploye(Entreprise entreprise, Employe employe) {
        this.entreprise = entreprise;
        this.employe = employe;
    }


    public EntrepriseEmploye() {

    }


    public Entreprise getEntreprise() {
        return entreprise;
    }


    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }


    public Employe getEmploye() {
        return employe;
    }


    public void setEm(Employe employe) {
        this.employe = employe;
    }


}
