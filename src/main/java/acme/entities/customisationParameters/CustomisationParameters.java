
package acme.entities.customisationParameters;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomisationParameters extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Pattern(regexp = "^$|(^[^,]+([,][^,]+)*$)")
	private String				spamWords;

	@Range(min = 0, max = 100)
	private float				spamThreshold;

	@NotBlank
	@Pattern(regexp = "^$|(^[^,]+([,][^,]+)*$)")
	private String				activitySectors;


	public boolean isSpam(final String text) {
		String lowerCaseText = text.toLowerCase();

		int spamCount = 0;
		for (String spamWord : this.spamWords.toLowerCase().split(",")) {
			spamCount += StringUtils.countMatches(lowerCaseText, spamWord) * spamWord.length();
		}

		return (float) spamCount / text.length() * 100 > this.spamThreshold;
	}
}
