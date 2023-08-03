package com.luisz.lj.utils.converter;

public interface Converter <I, O> {
    O convert(I input);
}