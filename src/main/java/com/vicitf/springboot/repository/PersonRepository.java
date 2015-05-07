package com.vicitf.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vicitf.springboot.domain.Person;

/**
 * 好神奇...
 * 
 * @author vicitf
 *
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@SuppressWarnings("unchecked")
	Person save(Person p);
	
	Person findById(Long id);
	
	List<Person> findAll();
	
	@Query("select p from Person p where p.name like %?1%")
	List<Person> findByName(String name);
	
	@Query(value = "SELECT * FROM t_person P WHERE P.EMAIL LIKE %:email%", nativeQuery = true)
	List<Person> findByEmail(@Param("email") String email);
}