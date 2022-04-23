package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorConverter implements Converter<String[], List<Author>> {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public List<Author> convert(String[] source) {
        List<Author> result = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            result.add(authorDao.findById(Long.parseLong(source[i])));
        }
        return result;
    }



}
