package com.noasking.es.dao;

import com.noasking.es.model.NoticeUserIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by MaJing on 2017/9/25.
 */
public interface NoticeUserSearchRepository extends ElasticsearchRepository<NoticeUserIndex, Long> {
}
