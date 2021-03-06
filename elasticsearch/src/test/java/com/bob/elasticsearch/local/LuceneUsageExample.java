package com.bob.elasticsearch.local;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.elasticsearch.index.mapper.TextFieldMapper.TextFieldType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Lucene使用方法
 *
 * @author wb-jjb318191
 * @create 2019-05-08 15:23
 */
public class LuceneUsageExample {

    @Test
    public void testUseLucene() throws IOException, ParseException {
        Analyzer analyzer = new StandardAnalyzer();

        // Store the index in memory:
        Directory directory = new RAMDirectory();
        // To store an index on disk, use this instead:
        //Directory directory = FSDirectory.open("/tmp/testindex");
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter iwriter = new IndexWriter(directory, config);
        Document doc = new Document();
        String text = "This is the text to be indexed.";
        doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
        iwriter.addDocument(doc);
        iwriter.close();

        // Now search the index:
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        // Parse a simple query that searches for "text":
        QueryParser parser = new QueryParser("fieldname", analyzer);
        Query query = parser.parse("text");
        ScoreDoc[] hits = isearcher.search(query, 1, new Sort()).scoreDocs;
        assertEquals(1, hits.length);
        // Iterate through the results:
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = isearcher.doc(hits[i].doc);
            System.out.println(hitDoc.get("fieldname"));
            assertEquals("This is the text to be indexed.", hitDoc.get("fieldname"));
        }
        ireader.close();
        directory.close();
    }

    @Test
    public void testCompoundSystem() throws IOException {
        IndexWriter writer = new IndexWriter(new SimpleFSDirectory(Paths.get("E:\\lucene-compund")),new IndexWriterConfig(new StandardAnalyzer()));
        Document doc = new Document();
        doc.add(new Field("title", "java introduction", new TextFieldType()));
        doc.add(new Field("content", "python works well", new TextFieldType()));
        writer.addDocument(doc);
        //writer.optimize();
        writer.close();
    }

    @Test
    public void testUnCompoundSystem() throws IOException {
        IndexWriterConfig writerConfig = new IndexWriterConfig(new StandardAnalyzer());
        // 不适用复合的文件
        writerConfig.setUseCompoundFile(false);
        IndexWriter writer = new IndexWriter(new SimpleFSDirectory(Paths.get("E:\\lucene-uncompund")),writerConfig);
        Document doc = new Document();
        doc.add(new Field("title", "java introduction", new TextFieldType()));
        doc.add(new Field("content", "python works well", new TextFieldType()));
        writer.addDocument(doc);
        //writer.optimize();
        writer.close();
    }

}
