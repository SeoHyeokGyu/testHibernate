package testHibernate;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="license")
public class License {
	
	@Id
	@GeneratedValue
	@Column(name="license_id")
	private int id;
	
	private String licenseNumber; 
	private Date issueDate;
	
	@OneToOne(optional=false, cascade=CascadeType.ALL)  
	@JoinColumn(unique=true, name="person_id")  
	private Person person;


}
