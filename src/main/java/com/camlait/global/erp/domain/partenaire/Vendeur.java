package com.camlait.global.erp.domain.partenaire;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.enumeration.TypePartenaire;
import com.camlait.global.erp.domain.operation.manquant.ManquantFinancier;
import com.camlait.global.erp.domain.organisation.Zone;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class Vendeur extends Employe {

    @Transient
    private String zoneId;
    
    @JsonBackReference
	@ManyToOne
	@JoinColumn(name = "zoneId")
	private Zone zoneDeVente;

	@JsonManagedReference
	@OneToMany(mappedBy = "vendeur")
	private Collection<ManquantFinancier> manquantFinanciers = Sets.newHashSet();

	private boolean recoisDesCommission;

	private double tauxDeCommission;

	public Vendeur() {
		setTypePartenaire(TypePartenaire.VENDEUR);
	}
	
	@Override
	public void postConstructOperation() {
		setCentreId(getCentre().getLocalId());
		setGroupePartenaireId(getGroupePartenaire().getGroupePartenaireId());
		setTarifId(getTarif().getTarifId());
		setEmploisId(getEmplois().getEmploisId());
		setUtilisateurId(getUtilisateur() != null ? getUtilisateur().getUtilisateurId() : null);
		setZoneId(zoneDeVente.getLocalId());
	}
}
