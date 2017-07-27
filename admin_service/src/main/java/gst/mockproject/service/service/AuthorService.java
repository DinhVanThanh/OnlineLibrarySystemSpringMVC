package gst.mockproject.service.service;

import gst.mockproject.database.domain.Author;
import gst.mockproject.databaseaccess.DAO.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kama on 3/6/2017.
 */

@Service
@ComponentScan(basePackages = "gst.mockproject.")
public class AuthorService {
    @Autowired
    AuthorDAO authorDAO;

    public boolean AddAuthor(Author author)
    {
       return authorDAO.save(author);
    }
  //  public List<Author> FindAuthor(String s)
 //   {
 //       authorDAO.findOne(1);
  //  }
     public void Delete(int id)
  {
      authorDAO.deleteById(id);
  }
    public Author Search(int id)
    {
        return authorDAO.findOne(id);
    }

    public List<Author> GetAll()
    {
        return (List<Author>) authorDAO.findAll();
    }

    public Author FindByID(int id)
    {
        return authorDAO.findOne(id);
    }

    public void ChangePub(Author publisher)
    {
        Author temp=authorDAO.findOne(publisher.getId());
        temp.setAuthorName(publisher.getAuthorName());
        authorDAO.save(temp);
    }
    public void DeleteO(int id)
    {
        authorDAO.deleteById(id);
    }

    public long count() {
        return authorDAO.count();
    }


    public Page<Author> findAll(Pageable pageable)
    {
        return authorDAO.findAll(pageable);
    }
}
