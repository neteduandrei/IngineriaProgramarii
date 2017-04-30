import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'formy-type-short-text',
  templateUrl: './type-short-text.component.html',
  styleUrls: ['./type-short-text.component.scss']
})
export class TypeShortTextComponent implements OnInit {

  public constraintRegexTemplate : string;
  public constraintRegex : string;
  public testRegex : string;
  public isRegexValid : boolean;

  constructor() {
    this.isRegexValid = true;
  }

  ngOnInit() {
  }

  public verifyRegex() {
    console.log('here');
    try {
      let regex = new RegExp(this.constraintRegexTemplate);
      this.constraintRegex = this.constraintRegexTemplate;
      this.isRegexValid = true;
    }
    catch (e) {
      this.isRegexValid = false;
      console.log(e);
    }
  }

}
