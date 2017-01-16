package com.camlait.global.erp.domain.organisation;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.enumeration.AutreEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class Region extends Localisation {

    @Transient
    private Long centreId;
    
    @JsonBackReference
	@ManyToOne
	@JoinColumn(name = "centreId")
	private Centre centre;

    @JsonManagedReference
	@OneToMany(mappedBy = "region", fetch = FetchType.EAGER)
	private Collection<Secteur> secteurs = Sets.newHashSet();

	public Region() {
		setTypeLocal(AutreEnum.REGION);
	}

}
