
package acme.entities.investmentRounds;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.entities.roles.Entrepreneur;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InvestmentRound extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}[-][0-9]{2}[-][0-9]{6}$", message = "{entrepreneur.investmentRound.form.message.ticker}")
	private String				ticker;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Past
	private Date				moment;

	@NotNull
	private kindRound			round;

	@NotBlank
	private String				title;

	@NotBlank
	private String				description;

	@Valid
	@NotNull
	private Money				amount;

	@URL
	private String				link;

	@NotNull
	private Boolean				finalMode;

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Entrepreneur		entrepreneur;

}
