package com.ecom.airy.batch.config;


import com.ecom.airy.batch.listener.JobCompletionNotificationListener;
import com.ecom.airy.batch.model.Product;
import com.ecom.airy.batch.processor.ProductItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration {

    /*private String uniqId;
    private String "productName","timestamp",productUrl,productCategoryTree,productId,retailPrice,discountedPrice,rating,overallRating,brand,productSpecifications;
    */

    @Bean
    FlatFileItemReader<Product> reader(){
        return new FlatFileItemReaderBuilder<Product>()
                .name("productItemReader")
                .resource(new ClassPathResource("sample-data.csv"))
                .delimited()
                .names(new String[]{"uniqId","timestamp","productUrl","productName","productCategoryTree","productId","retailPrice","discountedPrice","image","isFKAdvantageProduct","description","productRating","overallRating","brand","productSpecifications"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Product.class);
                }})
                .build();
    }

    @Bean
    public ProductItemProcessor processor() {
        return new ProductItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Product> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Product>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO `product_details_table` (uniq_id,crawl_timestamp,product_url,product_name,product_category_tree,pid,retail_price,discounted_price,image,is_FK_Advantage_product,description,product_rating,overall_rating,brand,product_specification) VALUES (:uniqId,:timestamp,:productUrl,:productName,:productCategoryTree,:productId,:retailPrice,:discountedPrice,:image,:isFKAdvantageProduct,:description,:productRating,:overallRating,:brand,:productSpecifications)")
                .dataSource(dataSource)
                .build();
    }


    @Bean
    public Job importUserJob(JobRepository jobRepository,
                             JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Product> writer) {
        return new StepBuilder("step1", jobRepository)
                .<Product, Product> chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}
