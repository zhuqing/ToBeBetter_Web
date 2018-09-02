/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.controller.segment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.dao.english.WordAndSegmentDao;
import xyz.tobebetter.entity.Message;

import xyz.tobebetter.entity.english.segment.WordAndSegment;
import xyz.tobebetter.service.english.word.WordAndSegmentServiceI;

/**
 *
 * @author zhuleqi
 */
@Controller
@RequestMapping("/english/wordandsegment")
public class WordAndSegmentController {
     @Autowired
    private WordAndSegmentServiceI<WordAndSegment, WordAndSegmentDao<WordAndSegment>> wordAndSegmentServiceI;
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody WordAndSegment propose) {
        return wordAndSegmentServiceI.create(propose);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    Message delete(@RequestParam("id") String id) {
        return this.wordAndSegmentServiceI.delete(id);
    }

    @RequestMapping(value = "/deleteByWordIdAndSegemntIdAndIndex", method = RequestMethod.DELETE)
    public @ResponseBody
    Message deleteByWordIdAndSegemntIdAndIndex(@RequestParam("wordId") String wordId,@RequestParam("segmentId") String segmentId,@RequestParam("index") int index ) {
        return this.wordAndSegmentServiceI.deleteByWordIdAndContentIdAndIndex(wordId,segmentId,index);
    }

    @RequestMapping(value = "/findBySegmentId", method = RequestMethod.GET)
    public @ResponseBody
    Message findBySegmentId(@RequestParam("segmentId") String segmentId ) {
        return this.wordAndSegmentServiceI.findBySegmentId(segmentId);
    }

    @RequestMapping(value = "/findByWordId", method = RequestMethod.GET)
    public @ResponseBody
    Message findByWordId(@RequestParam("wordId") String wordId ) {
        return this.wordAndSegmentServiceI.findByWordId(wordId);
    }

    @RequestMapping(value = "/findByWordIdAndSegemntIdAndIndex", method = RequestMethod.GET)
    public @ResponseBody
    Message findByWordIdAndSegemntIdAndIndex(@RequestParam("wordId") String wordId,@RequestParam("segmentId") String segmentId,@RequestParam("index") int index ) {
        return this.wordAndSegmentServiceI.deleteByWordIdAndContentIdAndIndex(wordId,segmentId,index);
    }
}
