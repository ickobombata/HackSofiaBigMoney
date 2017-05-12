package com.all.together.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "user_tot_programs", schema="public")
@XmlRootElement

public class UserToProgramModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@NotNull
	@Column(name = "user_id")
	private Long user_id;
	
	@Basic(optional = true)
	@Column(name = "schoolarship_id")
	private Long schoolarship_id;
	
	
	@Basic(optional = true)
	@Column(name = "program_id")
	private Long program_id;
	
	public Long getUserId()
	{
		return this.user_id; 
	}
	public void setUserId(Long user_id)
	{
		this.user_id = user_id;
	}
	
	public Long getProgramId()
	{
		return this.program_id;
	}
	public void setProgramId(Long program_id)
	{
		this.program_id = program_id;
	}
	
	public Long getId()
	{
		return this.id;
	}
	
	

	public Long getSchoolarship_id() {
		return schoolarship_id;
	}
	public void setSchoolarship_id(Long schoolarship_id) {
		this.schoolarship_id = schoolarship_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((program_id == null) ? 0 : program_id.hashCode());
		result = prime * result + ((schoolarship_id == null) ? 0 : schoolarship_id.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		UserToProgramModel other = (UserToProgramModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (program_id == null) {
			if (other.program_id != null)
				return false;
		} else if (!program_id.equals(other.program_id))
			return false;
		if (schoolarship_id == null) {
			if (other.schoolarship_id != null)
				return false;
		} else if (!schoolarship_id.equals(other.schoolarship_id))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	
	

}
