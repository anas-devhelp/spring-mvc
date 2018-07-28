package com.jSolutions.entities.common;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.jSolutions.entities.JSolutionEntity;

@Entity
@Table(name="categories", uniqueConstraints= {
		@UniqueConstraint(columnNames = { "name", "domain_id" })})

public class Category implements JSolutionEntity{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Size(max=45)
    @Column(name = "name", nullable = false)
    private String name;
	
	@Size(min=1,max=255)
    @Column(name = "description", nullable = false)
    private String description;
	
	@Column(name = "status", nullable = false)
    private Integer status;
	
	@Column(name = "domain_id", nullable = false)
    private Integer domainId;
	
	@Column(name = "created_by", nullable = true)
    private Integer createdBy;
	
	@Column(name = "created_on", nullable = true)
    private Date createdOn;
	
	@Column(name = "updated_by", nullable = true)
    private Integer updatedBy;
	
	@Column(name = "updated_on", nullable = true)
    private Date updatedOn;

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="parent_id")
	private Category category;

	@OneToMany(mappedBy="category")
	private Set<Category> subCategories = new HashSet<Category>();
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<Category> subCategories) {
		this.subCategories = subCategories;
	}
	
}
