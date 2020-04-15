package org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<S, T> implements Converter<S, T> {

    public List<T> convert (List<S> listToConvert){
        return listToConvert.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
