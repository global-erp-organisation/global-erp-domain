package com.camlait.global.erp.domain.document.commerciaux.vente;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camlait.global.erp.domain.bmq.Bmq;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.enumeration.TypeDocuments;
import com.camlait.global.erp.domain.partenaire.ClientComptant;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`doc-facture-comptants`")
public class FactureClientComptant extends FactureClient {

    public FactureClientComptant() {
        setTypeDocument(TypeDocuments.FACTURE_COMPTANT);
    }

    public static Document createHeaderFromBmq(Bmq bmq) {
        final FactureClientComptant f = new FactureClientComptant();
        f.setBmq(bmq);
        f.setClient(new ClientComptant());
        f.setDateDocument(new Date());
        f.setMagasin(bmq.getMagasin());
        f.setResponsableDocument(bmq.getResponsable());
        f.setZone(bmq.getVendeur().getZoneDeVente());
        return f;
    }
}
