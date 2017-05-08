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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Dorneanu Dragos-Andrei on 02.05.2017.
 */
@RequestMapping("/v1/download")
public class DownloadFileController {
    @Autowired
    private FormService service;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<ProcessedForm> sendFile(HttpServletResponse response, @PathVariable("id") String id) {
        /*OutputStream out;
        ByteArrayOutputStream byteForm = null;
        ObjectOutputStream formStream = null;*/
        ProcessedForm form = service.getById(id);
        Form responseForm;

        if (form != null) {
            //return Form
            return new ResponseEntity<>(form, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        /*if (form != null) {
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
        return new ResponseEntity(HttpStatus.NOT_FOUND);*/
        /*try {
            if (form != null) {
                if (!Files.exists(Paths.get(form.getId()))) {
                    form.buildJsonFile();
                }
                formFile = new UrlResource(form.getId());
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + formFile.getFilename() + "\"")
                        .body(formFile);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (MalformedURLException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.UPGRADE_REQUIRED);
        }*/
    }
}
