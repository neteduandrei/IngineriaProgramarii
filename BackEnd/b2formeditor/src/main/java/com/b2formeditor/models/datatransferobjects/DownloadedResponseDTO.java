package com.b2formeditor.models.datatransferobjects;

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.responsemodels.ProcessedForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public class DownloadedResponseDTO {
	class CsvTable {
		private String content;

		public void appendRow(List<String> row) {
			// iterate through all the elements and append them
			// we need an index instead of simple iteration because
			// we don't want to append the last comma
			for (int ind = 0; ind < row.size() - 1; ind++) {
				content = content.concat(row.get(ind));
				content = content.concat(",");
			}
			// append the last element and a new line
			content = content.concat(row.get(row.size() - 1));
			content = content.concat("\n");
		}
	};

    private String id;
	private String content;

 /*   public DownloadedResponseDTO(Form form) {
        QuestionDTO[] questions ; //= form.getFields();

		// Create a 2D matrix where we store aur responses.
		// Multi choice responses will be stored as val1|val2|val3|...|valn
		CsvTable csvTable;

		// append the header first
		List<String> headerRow = new ArrayList<String>();
        for (QuestionDTO question : questions) {
				headerRow.add(question.getValue());
        }
		csvTable.appendRow(headerRow);

		// iterate through the answers and append all elements
		//for (Response response : )
    }*/

    public String getId() {
        return id;
    }

    public DownloadedResponseDTO setFormId(String formId) {
        this.id = formId;
        return this;
    }
}
