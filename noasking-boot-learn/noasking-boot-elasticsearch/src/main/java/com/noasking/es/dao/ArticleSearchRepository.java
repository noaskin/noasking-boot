package com.noasking.es.dao;

import com.noasking.es.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by MaJing on 2017/9/25.
 */
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {
}
