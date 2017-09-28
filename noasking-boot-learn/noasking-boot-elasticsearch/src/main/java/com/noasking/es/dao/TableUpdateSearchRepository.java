package com.noasking.es.dao;

import com.noasking.es.model.TableUpdateIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by MaJing on 2017/9/25.
 */
public interface TableUpdateSearchRepository extends ElasticsearchRepository<TableUpdateIndex, Long> {
}
