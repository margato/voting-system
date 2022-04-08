package io.github.margato.vs.voting.boundaries.persistence.mappers;

import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface TypeMapper {

    default UUID toUUID(String uuid) {
        return uuid == null ? null : UUID.fromString(uuid);
    }

    default String toString(UUID uuid) {
        return uuid == null ? null : uuid.toString();
    }

}
