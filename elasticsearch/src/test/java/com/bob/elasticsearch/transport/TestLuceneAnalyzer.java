package com.bob.elasticsearch.transport;

import java.util.Iterator;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Administrator
 * @create 2019-05-12 22:49
 */
public class TestLuceneAnalyzer {

    private void print(Analyzer analyzer) throws Exception {
        String text = "Lucene自带多种分词器，其中对中文分词支持比较好的是smartcn。";
        TokenStream tokenStream = analyzer.tokenStream("content", text);
        CharTermAttribute attribute = tokenStream.addAttribute(CharTermAttribute.class);
        tokenStream.reset();
        while (tokenStream.incrementToken()) {
            System.out.println(attribute.toString());
        }
    }

    /**
     * 标准分词器
     *
     * @throws Exception
     */
    @Test
    public void testStandardAnalyzer() throws Exception {
        print(new StandardAnalyzer());
    }

    /**
     * 智能中文分词器
     *
     * @throws Exception
     */
    @Test
    public void testSmartChineseAnalyzer() throws Exception {
        print(new SmartChineseAnalyzer());
    }



    /**
     * @throws Exception
     * @Description: 测试自定义停用词
     */

    @Test

    public void testMySmartChineseAnalyzer() throws Exception {

        CharArraySet charArraySet = new CharArraySet(0, true);

        // 系统默认停用词

        Iterator<Object> iterator = SmartChineseAnalyzer.getDefaultStopSet().iterator();

        while (iterator.hasNext()) {
            charArraySet.add(iterator.next());
        }
        // 自定义停用词
        String[] myStopWords = {"对", "的", "是", "其中"};
        for (String stopWord : myStopWords) {
            charArraySet.add(stopWord);
        }
        SmartChineseAnalyzer smartChineseAnalyzer = new SmartChineseAnalyzer(charArraySet);
        print(smartChineseAnalyzer);

    }

}



