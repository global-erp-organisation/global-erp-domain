package com.camlait.global.erp.domain.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.joda.time.DateTime;

@Embeddable
public class PKPartenaireImmobilisation implements Serializable{

	private Long partenaireId;
	private Long immoId;
	private DateTime dateAllocation;

	public Long getPartenaireId() {
		return partenaireId;
	}

	public void setPartenaireId(Long partenaireId) {
		this.partenaireId = partenaireId;
	}

	public Long getImmoId() {
		return immoId;
	}

	public void setImmoId(Long immoId) {
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
		result = prime * result + ((immoId == null) ? 0 : immoId.hashCode());
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
		PKPartenaireImmobilisation other = (PKPartenaireImmobilisation) obj;
		if (dateAllocation == null) {
			if (other.dateAllocation != null)
				return false;
		} else if (!dateAllocation.equals(other.dateAllocation))
			return false;
		if (immoId == null) {
			if (other.immoId != null)
				return false;
		} else if (!immoId.equals(other.immoId))
			return false;
		if (partenaireId == null) {
			if (other.partenaireId != null)
				return false;
		} else if (!partenaireId.equals(other.partenaireId))
			return false;
		return true;
	}

}
