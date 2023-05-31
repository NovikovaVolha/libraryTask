package com.academy.libray_task.converter.book;

import com.academy.libray_task.model.entity.Publisher;
import com.academy.libray_task.model.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StringToPublisherConverter implements Converter<String, Publisher> {

    private final PublisherRepository publisherRepository;

    @Override
    public Publisher convert(String source) {
        String[] parts = source.split(", ");

        return publisherRepository.findPublisherByName(parts[0]);
    }

}
