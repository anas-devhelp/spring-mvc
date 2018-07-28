package com.jSolutions.entities.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.jSolutions.entities.JSolutionEntity;

@Entity
@Table(name="domains", uniqueConstraints=@UniqueConstraint(columnNames = { "name" }))

public class Domain implements JSolutionEntity{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Size(min=4, max=40)
    @Column(name = "NAME", nullable = false)
    private String name;
	
	@Size(min=4, max=40)
    @Column(name = "LABEL", nullable = false)
    private String label;
	
	@Size(min=10, max=13)
    @Column(name = "DATE_FORMAT", nullable = true)
    private String dateFormat;
	
	@Size(min=12, max=26)
    @Column(name = "DATE_TIME_FORMAT", nullable = true)
    private String dateTimeFormat;
	
	@Size(max=45)
    @Column(name = "LOCALE", nullable = true)
    private String locale;

    @Column(name = "STATUS")
    private Integer status;
	
	@Size(max=255)
    @Column(name = "LOGO_PATH", nullable = false)
    private String logoPath;
	
	@Transient
    private Integer domainId;
	
	@Column(name = "created_by", nullable = true)
    private Integer createdBy;
	
	@Column(name = "created_on", nullable = true)
    private Date createdOn;
	
	@Column(name = "updated_by", nullable = true)
    private Integer updatedBy;
	
	@Column(name = "updated_on", nullable = true)
    private Date updatedOn;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		this.domainId=id;
	}

	public Integer getDomainId() {
		return domainId;
	}

	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getDateTimeFormat() {
		return dateTimeFormat;
	}

	public void setDateTimeFormat(String dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	@Override
    public String toString() {
        return "Domain ["+
        		"id=" + this.getId() + 
        		", name=" + (this.name!=null? this.name:"") + 
        		", label="+ (this.label!=null? this.label:"") + 
        		", dateFormat=" + (this.dateFormat!=null? this.dateFormat:"") + 
                ", dateTimeFormat=" + (this.dateTimeFormat!=null? this.dateTimeFormat:"")+ 
                ", locale=" + (this.locale!=null? this.locale:"") +
                ", status=" + this.status+
                ", logoPath=" + (this.logoPath!=null? this.logoPath:"")+
            "]";
    }
	
	
}
