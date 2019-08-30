package dms.pastor.spring.tools.vocabulizator.search;

import dms.pastor.spring.tools.vocabulizator.model.Definition;

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
