# Developer notes

## Database models and generic objects

### User

```
User: {
	id: String
	email: String
	nickname: String
	password: String
	role: String
	service: String
	refreshToken: String
	accessToken: String
}
```

### Form

```
Form: {
	id: String
	createdBy: String
	createdAt: Date
	lastModifiedTime: Date
	title: String
	description: String
	font: String
	questionsInfo: FormQuestion[]
}
```

### FormQuestion

```
FormQuestion: {
	id: String
	required: Boolean
}
```

### Question

```
Question: {
	id: String
	title: String
	description: String
	type: String
	options: Object
	values: String[]
}
```

### Response

```
FormResponse: {
	id: String
	formId: String
	createdBy: String
	createdAt: Date
	fields: QuestionResponse[]	
}
```

### QuestionResponse

```
QuestionResponse: {
	questionId: String
	values: String[]
}	
```

### AutenticationCredentials

```
AutenticationCredentials: {
	email: String
	password: String
}
```

### LoginCredentials

```
LoginCredentials: {
	email: String
	password: String
}
```

### SignUpCredentials

```
SignUpCredentials: {
	email: String
	password: String
	role: String
}
```

## Processed Response Objects - GET REQUEST

This objects are used to fetch data on the server

### ProcessedForm

```
ProcessedForm: {
	id: String
	title: String
	description: String
	fort: String
	lastModifiedTime: Date 
	createdAt: Date
	createdBy: String
	fields: ProcessedQuestion[]
}
```

### ProcessedQuestion

```
ProcessedQuestion: {
	id: String
	title: String
	description: String
	type: String
	options: Object
	values: String[]
	required: Boolean
}
```


### ProcessedFormResponse

```
ProcessedFormResponse: {
	id: String
	formId: String
	createdBy: String
	createdAt: Date
	fields: ProcessedQuestionResponse[]		
}
```


### ProcessedQuestionResponse

```
ProcessedQuestionResponse: {
	questionId: String
	values: String[]
	title: String
	description: String
	type: String
	options: Object
	values: String[]
}
```

### ProcessedLoginCredentials

```
ProcessedLoginCredentials: {
	email: String
	password: String
	role: String
}
```

## Data Transfer Objects (DTO) - POST AND PUT REQUEST

This objects are used to update data on the server

### AccountInfoDTO

```
AccountInfoDTO: {
	email: String;
	name: String;
}
```


### UserDTO 

```
UserDTO: {
	name: String
	email: String
	nickname: String
	password: String
	role: String
}
```

### FormDTO

```
FormDTO: {
	title: String
	description: String
	font: String
	fields: QuestionDTO[]
}
```


### QuestionDTO

```
QuestionDTO: {
	title: String
	description: String
	type: String
	required: Boolean
	options: Object
	values: String[]
}
```


### FormResponseDTO

```
FormResponseDTO: {
	formId: Integer
	fields: QuestionResponseDTO[]
}
```


### QuestionResponseDTO

```
QuestionResponseDTO: {
	questionId: Integer
	values: String[]
}
```


### DownloadedFormDTO

```
DownloadedFormDTO: {
	id: String
}
```
