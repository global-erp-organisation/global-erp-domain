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
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class Secteur extends Localisation {

    @Transient
    private Long regionId;
    
    @JsonBackReference
	@ManyToOne
	@JoinColumn(name = "regionId")
	private Region region;

    @JsonManagedReference
	@OneToMany(mappedBy = "secteur", fetch = FetchType.EAGER)
	private Collection<Zone> zones = Lists.newArrayList();

	public Secteur() {
		setTypeLocal(AutreEnum.SECTEUR);
	}
}
