package com.camlait.global.erp.domain.pk;

import javax.persistence.Embeddable;

import org.joda.time.DateTime;

@Embeddable
public class PKClientImmobilisation {

    private int partenaireId;
    private int immoId;
    private DateTime dateAllocation;
    public int getPartenaireId() {
        return partenaireId;
    }
    public void setPartenaireId(int partenaireId) {
        this.partenaireId = partenaireId;
    }
    public int getImmoId() {
        return immoId;
    }
    public void setImmoId(int immoId) {
        this.immoId = immoId;
    }
    public DateTime getDateAllocation() {
        return dateAllocation;
    }
    public void setDateAllocation(DateTime dateAllocation) {
        this.dateAllocation = dateAllocation;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateAllocation == null) ? 0 : dateAllocation.hashCode());
        result = prime * result + immoId;
        result = prime * result + partenaireId;
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
        PKClientImmobilisation other = (PKClientImmobilisation) obj;
        if (dateAllocation == null) {
            if (other.dateAllocation != null)
                return false;
        }
        else if (!dateAllocation.equals(other.dateAllocation))
            return false;
        if (immoId != other.immoId)
            return false;
        if (partenaireId != other.partenaireId)
            return false;
        return true;
    }    
}
