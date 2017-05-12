package com.all.together.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "natural_person", schema = "public")
@XmlRootElement
public class NaturalPerson extends AbstractPersistentObject {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   @Basic(optional = false)
   @NotNull
   @Column(name = "id")
   private transient Long id;

   @Size(min = 1, max = 2147483647)
   @Column(name = "status")
   private String status;

   @Column(name = "user_id")
   private Long userId;

   @Size(min = 1, max = 2147483647)
   @Column(name = "sex")
   private String sex;

   @Size(min = 1, max = 2147483647)
   @Column(name = "education")
   private String education;

   public NaturalPerson(Long id) {
      this.id = id;
      this.status = "Default";
      this.sex = "Default";
      this.education = "Default";
   }

   public NaturalPerson() {
      
   }
   
   public Long getUserId() {
      return userId;
   }

   public void setUserId(Long userId) {
      this.userId = userId;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getSex() {
      return sex;
   }

   public void setSex(String sex) {
      this.sex = sex;
   }

   public String getEducation() {
      return education;
   }

   public void setEducation(String education) {
      this.education = education;
   }

   public static long getSerialversionuid() {
      return serialVersionUID;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result
            + ((education == null) ? 0 : education.hashCode());
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((sex == null) ? 0 : sex.hashCode());
      result = prime * result + ((status == null) ? 0 : status.hashCode());
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
      NaturalPerson other = (NaturalPerson) obj;
      if (education == null) {
         if (other.education != null)
            return false;
      } else if (!education.equals(other.education))
         return false;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      if (sex == null) {
         if (other.sex != null)
            return false;
      } else if (!sex.equals(other.sex))
         return false;
      if (status == null) {
         if (other.status != null)
            return false;
      } else if (!status.equals(other.status))
         return false;
      return true;
   }

}
