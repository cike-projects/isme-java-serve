package cn.dhbin.isme.common.response;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class PageList<T> {

  private int currentPage;
  private int pageSize;
  private long total;
  private int totalPage;
  private List<T> pageData;

  public static <T> PageList<T> of(int currentPage, int pageSize, long totalCount, List<T> dataList) {
    return new PageList<>(currentPage, pageSize, totalCount, dataList);
  }

  public PageList(int currentPage, int pageSize, long total, List<T> pageData) {
    this.currentPage = currentPage;
    this.pageSize = pageSize;
    this.total = total;
    this.totalPage = (int) (total / pageSize + (total % pageSize > 0L ? 1 : 0));
    this.pageData = pageData;
  }

}