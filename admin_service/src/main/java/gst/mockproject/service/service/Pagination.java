package gst.mockproject.service.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinhv on 3/7/2017.
 */
@Component
@Scope("prototype")
public class Pagination {
    private String link;
    private int PageSize;
    private int TotalPage;
    private long TotalRecord;

    public Pagination() {

    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getTotalPage() {
        return TotalPage;
    }

    public void setTotalPage() {
        TotalPage = (int) (TotalRecord/PageSize);
    }

    public long getTotalRecord() {
        return TotalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        TotalRecord = totalRecord;
    }
    public List<Integer> paginate(int pagenum)
    {
        List<Integer> page = new ArrayList<Integer>();
        if(TotalPage <= 3)
        {
            for(int i = 1; i <= TotalPage ; i++)
            {
                page.add(i);
            }
        }
        else
        {
            if (pagenum == 1) {
                page.add(pagenum);
                page.add(pagenum + 1);
                page.add(pagenum + 2);
            }
            else if(pagenum < TotalPage - 1)
            {
                for(int i = pagenum - 1; i <= pagenum + 1 ; i++)
                {
                    page.add(i);
                }
            }
            else
            {
                page.add(TotalPage - 2);
                page.add(TotalPage - 1);
                page.add(TotalPage);
            }
        }
        return page;
    }
}
