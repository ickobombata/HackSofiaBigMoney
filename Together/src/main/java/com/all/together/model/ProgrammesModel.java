package com.all.together.model;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "programs", schema = "public")
@XmlRootElement
public class ProgrammesModel extends AbstractPersistentObject {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2147483647)
   @Column(name = "id")
   private Long id;

   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2147483647)
   @Column(name = "name")
   private String name;

   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2147483647)
   @Column(name = "start_date")
   private Date start_date;

   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2147483647)
   @Column(name = "end_date")
   private Date end_date;

   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2147483647)
   @Column(name = "type")
   private String type;

   @Basic(optional = false)
   @NotNull
   @Column(name = "description")
   private String description;

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Date getStart_date() {
      return start_date;
   }

   public void setStart_date(Date start_date) {
      this.start_date = start_date;
   }

   public Date getEnd_date() {
      return end_date;
   }

   public void setEnd_date(Date end_date) {
      this.end_date = end_date;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public static long getSerialversionuid() {
      return serialVersionUID;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result
            + ((description == null) ? 0 : description.hashCode());
      result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result
            + ((start_date == null) ? 0 : start_date.hashCode());
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
      ProgrammesModel other = (ProgrammesModel) obj;
      if (description == null) {
         if (other.description != null)
            return false;
      } else if (!description.equals(other.description))
         return false;
      if (end_date == null) {
         if (other.end_date != null)
            return false;
      } else if (!end_date.equals(other.end_date))
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
      if (start_date == null) {
         if (other.start_date != null)
            return false;
      } else if (!start_date.equals(other.start_date))
         return false;
      if (type == null) {
         if (other.type != null)
            return false;
      } else if (!type.equals(other.type))
         return false;
      return true;
   }




}
