package fr.form.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.form.littlePony.Pony;

@Repository
@Transactional
public interface PonyRepository extends CrudRepository<Pony, Long> {

}
