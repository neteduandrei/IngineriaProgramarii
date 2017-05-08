package com.b2formeditor.controllers;

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.responsemodels.ProcessedForm;
import com.b2formeditor.services.FormService;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Dorneanu Dragos-Andrei on 02.05.2017.
 */
@RestController
@RequestMapping("/v1/download")
public class DownloadFileController {
    @Autowired
    private FormService service;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<ProcessedForm> sendFile(HttpServletResponse response, @PathVariable("id") String id) {
        ProcessedForm form = service.getById(id);
        Form responseForm;

        if (form != null) {
            //here we must return Form after refactor controllers, database models and response models
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"form" + form.getId() + ".txt\"")
                    .body(form);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
