package org.catalogador.mappers;

import org.catalogador.domains.models.Search;
import org.catalogador.domains.models.Title;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface TitleMapper {

    TitleMapper map = Mappers.getMapper(TitleMapper.class);

    Title searchToTitle (Search search);

    List<Title> searchesToTitles(List<Search> entity);

}
