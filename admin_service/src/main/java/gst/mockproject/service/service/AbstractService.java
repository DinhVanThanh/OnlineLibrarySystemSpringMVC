package gst.mockproject.service.service;

import java.util.List;

/**
 * Created by dinhv on 3/5/2017.
 */
public interface AbstractService<T> {
    long count();
    List<T> findAll();
}
