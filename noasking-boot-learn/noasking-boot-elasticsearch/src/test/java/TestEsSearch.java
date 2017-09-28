import com.noasking.es.EsApplication;
import com.noasking.es.dao.ArticleSearchRepository;
import com.noasking.es.dao.NoticeUserSearchRepository;
import com.noasking.es.dao.TableUpdateSearchRepository;
import com.noasking.es.model.*;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by MaJing on 2017/9/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EsApplication.class)
public class TestEsSearch {

    @Autowired
    private ArticleSearchRepository articleSearchRepository;


    @Autowired
    private TableUpdateSearchRepository tableUpdateSearchRepository;

    @Autowired
    private NoticeUserSearchRepository noticeUserSearchRepository;

    @Test
    public void test() {
        System.out.println("演示初始化");
    }

    @Test
    public void testSave() {
        Article article = new Article();
        article.setId(1L);
        article.setTitle("elasticsearch教程");
        article.setAbstracts("spring-data-elastichSearch");
        article.setContent("SpringBoot与spring-data-elastichSearch整合");
        article.setPostTime(new Date());
        article.setClickCount(100l);
        articleSearchRepository.save(article);
    }

    @Test
    public void testSaveArticleIndex() {
        Author author = new Author();
        author.setId(1L);
        author.setName("tianshouzhi");
        author.setRemark("java developer");

        Tutorial tutorial = new Tutorial();
        tutorial.setId(1L);
        tutorial.setName("elastic search");

        Article article = new Article();
        article.setId(1L);
        article.setTitle("springboot integreate elasticsearch");
        article.setAbstracts("springboot integreate elasticsearch is very easy");
        article.setTutorial(tutorial);
        article.setAuthor(author);
        article.setContent("elasticsearch based on lucene,"
                + "spring-data-elastichsearch based on elaticsearch"
                + ",this tutorial tell you how to integrete springboot with spring-data-elasticsearch");
        article.setPostTime(new Date());
        article.setClickCount(1L);

        articleSearchRepository.save(article);


    }

    @Test
    public void testSaveNotice() {
        NoticeUserIndex noticeUserIndex = new NoticeUserIndex();
        noticeUserIndex.setId(System.currentTimeMillis());
        noticeUserIndex.setToken("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        noticeUserIndex.setLastGetDate(System.currentTimeMillis());
        noticeUserSearchRepository.save(noticeUserIndex);
    }



    @Test
    public void testQuery() {

        int pageNumber = 1;
        int pageSize = 10;

        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize, new Sort("logTime"));

        // Function Score Query
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("logEventResult", "成功")),
                        ScoreFunctionBuilders.weightFactorFunction(1000));
//                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("logDetailType", "RMI接口调用")),
//                        ScoreFunctionBuilders.weightFactorFunction(100));

        // 创建搜索 DSL 查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();

        Page<TableUpdateIndex> searchPageResults = tableUpdateSearchRepository.search(searchQuery);
        System.out.println(searchPageResults.getTotalElements());
        for (TableUpdateIndex table : searchPageResults.getContent()) {
            System.out.println(table);
        }


    }

}
