package com.all.together.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "company", schema="public")
@XmlRootElement
public class CompanyModel extends AbstractPersistentObject{


	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2147483647)
	@Column(name = "id")
	private transient Long id;
	

	@Size(min = 1, max = 2147483647)
	@Column(name = "employee_count")
	private Long employee;
	

	@Size(min = 1, max = 2147483647)
	@Column(name = "boss")
	private String boss;
	

	@Size(min = 1, max = 2147483647)
	@Column(name = "field")
	private String field;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmployee() {
		return employee;
	}

	public void setEmployee(Long employee) {
		this.employee = employee;
	}

	public String getBoss() {
		return boss;
	}

	public void setBoss(String boss) {
		this.boss = boss;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boss == null) ? 0 : boss.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CompanyModel other = (CompanyModel) obj;
		if (boss == null) {
			if (other.boss != null)
				return false;
		} else if (!boss.equals(other.boss))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}


