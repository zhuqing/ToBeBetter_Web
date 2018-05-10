/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.entity.english;

import xyz.tobebetter.entity.Entity;

/**
 *课本，包含有多个章节
 * @author zhuqing
 */
public class Catalog extends Entity{
    /**
     * 课本类型
     */
    private final static Integer BOOK_TYPE = 1;
    /**
     * 章节类型
     */
    private final static Integer CHAPTER_TYPE=2;
    /**
     * 分类类型
     */
    private final static Integer CATALOG_TYPE=3;
    /**
     * 分类的标题
     */
    private String title;
    /**
     * 图片路径
     */
    private String imagePath;
    /**
     * 书和章节
     */
    private Integer type;
    
    /**
     * 如果是章节的话 有父节点Id
     */
    private String parentId;
    
}
