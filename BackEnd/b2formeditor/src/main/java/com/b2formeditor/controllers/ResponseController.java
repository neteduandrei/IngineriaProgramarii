package com.b2formeditor.controllers;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.authenticationmodels.LoginCredentials;
import com.b2formeditor.models.databasemodels.Response;
import com.b2formeditor.models.responsemodels.ProcessedForm;
import com.b2formeditor.models.responsemodels.ProcessedLoginCredentials;
import com.b2formeditor.services.FormService;
import com.b2formeditor.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/responses")
public class ResponseController {
    @Autowired
    private ResponseService service;
    @Autowired
    private FormService formService;

    public static boolean isIn(String[] outer, String[] inner) {
        return Arrays.asList(outer).containsAll(Arrays.asList(inner));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getUserResponses(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        ProcessedLoginCredentials credentials = (ProcessedLoginCredentials) session.getAttribute("credentials");
        List<Response> responses;
        String userRole, userEmail;

        if (credentials != null) {
            userRole = credentials.getRole();
            if (userRole.equals("user")) {
                userEmail = credentials.getEmail();
                responses = this.service.findByCreatedBy(userEmail);
            } else {
                responses = this.service.getAll();
            }
            if (responses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(responses, HttpStatus.OK);
        }
        return new ResponseEntity<>("You must be logged in", HttpStatus.FORBIDDEN);
    }

//    @RequestMapping(value = "add", method = RequestMethod.POST)
//    public ResponseEntity addResponse(HttpServletRequest request, HttpServletResponse response, @Valid @RequestBody ResponseDTO responseDTO) {
//        Response savedResponse;
//        Response newResponse = new Response(responseDTO);
//        HttpSession session = request.getSession(true);
//        LoginCredentials credentials = (LoginCredentials) session.getAttribute("credentials");
//        boolean okToBeAdded = false;
//        ProcessedForm form;
//        List<Cookie> cookies;
//
//        form = this.formService.getById(newResponse.getFormId());
//        if (form != null) {
//            for (Question q : form.getFields()) { //check if question is part of form
//                if (q.getId().equals(newResponse.getQuestionId())) {
//                    okToBeAdded = true;
//                    break;
//                }
//            }
//            Question question = form.getQuestionById(newResponse.getQuestionId());
//            if (question != null) {
//                Object[] validAnswers = question.getValue();
//                String[] stringValidAnswers = new String[question.getValue().length];
//                for (int i = 0; i < validAnswers.length; i++) {
//                    stringValidAnswers[i] = validAnswers[i].toString().substring(validAnswers[i].toString().indexOf('=') + 1, validAnswers[i].toString().length() - 1);
//                }
//
//
//                if (!isIn(stringValidAnswers, newResponse.getAnswers()))
//                    okToBeAdded = false;
//                if (okToBeAdded) {
//                    if (credentials != null) {
//                        newResponse.setCreatedBy(credentials.getEmail());
//                    }
//                    cookies = Arrays.asList(request.getCookies());
//                    if (!formWasChanged(cookies, form)) {
//                        savedResponse = this.service.save(newResponse);
//                        service.notifyOwner(savedResponse.getFormId());
//                        cookies.forEach(response::addCookie);
//                        return new ResponseEntity<>(savedResponse, HttpStatus.CREATED);
//                    }
//                    return new ResponseEntity<>("The completed form was edited by owner while you were completing.", HttpStatus.CONFLICT);
//                }
//                return new ResponseEntity<>("Some resources could not be added", HttpStatus.CONFLICT);
//            }
//            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>("Requested form not found", HttpStatus.NOT_FOUND);
//    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity addResponse(HttpServletRequest request, HttpServletResponse response, @Valid @RequestBody ProcessedForm formResponse) {
        HttpSession session = request.getSession(true);
        LoginCredentials credentials = (LoginCredentials) session.getAttribute("credentials");
        List<Cookie> cookies = Arrays.asList(request.getCookies());
        Response savedResponse, toSaveResponse;
        ProcessedForm form;
        Boolean formWasEdited;

        form = formService.getById(formResponse.getId());
        if (form != null) {
            toSaveResponse = new Response(form).setCreatedAt(new Date());
            if (credentials != null) {
                toSaveResponse.setCreatedBy(credentials.getEmail());
            }
            formWasEdited = formWasChanged(cookies, form);
            if (formWasEdited == null) {
                return new ResponseEntity<>("You must make a request for the form that you respond to", HttpStatus.FORBIDDEN);
            }
            if (!formWasEdited) {
                savedResponse = this.service.save(toSaveResponse);
                service.notifyOwner(savedResponse.getForm().getId());
                cookies.forEach(response::addCookie);
                return new ResponseEntity<>(savedResponse, HttpStatus.CREATED);
            }
            cookies.forEach(response::addCookie);
            return new ResponseEntity<>("The completed form was edited by owner while you were completing.", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Form not found", HttpStatus.NOT_FOUND);
    }

//    @RequestMapping(value = "{id}", method = RequestMethod.GET)
//    public ResponseEntity<Statistic> get(@PathVariable("id") String id) {
//        //System.out.println(id);
//        ProcessedForm form = this.formService.getById(id);
//        //System.out.println(form.getId());
//        Statistic statistics = new Statistic();
//        //TODO create a class that extends Map<String, Map<String, Integer>>
//        Map<String, Map<String, Integer>> finalResult = new HashMap<>();
//        List<Response> Responses = this.service.getAll();
//        statistics.setStatistics(finalResult);
//        //System.out.println(form.getId());
//        for (Response Response : Responses) {
//            //System.out.println("ID: " + Response.getFormId());
//            if (Response.getFormId().equals(id)) {
//                //System.out.println(Response.getId() + " " + Response.getQuestionType() + " " + Response.getQuestionId());
//                Object[] ans = Response.getAnswers();
//                for (int i = 0; i < ans.length; i++) {
//                    if (form.getQuestionById(Response.getQuestionId()) != null) {
//                        if (finalResult.containsKey(form.getQuestionById(Response.getQuestionId()).getTitle())) {
//                            Map<String, Integer> aux = finalResult.get(form.getQuestionById(Response.getQuestionId()).getTitle());
//                            if (aux.containsKey(ans[i].toString()))
//                                aux.put(ans[i].toString(), aux.get(ans[i].toString()) + 1);
//                            else aux.put(ans[i].toString(), 1);
//                            finalResult.put(form.getQuestionById(Response.getQuestionId()).getTitle(), aux);
//                        } else {
//                            Map<String, Integer> aux = new HashMap<>();
//                            if (aux.containsKey(ans[i].toString()))
//                                aux.put(ans[i].toString(), aux.get(ans[i].toString()) + 1);
//                            else aux.put(ans[i].toString(), 1);
//                            finalResult.put(form.getQuestionById(Response.getQuestionId()).getTitle(), aux);
//                        }
//                    }
//                }
//            }
//        }
//        statistics.setStatistics(finalResult);
//        for (String key : statistics.getStatistics().keySet()) {
//            int total = 0;
//            for (String s : statistics.getStatistics().get(key).keySet())
//                total += statistics.getStatistics().get(key).get(s);
//            Map<String, Integer> aux = statistics.getStatistics().get(key);
//            for (String s : statistics.getStatistics().get(key).keySet()) {
//                //System.out.println(aux.get(s));
//                aux.put(s, aux.get(s) * 100 / total);
//            }
//        }
//        if (statistics.getStatistics().isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity(statistics, HttpStatus.OK);
//    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity updateFormResponse(@Valid @RequestBody Response formResponse) {
        Response savedResponse = service.getById(formResponse.getId());

        if (savedResponse != null) {
            formResponse.setCreatedBy(savedResponse.getCreatedBy());
            formResponse.setCreatedAt(new Date());
            formResponse = service.save(formResponse);
            return new ResponseEntity<>(formResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>("Response does not exist", HttpStatus.NOT_FOUND);
    }

    private Boolean formWasChanged(List<Cookie> cookies, ProcessedForm form) {
        int formCompletingCookieIndex = -1;
        Cookie formCompletingCookie;
        Date startCompletingTime;
        Date formLastModifiedTime;
        String formCompletingCookieTime;
        Long startTime;

        for (int index = 0; index < cookies.size() && formCompletingCookieIndex == -1; ++index) {
            if (cookies.get(index).getName().equals(form.getId())) {
                formCompletingCookieIndex = index;
            }
        }
        if (formCompletingCookieIndex != -1) {
            formCompletingCookie = cookies.get(formCompletingCookieIndex);
            formCompletingCookieTime = formCompletingCookie.getValue();
            startTime = Long.parseLong(formCompletingCookieTime);
            startCompletingTime = new Date(startTime);
            formLastModifiedTime = form.getLastModifiedTime();
            markCookieAsGoodToDestroy(formCompletingCookie);
            return startCompletingTime.compareTo(formLastModifiedTime) < 0;
        }
        return null;
    }

    private void markCookieAsGoodToDestroy(Cookie cookie) {
        cookie.setMaxAge(0);
        cookie.setValue(null);
        cookie.setPath("/v1/responses/add");
    }
}