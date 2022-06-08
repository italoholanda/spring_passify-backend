package passify.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import passify.app.domain.Event;
import passify.app.request.EventPostRequestBody;
import passify.app.request.EventPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class EventMapper {
    public static final EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);
    @Autowired
    public abstract Event toEvent(EventPostRequestBody eventPostRequestBody);
    public abstract Event toEvent(EventPutRequestBody eventPutRequestBody);
}
