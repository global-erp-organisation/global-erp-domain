package com.camlait.global.erp.domain.operation.reglement;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.Entite;
import com.camlait.global.erp.domain.enumeration.ConditionReglement;
import com.camlait.global.erp.domain.enumeration.ModeleEvaluation;
import com.camlait.global.erp.domain.partenaire.Partenaire;

@Entity
public class ModeleDeReglement extends Entite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long modeleId;

	@Enumerated(EnumType.ORDINAL)
	private ModeleEvaluation modeEvaluation;
	private double valeur;
	private int nombreDeJour;

	@Enumerated(EnumType.ORDINAL)
	private ConditionReglement conditionReglement;

	@ManyToOne
	@JoinColumn(name = "modeleDeReglementId")
	private ModeDeReglement modeDeReglement;

	@ManyToOne
	@JoinColumn(name = "partenaireId")
	private Partenaire partenaire;

	public Long getModeleId() {
		return modeleId;
	}

	public void setModeleId(Long modeleId) {
		this.modeleId = modeleId;
	}

	public ModeleEvaluation getModeEvaluation() {
		return modeEvaluation;
	}

	public void setModeEvaluation(ModeleEvaluation modeEvaluation) {
		this.modeEvaluation = modeEvaluation;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public int getNombreDeJour() {
		return nombreDeJour;
	}

	public void setNombreDeJour(int nombreDeJour) {
		this.nombreDeJour = nombreDeJour;
	}

	public ConditionReglement getConditionReglement() {
		return conditionReglement;
	}

	public void setConditionReglement(ConditionReglement conditionReglement) {
		this.conditionReglement = conditionReglement;
	}

	public ModeDeReglement getModeDeReglement() {
		return modeDeReglement;
	}

	public void setModeDeReglement(ModeDeReglement modeDeReglement) {
		this.modeDeReglement = modeDeReglement;
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
		result = prime * result + ((modeleId == null) ? 0 : modeleId.hashCode());
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
		ModeleDeReglement other = (ModeleDeReglement) obj;
		if (modeleId == null) {
			if (other.modeleId != null)
				return false;
		} else if (!modeleId.equals(other.modeleId))
			return false;
		return true;
	}

	public ModeleDeReglement() {
		super();
	}
}
