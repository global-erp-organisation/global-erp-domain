package com.camlait.global.erp.domain.util;

import java.util.UUID;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.dm.DailyMovement;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.document.business.sale.CashClientBill;
import com.camlait.global.erp.domain.document.business.sale.ClientBill;
import com.camlait.global.erp.domain.document.business.sale.MargingBill;
import com.camlait.global.erp.domain.document.business.sale.SaleDocument;
import com.camlait.global.erp.domain.document.stock.in.InItem;
import com.camlait.global.erp.domain.document.stock.in.InDocument;
import com.camlait.global.erp.domain.document.stock.in.ReturnItem;
import com.camlait.global.erp.domain.document.stock.out.Animation;
import com.camlait.global.erp.domain.document.stock.out.Avarie;
import com.camlait.global.erp.domain.document.stock.out.BonDeSortie;
import com.camlait.global.erp.domain.document.stock.out.Don;
import com.camlait.global.erp.domain.document.stock.out.Echantillon;
import com.camlait.global.erp.domain.document.stock.out.OutDocument;
import com.camlait.global.erp.domain.enumeration.AutreEnum;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntite;
import com.camlait.global.erp.domain.enumeration.DocumentType;
import com.camlait.global.erp.domain.enumeration.PartnerType;
import com.camlait.global.erp.domain.inventory.Inventory;
import com.camlait.global.erp.domain.localisation.Centre;
import com.camlait.global.erp.domain.localisation.Localisation;
import com.camlait.global.erp.domain.localisation.Region;
import com.camlait.global.erp.domain.localisation.Secteur;
import com.camlait.global.erp.domain.partner.CashClient;
import com.camlait.global.erp.domain.partner.Cashier;
import com.camlait.global.erp.domain.partner.Client;
import com.camlait.global.erp.domain.partner.Employee;
import com.camlait.global.erp.domain.partner.MarginClient;
import com.camlait.global.erp.domain.partner.Partner;
import com.camlait.global.erp.domain.partner.Seller;
import com.camlait.global.erp.domain.partner.StoreOperator;
import com.camlait.global.erp.domain.warehouse.MobileStore;
import com.camlait.global.erp.domain.warehouse.Store;
import com.camlait.global.erp.domain.warehouse.Warehouse;

public final class Utility {

    public static String getUidFor(String currentKey) {
        return currentKey == null ? UUID.randomUUID().toString() : currentKey;
    }

    public static EnumTypeEntite obtenirPrefixe(Entite entite) throws IllegalArgumentException {
        if (entite instanceof DailyMovement)
            return AutreEnum.BMQ;
        else if (entite instanceof Document)
            return obtenirPrefixeDocument(entite);
        else if (entite instanceof Partner)
            return obtenirPrefixePartenaire(entite);
        else if (entite instanceof Localisation)
            return obtenirPrefixeLocalisation(entite);
        else if (entite instanceof Inventory)
            return AutreEnum.INVENTAIRE;
        else if (entite instanceof Store) {
            if (entite instanceof MobileStore) {
                return AutreEnum.MAGASIN_MOBILE;
            } else
                return AutreEnum.MAGASIN_FIXE;
        } else if (entite instanceof Warehouse) {
            return AutreEnum.ENTREPOT;
        } else
            throw new IllegalArgumentException("L'entité " + entite.getClass().getName() + " n'existe pas");
    }

    public static Long convertToLong(String num) {
        try {
            return Long.parseLong(num);
        } catch (Exception e) {
            throw e;
        }
    }

    private static EnumTypeEntite obtenirPrefixeDocument(Entite entite) {
        if (entite instanceof Document) {
            if (entite instanceof SaleDocument) {
                if (entite instanceof ClientBill) {
                    if (entite instanceof CashClientBill)
                        return DocumentType.FACTURE_COMPTANT;
                    else if (entite instanceof MargingBill)
                        return DocumentType.FACTURE_MARGE;
                    else
                        return DocumentType.FACTURE_CLIENT;
                } else
                    return DocumentType.DOCUMENT_DE_VENTE;
            } else if (entite instanceof OutDocument) {
                if (entite instanceof BonDeSortie)
                    return DocumentType.BON_DE_SORTIE;
                if (entite instanceof Echantillon)
                    return DocumentType.ECHANTILLON;
                if (entite instanceof Don)
                    return DocumentType.DON;
                if (entite instanceof Avarie)
                    return DocumentType.AVARIE;
                if (entite instanceof Animation)
                    return DocumentType.ANIMATION;
                else
                    return DocumentType.DOCUMENT_SORTIE;
            } else if (entite instanceof InDocument) {
                if (entite instanceof InItem)
                    return DocumentType.BON_ENTREE;
                else if (entite instanceof ReturnItem)
                    return DocumentType.BON_DE_RETOUR;
                else
                    return DocumentType.DOCUMENT_ENTREE;
            }
        }
        throw new IllegalArgumentException("L'entité " + entite.getClass().getName() + " n'existe pas");
    }

    private static EnumTypeEntite obtenirPrefixePartenaire(Entite entite) {
        if (entite instanceof Partner) {
            if (entite instanceof Employee) {
                if (entite instanceof StoreOperator)
                    return PartnerType.MAGASINIER;
                else if (entite instanceof Seller)
                    return PartnerType.VENDEUR;
                else if (entite instanceof Cashier)
                    return PartnerType.CAISSIER;
                else
                    return PartnerType.EMPLOYE;
            } else if (entite instanceof Client) {
                if (entite instanceof MarginClient)
                    return PartnerType.CLIENT_A_MARGE;
                else if (entite instanceof CashClient)
                    return PartnerType.CLIENT_COMPTANT;
                else
                    return PartnerType.CLIENT;
            }
        }
        throw new IllegalArgumentException("L'entité " + entite.getClass().getName() + " n'existe pas");
    }

    private static EnumTypeEntite obtenirPrefixeLocalisation(Entite entite) {
        if (entite instanceof Localisation) {
            if (entite instanceof Centre) {
                return AutreEnum.CENTRE;
            } else if (entite instanceof Region) {
                return AutreEnum.REGION;
            } else if (entite instanceof Secteur) {
                return AutreEnum.SECTEUR;
            } else
                return AutreEnum.ZONE;
        }
        throw new IllegalArgumentException("L'entité " + entite.getClass().getName() + " n'existe pas");
    }
}
