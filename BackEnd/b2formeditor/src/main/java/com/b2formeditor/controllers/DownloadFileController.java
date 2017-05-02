package com.b2formeditor.controllers;

import com.b2formeditor.models.responsemodels.ProcessedForm;
import com.b2formeditor.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Dorneanu Dragos-Andrei on 02.05.2017.
 */
@RequestMapping("/v1/download")
public class DownloadFileController {
    @Autowired
    private FormService service;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity sendFile(HttpServletResponse response, @PathVariable("id") String id) {
        OutputStream out;
        ByteArrayOutputStream byteForm = null;
        ObjectOutputStream formStream = null;
        ProcessedForm form = service.getById(id);

        response.setContentType("application/json");
        if (form != null) {
            try {
                out = response.getOutputStream();
                byteForm = new ByteArrayOutputStream();
                formStream = new ObjectOutputStream(byteForm);
                formStream.writeObject(form);
                out.write(byteForm.toByteArray());
                out.flush();
                return new ResponseEntity(HttpStatus.OK);
            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity(HttpStatus.UPGRADE_REQUIRED);
            }
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
