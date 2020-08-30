
package acme.entities.discussionForum;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.entities.Authenticated;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DiscussionForum extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@OneToOne
	private InvestmentRound		investmentRound;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Authenticated		creator;
}
