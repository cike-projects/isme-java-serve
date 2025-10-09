package cn.dhbin.isme.configuration;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = {"cn.dhbin.isme.repository.sherry"},
    sqlSessionFactoryRef = "sherrySqlSessionFactory",
    sqlSessionTemplateRef = "sherrySqlSessionTemplate")
public class SherryDBConfig {
  @Bean(name = "sherryDataSource")
  @Qualifier("sherryDataSource")
  @ConfigurationProperties("spring.datasource.sherry")
  public DataSource sherryDataSource() {
    return new HikariDataSource();
  }

  @Bean(name = "sherryJdbcTemplate")
  public NamedParameterJdbcTemplate sherryJdbcTemplate(@Qualifier("sherryDataSource") DataSource dataSource) {
    return new NamedParameterJdbcTemplate(dataSource);
  }

  @Bean(name = "sherrySqlSessionFactory")
  public SqlSessionFactory sherrySqlSessionFactory(@Qualifier("sherryDataSource") DataSource dataSource) throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
    configuration.setMapUnderscoreToCamelCase(true);
    bean.setConfiguration(configuration);
    bean.setDataSource(dataSource);
    return bean.getObject();
  }

  @Bean("sherryTransactionManager")
  public DataSourceTransactionManager sherryTransactionManager(@Qualifier("sherryDataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean("sherrySqlSessionTemplate")
  public SqlSessionTemplate sherrySqlSessionTemplate(@Qualifier("sherrySqlSessionFactory") SqlSessionFactory sessionFactory) {
    return new SqlSessionTemplate(sessionFactory);
  }

}
