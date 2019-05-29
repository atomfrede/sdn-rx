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
package org.springframework.data.neo4j.core.cypher;

import org.apiguardian.api.API;
import org.springframework.data.neo4j.core.cypher.support.Visitor;

/**
 * Represents a list expression in contrast to an {@link ExpressionList} which is a list of expressions. The list expression
 * here uses an expression list for it's content.
 *
 * @author Michael J. Simons
 * @soundtrack Queen - Jazz
 * @since 1.0
 */
@API(status = API.Status.INTERNAL, since = "1.0")
public final class ListExpression implements Expression {

	static ListExpression create(Expression... expressions) {

		return new ListExpression(new ExpressionList<>(expressions));
	}

	private final ExpressionList<?> content;

	private ListExpression(ExpressionList<?> content) {
		this.content = content;
	}

	@Override
	public void accept(Visitor visitor) {

		visitor.enter(this);
		this.content.accept(visitor);
		visitor.leave(this);
	}
}