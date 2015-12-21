package com.camlait.global.erp.domain.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.joda.time.DateTime;

@Embeddable
public class PKBmq implements Serializable {

	private Long magasinId;

	private Long partenaireId;

	private DateTime dateBmq;

	public Long getMagasinId() {
		return magasinId;
	}

	public void setMagasinId(Long magasinId) {
		this.magasinId = magasinId;
	}

	public Long getPartenaireId() {
		return partenaireId;
	}

	public void setPartenaireId(Long partenaireId) {
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
		result = prime * result + ((magasinId == null) ? 0 : magasinId.hashCode());
		result = prime * result + ((partenaireId == null) ? 0 : partenaireId.hashCode());
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
		if (magasinId == null) {
			if (other.magasinId != null)
				return false;
		} else if (!magasinId.equals(other.magasinId))
			return false;
		if (partenaireId == null) {
			if (other.partenaireId != null)
				return false;
		} else if (!partenaireId.equals(other.partenaireId))
			return false;
		return true;
	}

}
