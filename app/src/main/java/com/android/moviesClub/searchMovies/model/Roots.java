package com.android.moviesClub.searchMovies.model;

import java.io.Serializable;
import java.util.List;

public class Roots implements Serializable {
    public String searchType;
    public String expression;
    public List<Result> results;
    public String errorMessage;

    public String getSearchType() {
        return searchType;
    }

    public String getExpression() {
        return expression;
    }

    public List<Result> getResults() {
        return results;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
