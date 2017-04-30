# Format of FormTemplateGenerator
### Used to send to the server a form's template

- as classes: 
```typescript
class FormTemplateGenerator {
  public owner: string;
  public form : Form;
}

class Form {
  public title : string;
  public description : string;
  public fields : Field[]
}
class Field {
  title : string;
  description : string;
  type : string;
  required : boolean;
  value : any;
  options: Object;
}
````
- as JSON:

```json
{
  "owner" : "",
  "form" : {
    "title" : "",
    "description" : "",
    "fields" : [
      {
        "title" : "",
        "description" : "",
        "type" : "",
        "required" : "",
        "value" : "",
        "options" : { }
      }
    ]
  }
}
```

### Explaining the fields:

- type : shortText, longText, singleChoice, multipleChoice, date, linearScale
- required : true/false
- value :
  + shortText, longText, date : null
  + singleChoice, multipleChoice: Array\<String\>;
  + linearScale : Map\<Pair\<String, Integer\>\> (2 keys: min, max)
- options :
  + shortText : Pair\<String, String\> ("regex" : "")
  + longText : Pair\<String, Integer\> ("maxLength" : Integer)
  + date, singleChoice, multipleChoice : null
