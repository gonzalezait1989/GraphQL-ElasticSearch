package com.aitor.elasticsearch.graphql.productsearchapp.exceptions;

import java.util.List;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class InvalidProductDataException extends RuntimeException implements GraphQLError {

    public InvalidProductDataException(String message) {
        super(message);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }

}
