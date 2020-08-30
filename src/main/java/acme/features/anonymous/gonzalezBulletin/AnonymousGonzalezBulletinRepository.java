/*
 * AnonymousShoutRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.anonymous.gonzalezBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.GonzalezBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousGonzalezBulletinRepository extends AbstractRepository {

	@Query("select s from GonzalezBulletin s")
	Collection<GonzalezBulletin> findMany();
}
