package com.b2formeditor.controllers;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.authenticationmodels.LoginCredentials;
import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.models.databasemodels.Statistic;
import com.b2formeditor.models.datatransferobjects.ResponseDTO;
import com.b2formeditor.models.responsemodels.ProcessedForm;
import com.b2formeditor.models.responsemodels.ProcessedResponse;
import com.b2formeditor.services.FormService;
import com.b2formeditor.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/responses")
public class ResponseController {
    @Autowired
    private ResponseService service;
    @Autowired
    private FormService formService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProcessedResponse>> get() {
        List<ProcessedResponse> forms = this.service.getAll();
        if (forms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }


    public static boolean isIn(String[] outer, String[] inner) {

        return Arrays.asList(outer).containsAll(Arrays.asList(inner));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProcessedResponse> addResponse(HttpServletRequest request, @RequestBody ResponseDTO responseDTO) {
        ProcessedResponse savedResponse;
        ProcessedResponse newResponse = new ProcessedResponse(responseDTO);
        HttpSession session = request.getSession(true);
        LoginCredentials credentials = (LoginCredentials) session.getAttribute("credentials");
        boolean okToBeAdded = false;
        ProcessedForm form;

        if (credentials != null) {
            form = this.formService.getById(newResponse.getFormId());
            if (form != null) {
                for (Question q : form.getFields()) { //check if question is part of form
                    if (q.getId().equals(newResponse.getQuestionId())) {
                        okToBeAdded = true;
                        break;
                    }
                }
                Question question = form.getQuestionById(newResponse.getQuestionId());
                Object[] validAnswers = question.getValue();
                String[] stringValidAnswers = new String[question.getValue().length];
                for (int i = 0; i < validAnswers.length; i++)
                    stringValidAnswers[i] = validAnswers[i].toString().substring(validAnswers[i].toString().indexOf('=') + 1, validAnswers[i].toString().length() - 1);


                if (!isIn(stringValidAnswers, newResponse.getAnswers()))
                    okToBeAdded = false;
                if (okToBeAdded) {
                    newResponse.setCreatedBy(credentials.getEmail());
                    savedResponse = this.service.save(newResponse);
                    return new ResponseEntity<>(savedResponse, HttpStatus.CREATED);
                }
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Statistic> get(@PathVariable("id") String id) {
        //System.out.println(id);
        ProcessedForm form = this.formService.getById(id);
       //System.out.println(form.getId());
        Statistic statistics = new Statistic();
        //TODO create a class that extends Map<String, Map<String, Integer>>
        Map<String, Map<String, Integer>> finalResult = new HashMap<>();
        List<ProcessedResponse> processedResponses = this.service.getAll();
        statistics.setStatistics(finalResult);
        //System.out.println(form.getId());
        for (ProcessedResponse processedResponse : processedResponses) {
            //System.out.println("ID: " + processedResponse.getFormId());
            if (processedResponse.getFormId().equals(id)) {
                //System.out.println(processedResponse.getId() + " " + processedResponse.getQuestionType() + " " + processedResponse.getQuestionId());
                Object[] ans = processedResponse.getAnswers();
                for (int i = 0; i < ans.length; i++) {
                    if (form.getQuestionById(processedResponse.getQuestionId()) != null) {
                        if (finalResult.containsKey(form.getQuestionById(processedResponse.getQuestionId()).getTitle())) {
                            Map<String, Integer> aux = finalResult.get(form.getQuestionById(processedResponse.getQuestionId()).getTitle());
                            if (aux.containsKey(ans[i].toString()))
                                aux.put(ans[i].toString(), aux.get(ans[i].toString()) + 1);
                            else aux.put(ans[i].toString(), 1);
                            finalResult.put(form.getQuestionById(processedResponse.getQuestionId()).getTitle(), aux);
                        } else {
                            Map<String, Integer> aux = new HashMap<>();
                            if (aux.containsKey(ans[i].toString()))
                                aux.put(ans[i].toString(), aux.get(ans[i].toString()) + 1);
                            else aux.put(ans[i].toString(), 1);
                            finalResult.put(form.getQuestionById(processedResponse.getQuestionId()).getTitle(), aux);
                        }
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
        }
        if (statistics.getStatistics().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(statistics, HttpStatus.OK);
    }
}