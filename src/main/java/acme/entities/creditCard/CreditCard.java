
package acme.entities.creditCard;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CreditCard extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				holderName;

	@NotBlank
	@CreditCardNumber
	private String				creditCardNumber;

	@NotBlank
	private String				brand;

	@NotBlank
	@Pattern(regexp = "^[0-9]{3,4}$")
	private String				creditCardCvv;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				expirationDate;
}
