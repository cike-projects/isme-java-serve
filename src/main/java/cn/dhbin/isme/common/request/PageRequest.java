package cn.dhbin.isme.common.request;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.Data;

/**
 * 分页请求
 */
@Data
public class PageRequest {

    /**
     * 页数
     */
    private Integer pageNo = 1;

    /**
     * 页大小
     */
    private Integer pageSize = 10;


    /**
     * 转换成mp的page
     *
     * @param <T> 类型
     * @return Page
     */
    public <T> Page<T> toPage() {
        return PageHelper.startPage(pageNo, pageSize);
    }
}
