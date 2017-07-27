package gst.mockproject.databaseaccess.jpa;

import gst.mockproject.databaseaccess.DAO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by dinhv on 2/11/2017.
 */
@Component
@ComponentScan(basePackages = "gst.mockproject.databaseaccesss")
public class SpringDAOFactory {
    @Autowired
    private AccountDAO AccountDAO;
    @Autowired
    private AuthorDAO AuthorDAO;
    @Autowired
    private BookImportDAO BookImportDAO;
    @Autowired
    private BookOrderDAO BookOrderDAO;
    @Autowired
    private BookDAO BookDAO;
    @Autowired
    private BorrowBookDAO BorrowBookDAO;
    @Autowired
    private CategoryDAO CategoryDAO;
    @Autowired
    private TypeOfUserDAO TypeOfUserDAO;
    @Autowired
    private HelpDAO HelpDAO;
    @Autowired
    private LibrarianDAO LibrarianDAO;
    @Autowired
    private MailBoxDAO MailBoxDAO;
    @Autowired
    private MailDAO MailDAO;
    @Autowired
    private PublisherDAO PublisherDAO;
    @Autowired
    private ReceiptDAO ReceiptDAO;
    @Autowired
    private ReturnBookNotificationDAO ReturnBookNotificationDAO;
    @Autowired
    private ReturnBookDAO ReturnBookDAO;
    @Autowired
    private RoleDAO RoleDAO;
    @Autowired
    private BookOrderDetailDAO BookOrderDetailDAO;
    @Autowired
    private ReaderDAO ReaderDAO;

    public SpringDAOFactory() {
    }

    public gst.mockproject.databaseaccess.DAO.ReaderDAO getReaderDAO() {
        return ReaderDAO;
    }

    public void setReaderDAO(gst.mockproject.databaseaccess.DAO.ReaderDAO readerDAO) {
        ReaderDAO = readerDAO;
    }

    public gst.mockproject.databaseaccess.DAO.BookOrderDetailDAO getBookOrderDetailDAO() {
        return BookOrderDetailDAO;
    }

    public void setBookOrderDetailDAO(gst.mockproject.databaseaccess.DAO.BookOrderDetailDAO bookOrderDetailDAO) {
        BookOrderDetailDAO = bookOrderDetailDAO;
    }

    public AccountDAO getAccountDAO() {
        return AccountDAO;
    }

    public void setAccountDAO(AccountDAO accountRepo) {
        AccountDAO = accountRepo;
    }

    public gst.mockproject.databaseaccess.DAO.AuthorDAO getAuthorDAO() {
        return AuthorDAO;
    }

    public void setAuthorDAO(gst.mockproject.databaseaccess.DAO.AuthorDAO authorDAO) {
        AuthorDAO = authorDAO;
    }

    public gst.mockproject.databaseaccess.DAO.BookImportDAO getBookImportDAO() {
        return BookImportDAO;
    }

    public void setBookImportDAO(gst.mockproject.databaseaccess.DAO.BookImportDAO bookImportDAO) {
        BookImportDAO = bookImportDAO;
    }

    public gst.mockproject.databaseaccess.DAO.BookOrderDAO getBookOrderDAO() {
        return BookOrderDAO;
    }

    public void setBookOrderDAO(gst.mockproject.databaseaccess.DAO.BookOrderDAO bookOrderDAO) {
        BookOrderDAO = bookOrderDAO;
    }

    public gst.mockproject.databaseaccess.DAO.BookDAO getBookDAO() {
        return BookDAO;
    }

    public void setBookDAO(gst.mockproject.databaseaccess.DAO.BookDAO bookDAO) {
        BookDAO = bookDAO;
    }

    public gst.mockproject.databaseaccess.DAO.BorrowBookDAO getBorrowBookDAO() {
        return BorrowBookDAO;
    }

    public void setBorrowBookDAO(gst.mockproject.databaseaccess.DAO.BorrowBookDAO borrowBookDAO) {
        BorrowBookDAO = borrowBookDAO;
    }

    public gst.mockproject.databaseaccess.DAO.CategoryDAO getCategoryDAO() {
        return CategoryDAO;
    }

    public void setCategoryDAO(gst.mockproject.databaseaccess.DAO.CategoryDAO categoryDAO) {
        CategoryDAO = categoryDAO;
    }

    public gst.mockproject.databaseaccess.DAO.TypeOfUserDAO getTypeOfUserDAO() {
        return TypeOfUserDAO;
    }

    public void setTypeOfUserDAO(gst.mockproject.databaseaccess.DAO.TypeOfUserDAO typeOfUserDAO) {
        TypeOfUserDAO = typeOfUserDAO;
    }

    public gst.mockproject.databaseaccess.DAO.HelpDAO getHelpDAO() {
        return HelpDAO;
    }

    public void setHelpDAO(gst.mockproject.databaseaccess.DAO.HelpDAO helpDAO) {
        HelpDAO = helpDAO;
    }

    public gst.mockproject.databaseaccess.DAO.LibrarianDAO getLibrarianDAO() {
        return LibrarianDAO;
    }

    public void setLibrarianDAO(gst.mockproject.databaseaccess.DAO.LibrarianDAO librarianDAO) {
        LibrarianDAO = librarianDAO;
    }

    public gst.mockproject.databaseaccess.DAO.MailBoxDAO getMailBoxDAO() {
        return MailBoxDAO;
    }

    public void setMailBoxDAO(gst.mockproject.databaseaccess.DAO.MailBoxDAO mailBoxDAO) {
        MailBoxDAO = mailBoxDAO;
    }

    public gst.mockproject.databaseaccess.DAO.MailDAO getMailDAO() {
        return MailDAO;
    }

    public void setMailDAO(gst.mockproject.databaseaccess.DAO.MailDAO mailDAO) {
        MailDAO = mailDAO;
    }

    public gst.mockproject.databaseaccess.DAO.PublisherDAO getPublisherDAO() {
        return PublisherDAO;
    }

    public void setPublisherDAO(gst.mockproject.databaseaccess.DAO.PublisherDAO publisherDAO) {
        PublisherDAO = publisherDAO;
    }

    public gst.mockproject.databaseaccess.DAO.ReceiptDAO getReceiptDAO() {
        return ReceiptDAO;
    }

    public void setReceiptDAO(gst.mockproject.databaseaccess.DAO.ReceiptDAO receiptDAO) {
        ReceiptDAO = receiptDAO;
    }

    public gst.mockproject.databaseaccess.DAO.ReturnBookNotificationDAO getReturnBookNotificationDAO() {
        return ReturnBookNotificationDAO;
    }

    public void setReturnBookNotificationDAO(gst.mockproject.databaseaccess.DAO.ReturnBookNotificationDAO returnBookNotificationDAO) {
        ReturnBookNotificationDAO = returnBookNotificationDAO;
    }

    public gst.mockproject.databaseaccess.DAO.ReturnBookDAO getReturnBookDAO() {
        return ReturnBookDAO;
    }

    public void setReturnBookDAO(gst.mockproject.databaseaccess.DAO.ReturnBookDAO returnBookDAO) {
        ReturnBookDAO = returnBookDAO;
    }

    public gst.mockproject.databaseaccess.DAO.RoleDAO getRoleDAO() {
        return RoleDAO;
    }

    public void setRoleDAO(gst.mockproject.databaseaccess.DAO.RoleDAO roleDAO) {
        RoleDAO = roleDAO;
    }
}
