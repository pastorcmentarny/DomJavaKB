package dms.pastor.tools.gibberishcheck;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@lombok.Data
public class Data {
    private final List<String> crapWords;
    private final List<String> job;
}