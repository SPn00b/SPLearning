package org.example.designpatterns.creational;

import java.util.ArrayList;
import java.util.List;

public class SQLSelectWithWhereClauseQueryBuilder {
    private List<String> selectClauses = new ArrayList<>();
    private List<String> fromClauses = new ArrayList<>();
    private List<String> whereClauses = new ArrayList<>();

    private SQLSelectWithWhereClauseQueryBuilder() {}

    public static SQLSelectWithWhereClauseQueryBuilder builder() {
        return new SQLSelectWithWhereClauseQueryBuilder();
    }

    public SQLSelectWithWhereClauseQueryBuilder withSelectClause(String clause) {
        this.selectClauses.add(clause);
        return this;
    }

    public SQLSelectWithWhereClauseQueryBuilder withFromClause(String clause) {
        this.fromClauses.add(clause);
        return this;
    }

    public SQLSelectWithWhereClauseQueryBuilder withWhereClause(String clause) {
        this.whereClauses.add(clause);
        return this;
    }

    public String build() {
        StringBuilder query = new StringBuilder("SELECT ");

        // Add select clauses
        query.append(String.join(", ", selectClauses));

        // Add from clauses
        query.append(" FROM ").append(String.join(", ", fromClauses));

        // Add where clauses
        if (!whereClauses.isEmpty()) {
            query.append(" WHERE ").append(String.join(" AND ", whereClauses));
        }

        return query.toString();
    }
}
