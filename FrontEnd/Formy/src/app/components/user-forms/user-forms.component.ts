import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'formy-user-forms',
  templateUrl: './user-forms.component.html',
  styleUrls: ['./user-forms.component.scss'],
  host: {
    class:'page'
  }
})
export class UserFormsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
