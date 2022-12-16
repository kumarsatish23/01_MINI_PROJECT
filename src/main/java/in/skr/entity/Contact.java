package in.skr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CONTACT_DTLS")
public class Contact {
	@Id
	@GeneratedValue
	Integer contactId;
	String contactName;
	String contactEmail;
	Long contactNum;
}
