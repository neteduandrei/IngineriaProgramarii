# Developer notes

## Data Transfer Objects (DTO)

This objects are used to fetch and update data on the server

### AccountInfoDTO

```
AccountInfoDTO {
	email: String;
	name: String;

}
```


### UserDTO 

```
UserDTO {
	name: String
	email: String
	nickname: String
	password: String
	role: String
}
```

### FormDTO

```
FormDTO {
	title: String
	description: String
	font: String
	fields: QuestionDTO[]
}
```


### QuestionDTO

```
QuestionDTO {
	title: String
	description: String
	type: String
	required: Boolean
	options: Object
}
```


### FormResponseDTO

```
FormResponseDTO {
	formId: Integer
	fields: QuestionResponseDTO[]
}
```


### QuestionResponseDTO

```
QuestionResponseDTO {
	questionId: Integer
	values: String[]
}
```


### DownloadedFormDTO

```
DownloadedFormDTO {
	id: String
		
}
```
