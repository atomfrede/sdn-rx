/*
 * Copyright (c) 2019 "Neo4j,"
 * Neo4j Sweden AB [https://neo4j.com]
 *
 * This file is part of Neo4j.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neo4j.springframework.data.examples.rest.domain;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

/**
 * @author Gerrit Meier
 */
@Projection(name = "movie-details", types = MovieEntity.class)
public interface MovieDetails {

	String getTitle();
	String getDescription();

	// Use embedded projection
	Set<PersonDetails> getActors();
	Set<PersonDetails> getDirectors();

	interface PersonDetails {
		String getName();
	}

}
