package com.syning.converter;

import com.syning.entity.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;



/**
 * 自定义的 Converter
 */
public class NingMessageConverter implements HttpMessageConverter<Person> {


    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     * 服务器要统计所有 MessageConverter 都能写出哪些内容
     * application/sy-ning
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/sy-ning");
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 自定义协议的写出
        String data = person.getName() + ";" + person.getAge() + ";" + person.getPet().getName() + ";" + person.getPet().getWeight();

        // 写出去
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes("GBK"));  // 浏览器的编码格式是GBK
    }
}
