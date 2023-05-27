package com.example.test.config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;

import com.example.test.model.Sku;
import com.example.test.processor.SkuItemProcessor;
import com.example.test.respository.SkuRepository;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
@Autowired
private JobBuilderFactory jobBuilderFactory;
		
 @Autowired
 private StepBuilderFactory stepBuilderFactory;
 


@Bean
//@StepScope
public RepositoryItemReader<Sku> reader(SkuRepository skuRepo){
	System.out.println("RepositoryItemReader method starttedd");
	RepositoryItemReader<Sku> reader = new RepositoryItemReader<>();
	reader.setRepository(skuRepo);
	reader.setMethodName("findByAll");
	reader.setPageSize(100);
	Map<String, Direction> sorts = new HashMap<>();
	sorts.put("sku_id", Direction.ASC);
	reader.setSort(sorts);
	return reader;
}

@Bean
//@StepScope
public SkuItemProcessor processor(){
	System.out.println("SkuItemProcessor method starttedd");
	return new SkuItemProcessor();
}

@Bean
//@StepScope
public FlatFileItemWriter<Sku> writer(){
	System.out.println("writer method starttedd");
	FlatFileItemWriter<Sku> writer = new FlatFileItemWriter<Sku>();
	writer.setResource(new FileSystemResource("C://Oms/data.csv"));
	
	DelimitedLineAggregator<Sku> lineAggregator = new DelimitedLineAggregator<Sku>();
	lineAggregator.setDelimiter(",");
	
	BeanWrapperFieldExtractor<Sku>  fieldExtractor = new BeanWrapperFieldExtractor<Sku>();
	
	fieldExtractor.setNames(new String[]{"skuId","skuUpc"});
	lineAggregator.setFieldExtractor(fieldExtractor);
	
	writer.setLineAggregator(lineAggregator);
	System.out.println("writer method endd");
	return writer;
}

@Bean
public Step step1(ItemReader<Sku> itemReader) {
 return stepBuilderFactory.get("step1").<Sku, Sku> chunk(10)
   .reader(itemReader)
   .processor(processor())
   .writer(writer())
   .build();
}

@Bean
public Job exportUserJob12(Step step) {
 return jobBuilderFactory.get("exportUserJob12")
   .incrementer(new RunIdIncrementer())
   .flow(step)
   .end()
   .build();
}

}
