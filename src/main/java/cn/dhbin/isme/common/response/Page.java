package cn.dhbin.isme.common.response;

import java.util.List;
import lombok.Data;

/**
 * 包装分页数据
 */
@Data
public class Page<T> {

    private List<T> pageData;

    private Long total;
}
