package com.xinyuan.assist.service.api.dic;

import java.util.List;

/**
 * 翻译
 */
public class TranModel {

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 图片
     */
    private String img;

    /**
     * 词汇等级
     */
    private String rank;

    /**
     * 发音
     */
    private List<String> pronounces;

    /**
     * 例句
     */
    private List<String> sentences;

    /**
     * 释义
     */
    private List<ParaphraseModel> paraphrases;

    /**
     * 短语
     */
    private List<PhraseModel> phrases;


    /**
     * 例句
     */
    private List<ExamSentModel> exampleSentences;




    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public List<String> getPronounces() {
        return pronounces;
    }

    public void setPronounces(List<String> pronounces) {
        this.pronounces = pronounces;
    }

    public List<String> getSentences() {
        return sentences;
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }

    public List<ParaphraseModel> getParaphrases() {
        return paraphrases;
    }

    public void setParaphrases(List<ParaphraseModel> paraphrases) {
        this.paraphrases = paraphrases;
    }

    public List<PhraseModel> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<PhraseModel> phrases) {
        this.phrases = phrases;
    }

    public List<ExamSentModel> getExampleSentences() {
        return exampleSentences;
    }

    public void setExampleSentences(List<ExamSentModel> exampleSentences) {
        this.exampleSentences = exampleSentences;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    @Override
    public String toString() {
        return "{" +
                "keyword='" + keyword + '\'' +
                ", img='" + img + '\'' +
                ", rank='" + rank + '\'' +
                ", pronounces=" + pronounces +
                ", sentences=" + sentences +
                ", paraphrases=" + paraphrases +
                ", phrases=" + phrases +
                ", exampleSentences=" + exampleSentences +
                '}';
    }
}
