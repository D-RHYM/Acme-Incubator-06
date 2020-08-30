
package acme.entities.techRecords;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TechRecord extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String				title;

	@NotBlank
	private String				activitySector;

	@NotBlank
	private String				inventorName;

	@NotBlank
	private String				description;

	@URL
	@NotBlank
	private String				webSite;

	@Email
	@NotBlank
	private String				email;

	private boolean				open;

	@Range(min = -5, max = 5)
	private Integer				stars;
}
