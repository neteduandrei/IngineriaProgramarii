package com.b2formeditor.controllers;

import com.b2formeditor.models.datatransferobjects.DownloadedFormDTO;
import com.b2formeditor.models.responsemodels.ProcessedForm;
import com.b2formeditor.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dorneanu Dragos-Andrei on 02.05.2017.
 */
@RestController
@RequestMapping("/v1/download")
public class DownloadFileController {
    @Autowired
    private FormService service;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<DownloadedFormDTO> sendFile(@PathVariable("id") String id) {
        ProcessedForm form = service.getById(id);
        DownloadedFormDTO responseForm;

        if (form != null) {
            responseForm = new DownloadedFormDTO(form);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=form" + form.getId() + ".json")
                    .body(responseForm);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
