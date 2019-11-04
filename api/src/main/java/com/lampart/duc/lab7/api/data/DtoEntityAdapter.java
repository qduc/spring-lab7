package com.lampart.duc.lab7.api.data;

public interface DtoEntityAdapter <DtoT extends Dto, EntityT extends Entity> {
    EntityT toEntity(DtoT dto);
    DtoT toDto(EntityT entity);
}
