package controllers;

import models.dao.FormDAO;
import models.dao.ResponseDAO;
import models.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
public class TestController {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ResponseDAO responseDAO;

    @Autowired
    private FormDAO formDAO;
}
