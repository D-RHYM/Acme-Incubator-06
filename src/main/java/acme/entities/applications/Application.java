
package acme.entities.applications;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.entities.roles.Investor;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "status")
})
public class Application extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}[-][0-9]{2}[-][0-9]{6}$", message = "{investor.application.form.message.ticker}")
	private String				ticker;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				moment;

	@NotBlank
	private String				statement;

	@Valid
	@NotNull
	private Money				moneyOffer;

	@NotNull
	private Status				status;

	private String				justification;

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Entrepreneur		entrepreneur;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private InvestmentRound		investmentRound;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Investor			investor;

}
