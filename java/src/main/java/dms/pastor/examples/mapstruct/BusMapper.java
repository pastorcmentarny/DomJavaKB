package dms.pastor.examples.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BusMapper {
    BusMapper INSTANCE = Mappers.getMapper(BusMapper.class);

    @Mapping(source = "year", target = "produced")
    BusDto busToDto(Bus bus);
}
