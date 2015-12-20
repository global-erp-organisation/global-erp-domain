package com.camlait.global.erp.domain.pk;

import javax.persistence.Embeddable;

import org.joda.time.DateTime;

@Embeddable
public class PKBmq {

    private int magasinId;

    private int partenaireId;

    private DateTime dateBmq;

    public int getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(int magasinId) {
        this.magasinId = magasinId;
    }

    public int getPartenaireId() {
        return partenaireId;
    }

    public void setPartenaireId(int partenaireId) {
        this.partenaireId = partenaireId;
    }

    public DateTime getDateBmq() {
        return dateBmq;
    }

    public void setDateBmq(DateTime dateBmq) {
        this.dateBmq = dateBmq;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateBmq == null) ? 0 : dateBmq.hashCode());
        result = prime * result + magasinId;
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
        PKBmq other = (PKBmq) obj;
        if (dateBmq == null) {
            if (other.dateBmq != null)
                return false;
        }
        else if (!dateBmq.equals(other.dateBmq))
            return false;
        if (magasinId != other.magasinId)
            return false;
        if (partenaireId != other.partenaireId)
            return false;
        return true;
    }
}
