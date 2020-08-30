
package acme.entities.bulletins;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CaceresBulletin extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				author;

	@NotNull
	private Integer				age;

	@URL
	private String				url;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;
}
