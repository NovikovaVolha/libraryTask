package com.academy.libray_task.converter.request;

import com.academy.libray_task.dto.RequestToSave;
import com.academy.libray_task.model.entity.Request;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class RequestToRequestToSaveConverter implements Converter<Request, RequestToSave> {

    @Override
    public RequestToSave convert(Request request) {
        RequestToSave requestToSave = new RequestToSave();

        requestToSave.setId(request.getId());
        requestToSave.setLibrarian(request.getLibrarian().toString());
        requestToSave.setReader(request.getReader().toString());
        requestToSave.setBook(request.getBook().toString());
        requestToSave.setDateOfIssue(request.getDateOfIssue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        requestToSave.setDateOfReturn(request.getDateOfReturn().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        requestToSave.setRequestStatus(request.getRequestStatus().toString());
        requestToSave.setRequestType(request.getRequestType().toString());

        return requestToSave;
    }

}
