package gst.mockproject.databaseaccess;


import gst.mockproject.database.domain.BookOrderDetail;
import gst.mockproject.database.domain.Category;
import gst.mockproject.database.domain.ReaderType;
import gst.mockproject.databaseaccess.Configuration.DataAccessConfig;
import gst.mockproject.databaseaccess.DAO.*;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by dinhv on 3/25/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataAccessConfig.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ComponentScan(basePackages = "gst.mockproject.databaseaccess")
public class SpringDAOFactoryTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    SpringDAOFactory springDAOFactory;

    @Test(timeout = 1000)
    public void testAccountDAO()
    {
        AccountDAO accountDAO = springDAOFactory.getAccountDAO();
        assertEquals(accountDAO.count(), 4);
    }
    @Test
    public void testAuthorDAO()
    {
        AuthorDAO authorDAO = springDAOFactory.getAuthorDAO();
        assertNotNull(authorDAO);
    }
    @Test
    public void testBookDAO()
    {
        BookDAO bookDAO = springDAOFactory.getBookDAO();
        assertNull(bookDAO.findOne(100));
    }
    @Test
    public void testBookImportDAO()
    {
        BookImportDAO bookImportDAO = springDAOFactory.getBookImportDAO();
         assertSame(bookImportDAO.findOne(1), bookImportDAO.findOne(1));
    }
    @Test
    public void testBookOrderDAO()
    {
        BookOrderDAO bookOrderDAO = springDAOFactory.getBookOrderDAO();
        assertNotSame(bookOrderDAO.findOne(1), bookOrderDAO.findOne(1));
    }
    @Test
    public void testBookOrderDetailDAO()
    {
        BookOrderDetailDAO bookOrderDetailDAO = springDAOFactory.getBookOrderDetailDAO();
        Assume.assumeNotNull(bookOrderDetailDAO.findAll());
    }
    @Test
    public void testBorrowBookDAO()
    {
        BorrowBookDAO borrowBookDAO = springDAOFactory.getBorrowBookDAO();
        Assume.assumeTrue(borrowBookDAO.findOne(2).isStatus());
    }

    @Test(expected = NullPointerException.class)
    public void testCategoryDAO()
    {
        CategoryDAO categoryDAO = springDAOFactory.getCategoryDAO();
        Category category = categoryDAO.findOne(-1);
    }
    @Test
    public void testLibrarianDAO()
    {
        LibrarianDAO librarianDAO = springDAOFactory.getLibrarianDAO();
        assertThat(librarianDAO.findOne(1).getName(), either(containsString("Thành")).or(containsString("Duy")));
    }
    @Test
    public void testPublisherDAO()
    {
        PublisherDAO publisherDAO = springDAOFactory.getPublisherDAO();
        assertThat(publisherDAO.findAll(), hasItem(publisherDAO.findOne(2)));
    }
    @Test(expected = NullPointerException.class)
    public void testReaderDAO()
    {
        ReaderDAO readerDAO = springDAOFactory.getReaderDAO();
        readerDAO.deleteById(100);
    }
    @Test
    public void testReceiptDAO()
    {
        ReceiptDAO receiptDAO = springDAOFactory.getReceiptDAO();
        assertThat(receiptDAO.findOne(1).getLibrarian().getEmail(),
                both(containsString("dinhvanthanh1995@gmail.com"))
                        .and(containsString("phcu@gmail.com")));
    }
    @Test
    public void testReturnBookDAO()
    {
        ReturnBookDAO returnBookDAO = springDAOFactory.getReturnBookDAO();
    }
    @Test
    public void testRoleDAO()
    {
        RoleDAO roleDAO = springDAOFactory.getRoleDAO();
        assertThat(roleDAO.findOne(1).getRoleName(), either(containsString("ROLE_ADMIN")).or(containsString("ROLE_USER")));
    }
    @Test
    public void testTypeOfUserDAO()
    {
        TypeOfUserDAO typeOfUserDAO = springDAOFactory.getTypeOfUserDAO();
        assertTrue(typeOfUserDAO.save(new ReaderType("văn bằng 2", (short) 4, (short)5)));
    }

}
