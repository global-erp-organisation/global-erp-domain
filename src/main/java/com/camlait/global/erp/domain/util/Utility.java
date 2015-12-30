package com.camlait.global.erp.domain.util;

import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.document.commerciaux.vente.DocumentDeVente;
import com.camlait.global.erp.domain.document.commerciaux.vente.FactureClient;
import com.camlait.global.erp.domain.document.commerciaux.vente.FactureClientComptant;
import com.camlait.global.erp.domain.document.commerciaux.vente.FactureMarge;

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
}
