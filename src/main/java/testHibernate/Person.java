package testHibernate;

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
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue
	@Column(name="person_id")
	private int id;
	
	
	private String firstName; 
	private String lastName; 
	
	
//	@OneToOne(mappedBy="person", cascade=CascadeType.ALL)
//	private License license;
}
