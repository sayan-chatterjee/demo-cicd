package com.demo.node.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"_id","employee_name", "employee_followers"})
@NodeEntity
public class Person {
	
	@JsonProperty("_id")
	@Id 
	@GeneratedValue
	private Long id;

	@JsonProperty("employee_name")
	private String name;

	private Person() {
		// Empty constructor required as of Neo4j API 2.0.5
	};

	public Person(String name) {
		this.name = name;
	}

	/**
	 * Neo4j doesn't REALLY have bi-directional relationships. It just means when querying
	 * to ignore the direction of the relationship.
	 * https://dzone.com/articles/modelling-data-neo4j
	 */
	@JsonProperty("employee_followers")
	@Relationship(type = "FOLLOWER")
	public Set<Person> follower;
	
	public void follows(Person person) {
		if (follower == null) {
			follower = new HashSet<>();
		}
		follower.add(person);
	}
	
	public String toString() {

		return this.name + "'s follower => "
			+ Optional.ofNullable(this.follower).orElse(
					Collections.emptySet()).stream()
						.map(Person::toString)
						.collect(Collectors.toList());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
