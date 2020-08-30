
package acme.entities.banner;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import acme.entities.creditCard.CreditCard;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Banner extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@URL
	private String				picture;

	@NotBlank
	private String				slogan;

	@NotBlank
	@URL
	private String				targetURL;

	// Relationships
	@Valid
	@OneToOne(optional = true)
	private CreditCard			creditCard;

}
