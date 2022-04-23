package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorConverterString implements Converter<String, List<Author>> {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public List<Author> convert(String s) {
        List<Author> result = new ArrayList<>();
        result.add(authorDao.findById(Long.parseLong(s)));
        return result;
    }
}
