package com.camlait.global.erp.domain.partner;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.camlait.global.erp.domain.auth.User;
import com.camlait.global.erp.domain.enumeration.Sex;
import com.camlait.global.erp.domain.enumeration.EnumTypeEntitity;
import com.camlait.global.erp.domain.enumeration.PartnerType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "`partner-employees`")
public class Employee extends Partner {

    @Column(unique = true, nullable = false)
    private String matricule;

    @Column(nullable = false)
    private String lastName;

    private String firstname;

    private Date dateOfBirth;

    @Transient
    private String userId;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @Transient
    private String professionId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "professionId")
    private Profession profession;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    public Employee() {
        setPartnerType(PartnerType.EMPLOYEE);
    }

    @Override
    public void postConstructOperation() {
        setCenterId(getCentre().getLocalId());
        setPartnerGroupId(getPartnerGroup().getPartnerGroupId());
        setTarifId(getTarif().getTarifId());
        setProfessionId(profession.getProfessionId());
        setUserId(user != null ? user.getUserId() : null);
    }

    public Boolean isSeller() {
        return this instanceof Seller;
    }

    public Boolean isStorer() {
        return this instanceof StoreOperator;
    }
    
    @Override
    public EnumTypeEntitity toEnum() {
         return PartnerType.EMPLOYEE;
    }

}
