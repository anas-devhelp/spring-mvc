package com.jSolutions.entities;

import java.io.Serializable;
import java.util.Date;

public interface JSolutionEntity extends Serializable {
	
	Integer getId();
	void setId(Integer id);
	
	Integer getDomainId();
	void setDomainId(Integer domainId);

	Integer getCreatedBy();
	void setCreatedBy(Integer createdBy);
	
	
	Date getCreatedOn();
	void setCreatedOn(Date date);
	
	
	Integer getUpdatedBy();
	void setUpdatedBy(Integer updatedBy);
	
	Date getUpdatedOn();
	void setUpdatedOn(Date date);
	
}
