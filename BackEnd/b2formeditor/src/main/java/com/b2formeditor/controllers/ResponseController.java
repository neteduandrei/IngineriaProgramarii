package com.b2formeditor.controllers;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.databasemodels.Statistic;
import com.b2formeditor.models.responsemodels.ProcessedResponse;
import com.b2formeditor.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/responses")
public class ResponseController {
    @Autowired
    private ResponseService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProcessedResponse>> get() {
        List<ProcessedResponse> forms = this.service.getAll();
        if (forms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProcessedResponse> addResponse(@RequestBody ProcessedResponse response) {
        ProcessedResponse savedResponse = this.service.save(response);
        return new ResponseEntity<>(savedResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Statistic> get(@PathVariable("id") String id) {
        Statistic statistics = new Statistic();
        Map<String, Map<String, Integer>> finalResult = new HashMap<>();
        List<ProcessedResponse> processedResponses = this.service.getAll();
        statistics.setStatistics(finalResult);
        for (ProcessedResponse processedResponse : processedResponses) {
            //System.out.println("ID: " + processedResponse.getFormId());
            if (processedResponse.getFormId().equals(id)) {
                //System.out.println(processedResponse.getId() + " " + processedResponse.getQuestionType() + " " + processedResponse.getQuestionId());
                Object[] ans = processedResponse.getAnswers();
                for (int i = 0; i < ans.length; i++) {

                    if (finalResult.containsKey(processedResponse.getQuestionId())) {
                        Map<String, Integer> aux = finalResult.get(processedResponse.getQuestionId());
                        if (aux.containsKey(ans[i].toString()))
                            aux.put(ans[i].toString(), aux.get(ans[i].toString()) + 1);
                        else aux.put(ans[i].toString(), 1);
                        finalResult.put(processedResponse.getQuestionId(), aux);
                    }
                    else
                    {
                        Map<String, Integer> aux = new HashMap<>();
                        if (aux.containsKey(ans[i].toString()))
                            aux.put(ans[i].toString(), aux.get(ans[i].toString()) + 1);
                        else aux.put(ans[i].toString(), 1);
                        finalResult.put(processedResponse.getQuestionId(), aux);
                    }
                }
            }
        }
        statistics.setStatistics(finalResult);
        for (String key : statistics.getStatistics().keySet())
        {
            int total=0;
            for(String s : statistics.getStatistics().get(key).keySet())
                total+=statistics.getStatistics().get(key).get(s);
            Map<String, Integer> aux = statistics.getStatistics().get(key);
            for(String s : statistics.getStatistics().get(key).keySet()) {
                //System.out.println(aux.get(s));
                aux.put(s, aux.get(s)*100/total);
            }
            /*statistics.getStatistics().put(key, aux);*/
        }
        if (statistics.getStatistics().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(statistics, HttpStatus.OK);
    }
}