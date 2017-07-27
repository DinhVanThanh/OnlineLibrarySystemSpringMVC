package gst.mockproject.service.service;

import gst.mockproject.database.domain.BookOrderDetail;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinhv on 3/8/2017.
 */
@Service
public class MSExcelService {

    public List<BookOrderDetail> ReadExcelFile(MultipartFile file)   {

        List<BookOrderDetail> books = new ArrayList<BookOrderDetail>();
        try {
//            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
            XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream());
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row;
            XSSFCell cell;

            int rows; // No of rows
            rows = sheet.getPhysicalNumberOfRows();

            int cols = 0; // No of columns
            int tmp = 0;

            // This trick ensures that we get the data properly even if it doesn't start from first few rows
            for(int i = 1; i < rows; i++) {
                row = sheet.getRow(i);

                BookOrderDetail book = new BookOrderDetail();

                book.setTitle(row.getCell(1).getStringCellValue());
                book.setCategory(row.getCell(2).getStringCellValue());
                book.setPublisher(row.getCell(3).getStringCellValue());
                book.setAuthor(row.getCell(4).getStringCellValue());
                book.setQuantity((int) row.getCell(5).getNumericCellValue());

                books.add(book);
            }

        } catch(Exception ioe) {
            ioe.printStackTrace();
        }
        return books;
    }
    public void WriteExcelFile( )
    {
        try {
            String filename = "D:\\TaiLieuHK5\\GST\\Group04\\MockProject\\LIMS_PROJECT\\home_service\\src\\main\\resources\\downloadfile\\OrderBookForm.xlsx" ;
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("FirstSheet");

            XSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("Serial");
            rowhead.createCell(1).setCellValue("Book Title");
            rowhead.createCell(2).setCellValue("Category");
            rowhead.createCell(3).setCellValue("Publisher");
            rowhead.createCell(4).setCellValue("Author");
            rowhead.createCell(5).setCellValue("Quantity");


            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();


        } catch ( Exception ex ) {
            System.out.println(ex);
        }

    }
}
