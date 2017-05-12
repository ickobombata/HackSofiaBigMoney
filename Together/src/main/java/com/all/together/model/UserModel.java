package com.all.together.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "user", schema="public")
@XmlRootElement
public class UserModel implements Serializable{

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
		@NotNull
		@Column(name = "id")
		private Long id;
	  
		@Basic(optional = false)
		@NotNull
		@Size(min = 1, max = 2147483647)
		@Column(name = "password")
		private String password;


		@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email") // if
		@Size(min = 1, max = 2147483647)
		@Column(name = "email")
		private String email;
	 
		@Basic(optional = false)
		@NotNull
		@Size(min = 1, max = 2147483647)
		@Column(name = "name")
		private String name;
		
		
		@Column(name = "birthday")
		private Date birthday;
		

		@Size(min = 1, max = 2147483647)
		@Column(name = "adress")
		private String addres;

		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "company_id", referencedColumnName="id")
		private transient CompanyModel company;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "person_id", referencedColumnName="id")
		private transient NaturalPerson person;

		
		
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		public  CompanyModel getCompany(){
			return company;
		}
		
		public NaturalPerson getPerson(){
			return this.person;
		}
		
		public void setCompany(CompanyModel company) {
         this.company = company;
      }
		
		public void setPerson(NaturalPerson person) {
         this.person = person;
      }
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

		public String getAddres() {
			return addres;
		}

		public void setAddres(String addres) {
			this.addres = addres;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((addres == null) ? 0 : addres.hashCode());
			result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
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
			UserModel other = (UserModel) obj;
			if (addres == null) {
				if (other.addres != null)
					return false;
			} else if (!addres.equals(other.addres))
				return false;
			if (birthday == null) {
				if (other.birthday != null)
					return false;
			} else if (!birthday.equals(other.birthday))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		
		
}
