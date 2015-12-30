package com.camlait.global.erp.domain.util;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.document.commerciaux.vente.DocumentDeVente;
import com.camlait.global.erp.domain.document.commerciaux.vente.FactureClient;
import com.camlait.global.erp.domain.document.commerciaux.vente.FactureClientComptant;
import com.camlait.global.erp.domain.document.commerciaux.vente.FactureMarge;
import com.camlait.global.erp.domain.document.stock.entree.BonDeRetour;
import com.camlait.global.erp.domain.document.stock.entree.BonEntree;
import com.camlait.global.erp.domain.document.stock.entree.DocumentEntree;
import com.camlait.global.erp.domain.document.stock.sortie.Animation;
import com.camlait.global.erp.domain.document.stock.sortie.Avarie;
import com.camlait.global.erp.domain.document.stock.sortie.BonDeSortie;
import com.camlait.global.erp.domain.document.stock.sortie.DocumentDeSortie;
import com.camlait.global.erp.domain.document.stock.sortie.Don;
import com.camlait.global.erp.domain.document.stock.sortie.Echantillon;
import com.camlait.global.erp.domain.enumeration.AutreEnum;
import com.camlait.global.erp.domain.enumeration.Portee;
import com.camlait.global.erp.domain.enumeration.document.EnumTypeEntite;
import com.camlait.global.erp.domain.enumeration.document.TypeDocumentEntree;
import com.camlait.global.erp.domain.enumeration.document.TypeDocumentSortie;
import com.camlait.global.erp.domain.enumeration.document.TypeDocumentVente;
import com.camlait.global.erp.domain.enumeration.document.TypeFacture;
import com.camlait.global.erp.domain.inventaire.Inventaire;
import com.camlait.global.erp.domain.partenaire.Caissier;
import com.camlait.global.erp.domain.partenaire.Client;
import com.camlait.global.erp.domain.partenaire.ClientAmarge;
import com.camlait.global.erp.domain.partenaire.ClientComptant;
import com.camlait.global.erp.domain.partenaire.Employe;
import com.camlait.global.erp.domain.partenaire.Magasinier;
import com.camlait.global.erp.domain.partenaire.Partenaire;
import com.camlait.global.erp.domain.partenaire.Vendeur;
import com.camlait.global.erp.domain.produit.CategorieProduit;

public final class Utility {

	public static boolean isFactureClient(Document document) {
		return document instanceof FactureClient;
	}

	public static boolean isFactureComptant(Document document) {
		return document instanceof FactureClientComptant;
	}

	public static boolean isFactureMarge(Document document) {
		return document instanceof FactureMarge;
	}

	public static boolean isDocumentDeVente(Document document) {
		return document instanceof DocumentDeVente;
	}

	public static boolean isDetail(CategorieProduit categorie) {
		return categorie.getPortee() == Portee.DETAIL;
	}

	public static boolean isTotal(CategorieProduit categorie) {
		return categorie.getPortee() == Portee.TOTAL;
	}

	public static String genererCode(Entite entite, Long lastId) {
		StringBuilder code = new StringBuilder(obtenirPrefixe(entite).getType());

		return code.toString();
	}

	public static EnumTypeEntite obtenirPrefixe(Entite entite) {

		if (entite instanceof Document) {
			if (entite instanceof DocumentDeVente) {
				if (entite instanceof FactureClient)
					return TypeDocumentVente.FACTURE_CLIENT;
				if (entite instanceof FactureClientComptant)
					return TypeFacture.FACTURE_COMPTANT;
			}

			if (entite instanceof DocumentDeSortie) {
				if (entite instanceof BonDeSortie)
					return TypeDocumentSortie.BON_DE_SORTIE;
				if (entite instanceof Echantillon)
					return TypeDocumentSortie.ECHANTILLON;
				if (entite instanceof Don)
					return TypeDocumentSortie.DON;
				if (entite instanceof Avarie)
					return TypeDocumentSortie.AVARIE;
				if (entite instanceof Animation)
					return TypeDocumentSortie.ANIMATION;
			}

			if (entite instanceof DocumentEntree) {
				if (entite instanceof BonEntree)
					return TypeDocumentEntree.BON_ENTREE;
				if (entite instanceof BonDeRetour)
					return TypeDocumentEntree.BON_RETOUR;
			}
		}

		if (entite instanceof Partenaire) {
			if (entite instanceof Employe)
				return AutreEnum.EMPLOYE;
			if (entite instanceof Client)
				return AutreEnum.CLIENT;
			if (entite instanceof ClientAmarge)
				return AutreEnum.CLIENT_A_MARGE;
			if (entite instanceof ClientComptant)
				return AutreEnum.CLIENT_COMPTANT;
			if (entite instanceof Magasinier)
				return AutreEnum.MAGASINIER;
			if (entite instanceof Vendeur)
				return AutreEnum.VENDEUR;
			if (entite instanceof Caissier)
				return AutreEnum.CAISSIER;
		}
		if (entite instanceof Inventaire)
			return AutreEnum.INVENTAIRE;
		else {
			throw new IllegalArgumentException("L'entité " + entite.getClass().getName() + "n'existe pas");
		}
	}

	public static Long lastId(String prefixe) {

	}
}
