package com.camlait.global.erp.domain.organisation;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.camlait.global.erp.domain.enumeration.AutreEnum;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@EqualsAndHashCode(callSuper = true)
public class Region extends Localisation {

	@ManyToOne
	@JoinColumn(name = "centreId")
	private Centre centre;

	@OneToMany(mappedBy = "region", fetch = FetchType.EAGER)
	private Collection<Secteur> secteurs;

	public Region() {
		setTypeLocal(AutreEnum.REGION);
	}

}
