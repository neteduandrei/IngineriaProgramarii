package com.b2formeditor.models.databasemodels;

import com.b2formeditor.models.basemodels.BaseForm;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

@Document(collection = "Forms")
public class Form extends BaseForm {
}
