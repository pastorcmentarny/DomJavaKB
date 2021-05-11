package dms.pastor.spring.examples.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dms.pastor.spring.model.Train;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController("/trains")
public class CrudTrainController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DummyTrainRepository dummyTrainRepository;

    @PostMapping("/add")
    public void addTrain(String trainAsString) throws JsonProcessingException {
        final Train train = objectMapper.readValue(trainAsString, Train.class);
        dummyTrainRepository.save(train);
    }

    @PutMapping("/update")
    public void addTrain(UUID uuid, String trainAsString) throws JsonProcessingException {
        final Train train = objectMapper.readValue(trainAsString, Train.class);
        dummyTrainRepository.load(train.getBritishClass());
        dummyTrainRepository.save(train);
    }

    @DeleteMapping("/delete/{britishClass}")
    public void deleteTrain(@PathVariable String britishClass) {
        dummyTrainRepository.delete(britishClass);
    }

    @GetMapping("/get/{britishClass}")
    public Train getTrain(@PathVariable String britishClass) {
        return dummyTrainRepository.load(britishClass);
    }
}
