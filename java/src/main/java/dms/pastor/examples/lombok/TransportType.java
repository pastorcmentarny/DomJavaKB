package dms.pastor.examples.lombok;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //used for constructors for fields with the final modifier.
public class TransportType {
    private String name;
    private final String description = "None";
}
