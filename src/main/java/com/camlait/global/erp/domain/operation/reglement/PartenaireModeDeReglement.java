package com.camlait.global.erp.domain.operation.reglement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.partenaire.Partenaire;

@Entity
public class PartenaireModeDeReglement extends Entite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long partenaireModeleId;

	@ManyToOne
	@JoinColumn(name = "modeleId")
	private ModeleDeReglement modeleDeReglement;

	@ManyToOne
	@JoinColumn(name = "partenaireId")
	private Partenaire partenaire;

	public Long getPartenaireModeleId() {
		return partenaireModeleId;
	}

	public void setPartenaireModeleId(Long partenaireModeleId) {
		this.partenaireModeleId = partenaireModeleId;
	}

	public ModeleDeReglement getModeleDeReglement() {
		return modeleDeReglement;
	}

	public void setModeleDeReglement(ModeleDeReglement modeleDeReglement) {
		this.modeleDeReglement = modeleDeReglement;
	}

	public Partenaire getPartenaire() {
		return partenaire;
	}

	public void setPartenaire(Partenaire partenaire) {
		this.partenaire = partenaire;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partenaireModeleId == null) ? 0 : partenaireModeleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartenaireModeDeReglement other = (PartenaireModeDeReglement) obj;
		if (partenaireModeleId == null) {
			if (other.partenaireModeleId != null)
				return false;
		} else if (!partenaireModeleId.equals(other.partenaireModeleId))
			return false;
		return true;
	}

	public PartenaireModeDeReglement() {
		super();
	}
}
