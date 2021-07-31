package com.aitor.elasticsearch.graphql.productsearchapp.configuration;

import java.net.UnknownHostException;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.beans.factory.annotation.Value;

/**
 * Elasticsearch client configuration.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.aitor.elasticsearch.graphql.productsearchapp.repositories")
@ComponentScan(basePackages = { "com.aitor.elasticsearch.graphql.productsearchapp" })
public class ElasticSearchConfiguration extends AbstractElasticsearchConfiguration {

  @Value("${elasticsearch.host}")
  private String EsHost;

  @Value("${elasticsearch.port}")
  private int EsPort;

  @Override
  @Bean
  public RestHighLevelClient elasticsearchClient() {

    final ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo(EsHost + ":" + EsPort)
        .build();

    return RestClients.create(clientConfiguration).rest();
  }

  @Bean(name = { "elasticsearchOperations", "elasticsearchTemplate" })
  public ElasticsearchRestTemplate elasticsearchRestTemplate() throws UnknownHostException {
    return new ElasticsearchRestTemplate(elasticsearchClient());
  }
}