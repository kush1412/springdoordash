package com.example.test.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowJobBuilder;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.example.test.model.Student;
import com.example.test.processor.StudentItemProcessor;
import com.example.test.processor.StudentResultRowMapper;

/*
@EnableBatchProcessing
@Configuration
public class SpringBatchConfig {
	@Autowired
	private DataSource dataSource;

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public JdbcCursorItemReader<Student> reader() {
		System.out.println("RepositoryItemReader method starttedd");
		JdbcCursorItemReader<Student> reader = new JdbcCursorItemReader<>();
		reader.setDataSource(dataSource);
		reader.setSql("select id, rollnumber, name from student");
		reader.setRowMapper(new StudentResultRowMapper());
		System.out.println("RepositoryItemReader method ended");
		return reader;

	}

	@Bean
	public FlatFileItemWriter<Student> writer() {
		System.out.println("writer method starttedd");
		FlatFileItemWriter<Student> writer = new FlatFileItemWriter<>();
		writer.setResource(new FileSystemResource("C://Oms/datatest.csv"));
		DelimitedLineAggregator<Student> aggregator = new DelimitedLineAggregator<>();
		writer.setLineAggregator(getDelimitedLineAggregator());
		System.out.println("writer method ended");
		return writer;
	}

	private DelimitedLineAggregator<Student> getDelimitedLineAggregator() {
		
		BeanWrapperFieldExtractor<Student> beanWrapperFieldExtractor = new BeanWrapperFieldExtractor<Student>();
		beanWrapperFieldExtractor.setNames(new String[] { "id", "rollNumber", "name" });

		DelimitedLineAggregator<Student> aggregator = new DelimitedLineAggregator<Student>();
		aggregator.setDelimiter(",");
		aggregator.setFieldExtractor(beanWrapperFieldExtractor);
		return aggregator;

	}

	@Bean
	public StudentItemProcessor processor() {
		System.out.println("processor method starttedd");
		return new StudentItemProcessor();
	}

	@Bean
	public Step getDbToCsvStep() {
		StepBuilder stepBuilder = stepBuilderFactory.get("getDbToCsvStep");
		SimpleStepBuilder<Student, Student> simpleStepBuilder = stepBuilder.chunk(1);
		return simpleStepBuilder.reader(reader()).processor(processor()).writer(writer()).build();
	}

	@Bean
	public Job dbToCsvJob() {
		JobBuilder jobBuilder = jobBuilderFactory.get("dbToCsvJob");
		jobBuilder.incrementer(new RunIdIncrementer());
		FlowJobBuilder flowJobBuilder = jobBuilder.flow(getDbToCsvStep()).end();
		Job job = flowJobBuilder.build();
		return job;
	}

}
*/
