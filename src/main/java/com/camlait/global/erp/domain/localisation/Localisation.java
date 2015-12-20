package com.camlait.global.erp.domain.localisation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.camlait.global.erp.domain.Entite;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Localisation extends Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int localId;

    @Column(nullable = false, unique = true)
    private String code;

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + localId;
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
        Localisation other = (Localisation) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        }
        else if (!code.equals(other.code))
            return false;
        if (localId != other.localId)
            return false;
        return true;
    }

    public Localisation() {

    }
}
