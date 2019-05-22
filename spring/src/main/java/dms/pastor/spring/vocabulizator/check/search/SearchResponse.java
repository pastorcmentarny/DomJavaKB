package dms.pastor.spring.vocabulizator.check.search;

import dms.pastor.spring.vocabulizator.check.model.Definition;

import java.util.List;

public class SearchResponse {

    private final List<Definition> result;

    public SearchResponse(List<Definition> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
            "result=" + result +
            '}';
    }
}
