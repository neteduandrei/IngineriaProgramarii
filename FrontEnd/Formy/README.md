# How to run the project

## First time use:
+ On Windows:
  + open cmd as administrator and run:
  ```npm
  npm install -g @angular/cli
  ```
  + open cmd in normal mode and go to directory Formy and type:
  ```npm
  npm install
  ```
+ On linux:
  + open terminal and run:
  ```npm
  sudo npm install -g @angular/cli
  ```
  + change directory to Formy and type:
  ```npm
  npm install
  ```
  
## Normal use
+ on any platform open a terminal and go to Formy directory and run:
  ```npm
  ng serve
  ```
  
> ##### !Important: some warnings regarding angular cli might appear or some dependencies unmet error, they're normal and don't cause any trouble
> ##### !Important 2:  the projects takes roughly 20 seconds to 1 minute to compile
---
# Communication standard
## Template Used to send to the server a form's template

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

#### Explaining the fields:

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


## Template used when receiving the template from the server

- classes :
```typescript
class FormTemplateToFill {
  public id : string;
  public form : Form;
}
/* The others are like above */
```
