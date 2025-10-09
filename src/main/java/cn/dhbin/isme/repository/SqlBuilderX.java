package cn.dhbin.isme.repository;

import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.where.condition.IsEqualTo;
import org.mybatis.dynamic.sql.where.condition.IsLike;
import org.springframework.util.StringUtils;

public interface SqlBuilderX extends SqlBuilder {

  static IsLike<String> isLikeLRWhenNotBlank(String value) {
    return IsLike.of(value).filter(StringUtils::hasText).map(c -> "%" + c + "%");
  }

  static IsEqualTo<String> isEqualToWhenNotBlank(String value) {
    return IsEqualTo.of(value).filter(StringUtils::hasText);
  }
}
