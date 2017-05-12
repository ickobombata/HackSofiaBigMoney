package com.all.together.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "scholarships", schema="public")
@XmlRootElement
public class ScholarshipsModel implements Serializable{

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Basic(optional = false)
		@NotNull
		@Column(name = "id")
		private Long id;
    
	@Basic(optional = false)
	@NotNull
	@Column(name = "min_bal")
	private Double minBal;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2147483647)
	@Column(name = "amount")
	private Double amount;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2147483647)
	@Column(name = "type")
	private String type;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2147483647)
	@Column(name = "speciality")
	private String speciality;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2147483647)
	@Column(name = "name")
	private String name;
	
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2147483647)
	@Column(name = "start_date")
	private Date startDate;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2147483647)
	@Column(name = "endDate")
	private Date endDate;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2147483647)
	@Column(name = "ment_for")
	private String mentFor;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2147483647)
	@Column(name = "description")
	private String description;
	  
		@Basic(optional = false)
		@NotNull
		@Size(min = 1, max = 2147483647)
		@Column(name = "candidate_requirements")
		private String candidateRequirements;
	  
		@Basic(optional = false)
		@NotNull
		@Size(min = 1, max = 2147483647)
		@Column(name = "hot_to_apply")
		private String howToApply;
		
		@Basic(optional = false)
		@NotNull
		@Size(min = 1, max = 2147483647)
		@Column(name = "href")
		private String href;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Double getMinBal() {
			return minBal;
		}

		public void setMinBal(Double minBal) {
			this.minBal = minBal;
		}

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getSpeciality() {
			return speciality;
		}

		public void setSpeciality(String speciality) {
			this.speciality = speciality;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public String getMentFor() {
			return mentFor;
		}

		public void setMentFor(String mentFor) {
			this.mentFor = mentFor;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getCandidateRequirements() {
			return candidateRequirements;
		}

		public void setCandidateRequirements(String candidateRequirements) {
			this.candidateRequirements = candidateRequirements;
		}

		public String getHowToApply() {
			return howToApply;
		}

		public void setHowToApply(String howToApply) {
			this.howToApply = howToApply;
		}

		public String getHref() {
			return href;
		}

		public void setHref(String href) {
			this.href = href;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((amount == null) ? 0 : amount.hashCode());
			result = prime * result + ((candidateRequirements == null) ? 0 : candidateRequirements.hashCode());
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
			result = prime * result + ((howToApply == null) ? 0 : howToApply.hashCode());
			result = prime * result + ((href == null) ? 0 : href.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((mentFor == null) ? 0 : mentFor.hashCode());
			result = prime * result + ((minBal == null) ? 0 : minBal.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((speciality == null) ? 0 : speciality.hashCode());
			result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
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
			ScholarshipsModel other = (ScholarshipsModel) obj;
			if (amount == null) {
				if (other.amount != null)
					return false;
			} else if (!amount.equals(other.amount))
				return false;
			if (candidateRequirements == null) {
				if (other.candidateRequirements != null)
					return false;
			} else if (!candidateRequirements.equals(other.candidateRequirements))
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (endDate == null) {
				if (other.endDate != null)
					return false;
			} else if (!endDate.equals(other.endDate))
				return false;
			if (howToApply == null) {
				if (other.howToApply != null)
					return false;
			} else if (!howToApply.equals(other.howToApply))
				return false;
			if (href == null) {
				if (other.href != null)
					return false;
			} else if (!href.equals(other.href))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (mentFor == null) {
				if (other.mentFor != null)
					return false;
			} else if (!mentFor.equals(other.mentFor))
				return false;
			if (minBal == null) {
				if (other.minBal != null)
					return false;
			} else if (!minBal.equals(other.minBal))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (speciality == null) {
				if (other.speciality != null)
					return false;
			} else if (!speciality.equals(other.speciality))
				return false;
			if (startDate == null) {
				if (other.startDate != null)
					return false;
			} else if (!startDate.equals(other.startDate))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}
		
		

}
